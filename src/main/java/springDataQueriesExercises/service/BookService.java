package springDataQueriesExercises.service;


import springDataQueriesExercises.entities.Book;
import springDataQueriesExercises.entities.EditionType;
import springDataQueriesExercises.notEntity.ReducedBook;

import java.util.List;

public interface BookService {

    void registerBook(Book book);

    List<String> selectTitlesByAgeRestriction(String ageRestriction);

    List<String> selectByEditionTypeAndCopiesLessThan(EditionType editionType, int copies);

    List<Book> selectTitlesByPriceLessThanOrGreaterThan(double lessThanPrice, double greaterThanPrice);

    List<String> selectTitlesNotReleasedInYear(int year);

    List<Book> selectByReleaseDateBefore(String date);

    List<String> selectByTitleContaining(String contains);

    List<Book> selectByAuthorLastNameStartingWith(String strPattern);

    int countBookWithTitleLongerThan(int length);

    long sumCopiesByAuthorNames(String firstName, String lastName);

    ReducedBook selectBookByTitleEditionAgeRestrictionPrice(String bookTitle);

    int addCopiesAfterReleaseDate(String releaseDate, int copies);

    int deleteByCopiesLessThan(int copies);
}
