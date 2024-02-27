package springDataQueriesExercises.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springDataQueriesExercises.entities.AgeRestriction;
import springDataQueriesExercises.entities.Book;
import springDataQueriesExercises.entities.EditionType;
import springDataQueriesExercises.notEntity.ReducedBook;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal lessThanPrice, BigDecimal greaterThanPrice);

    List<Book> findByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findByReleaseDateBefore(LocalDate localDate);

    List<Book> findByTitleContaining(String contains);

    List<Book> findByAuthorLastNameStartingWith(String strPattern);

    @Query("SELECT COUNT(b) FROM Book AS b WHERE length(b.title) > :length")
    int countBooksWithTitleLongerThan(@Param("length") int length);

    @Query("SELECT SUM(b.copies) FROM Book b" +
            " JOIN b.author a" +
            " WHERE a.firstName = :firstName AND a.lastName = :lastName")
    long sumCopiesByAuthorFirstNameIsAndAuthorLastNameIs(@Param("firstName") String firstName,
                                                         @Param("lastName") String lastName);

    @Query("SELECT b.title AS title, b.editionType AS editionType," +
            " b.ageRestriction as ageRestriction, b.price AS price" +
            " FROM Book b" +
            " WHERE b.title = :bookName")
    ReducedBook findBookByTitleEditionAgeRestrictionPrice(String bookName);

    @Modifying
    @Transactional
    @Query("UPDATE FROM Book b" +
            " SET b.copies = b.copies + :copiesNumber" +
            " WHERE b.releaseDate > :localDate")
    int updateBooksByAddingCopiesAfterReleaseDate(@Param("localDate") LocalDate localDate,
                                                  @Param("copiesNumber") int copiesNumber);

    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.copies < :copies")
    int deleteByCopiesLessThan(int copies);

}
