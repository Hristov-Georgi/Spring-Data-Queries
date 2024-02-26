package springDataQueriesExercises.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springDataQueriesExercises.entities.AgeRestriction;
import springDataQueriesExercises.entities.Book;
import springDataQueriesExercises.entities.EditionType;

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


}
