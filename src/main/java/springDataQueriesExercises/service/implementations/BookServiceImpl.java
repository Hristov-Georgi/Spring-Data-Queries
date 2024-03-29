package springDataQueriesExercises.service.implementations;


import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDataQueriesExercises.entities.AgeRestriction;
import springDataQueriesExercises.entities.Book;
import springDataQueriesExercises.entities.EditionType;
import springDataQueriesExercises.notEntity.ReducedBook;
import springDataQueriesExercises.repositories.BookRepository;
import springDataQueriesExercises.service.BookService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void registerBook(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public List<String> selectTitlesByAgeRestriction(String ageRestriction) {
        AgeRestriction restriction = AgeRestriction.valueOf(ageRestriction.toUpperCase());

        return bookRepository.findByAgeRestriction(restriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectByEditionTypeAndCopiesLessThan(EditionType editionType, int copies) {
        return bookRepository.findByEditionTypeAndCopiesLessThan(editionType, copies)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> selectTitlesByPriceLessThanOrGreaterThan(double lessThanPrice, double greaterThanPrice) {
        BigDecimal lowerPrice = BigDecimal.valueOf(lessThanPrice);
        BigDecimal higher = BigDecimal.valueOf(greaterThanPrice);

        return bookRepository.findByPriceLessThanOrPriceGreaterThan(lowerPrice, higher);
    }

    @Override
    public List<String> selectTitlesNotReleasedInYear(int year) {
        LocalDate before = LocalDate.of(year, 01, 01);
        LocalDate after = LocalDate.of(year, 12, 31);

        return bookRepository.findByReleaseDateBeforeOrReleaseDateAfter(before, after)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> selectByReleaseDateBefore(String date) {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date, dateFormat);

        return bookRepository.findByReleaseDateBefore(localDate);
    }

    @Override
    public List<String> selectByTitleContaining(String contains) {

        return bookRepository.findByTitleContaining(contains)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> selectByAuthorLastNameStartingWith(String strPattern) {

        return bookRepository.findByAuthorLastNameStartingWith(strPattern);
    }

    @Override
    public int countBookWithTitleLongerThan(int length) {
        return bookRepository.countBooksWithTitleLongerThan(length);
    }

    @Override
    public long sumCopiesByAuthorNames(String firstName, String lastName) {
        return bookRepository.sumCopiesByAuthorFirstNameIsAndAuthorLastNameIs(firstName, lastName);
    }

    @Override
    public ReducedBook selectBookByTitleEditionAgeRestrictionPrice(String bookTitle) {
        return bookRepository.findBookByTitleEditionAgeRestrictionPrice(bookTitle);
    }

    @Override
    public int addCopiesAfterReleaseDate(String releaseDate, int copies) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern("dd MMM yyyy")
                .toFormatter(Locale.US);

        LocalDate date = LocalDate.parse(releaseDate, formatter);

        return bookRepository.updateBooksByAddingCopiesAfterReleaseDate(date, copies);
    }

    @Override
    public int deleteByCopiesLessThan(int copies) {
        return bookRepository.deleteByCopiesLessThan(copies);
    }
}
