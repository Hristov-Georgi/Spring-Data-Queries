package springDataQueriesExercises;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springDataQueriesExercises.service.AuthorService;
import springDataQueriesExercises.service.BookService;
import springDataQueriesExercises.service.SeedDatabase;

import java.util.Scanner;


@Component
public class Runner implements CommandLineRunner {

    private final SeedDatabase seedDatabase;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public Runner(SeedDatabase seedDatabase, BookService bookService, AuthorService authorService) {
        this.seedDatabase = seedDatabase;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);



//        13
//        int copies = Integer.parseInt(scanner.nextLine());
//
//        int deletedBooks = bookService.deleteByCopiesLessThan(copies);
//        System.out.println(deletedBooks + " books were deleted from database");

//        12
//        String date = scanner.nextLine();
//        int copies = Integer.parseInt(scanner.nextLine());
//
//        int updatedBooks = bookService.addCopiesAfterReleaseDate(date, copies);
//
//        System.out.printf("%d books are released after %s, so total of %d book copies were added\n",
//                updatedBooks, date, updatedBooks * copies);

//        11
//        ReducedBook book = bookService.selectBookByTitleEditionAgeRestrictionPrice("Things Fall Apart");
//
//        System.out.printf("%s %s %s %.2f\n", book.getTitle(), book.getEditionType(),
//                book.getAgeRestriction(), book.getPrice());


//        10
//        long copiesSum = bookService.sumCopiesByAuthorNames("Randy", "Graham");
//        System.out.println(copiesSum);

//        09
//        int length = Integer.parseInt(scanner.nextLine());
//        int booksCount = bookService.countBookWithTitleLongerThan(length);
//
//        System.out.printf("There are %d books with longer title than %d symbols\n", booksCount, length);


//        08
//        String pattern = scanner.nextLine();
//        bookService.selectByAuthorLastNameStartingWith(pattern)
//                .forEach(b -> System.out.printf("%s (%s %s)\n",
//                        b.getTitle(),
//                        b.getAuthor().getFirstName(),
//                        b.getAuthor().getLastName()));

//        07
//        String strPattern = scanner.nextLine();
//        bookService.selectByTitleContaining(strPattern)
//                .forEach(System.out::println);

//        06
//        String endsWith = scanner.nextLine();
//        authorService.selectByFirstNameEndingWith(endsWith)
//                .forEach(a -> System.out.printf("%s %s\n", a.getFirstName(), a.getLastName()));

//        05
//        String date = scanner.nextLine();
//        bookService.selectByReleaseDateBefore(date)
//                .forEach(b -> System.out.printf("%s %.2f\n", b.getTitle(), b.getPrice()));

//        04
//        int year = Integer.parseInt(scanner.nextLine());
//        bookService.selectTitlesNotReleasedInYear(year)
//                .forEach(System.out::println);

//        03
//        bookService.selectTitlesByPriceLessThanOrGreaterThan(5, 40)
//                .forEach(b -> System.out.printf("%s - $%.2f\n", b.getTitle(), b.getPrice()));

//        02
//        bookService.selectByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
//                .forEach(System.out::println);

//        01
//        String ageRestriction = scanner.nextLine();
//        bookService.selectTitlesByAgeRestriction(ageRestriction)
//                .forEach(System.out::println);


//        seedDatabase.seedAll();

    }


}
