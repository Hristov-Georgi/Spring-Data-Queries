package springDataQueriesLab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springDataQueriesLab.services.IngredientService;
import springDataQueriesLab.services.ShampooService;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);



//        04
//        String ingredient = scanner.nextLine();
//        this.ingredientService.selectByNameStartsWith(ingredient)
//                .forEach(System.out::println);


//        03
//        Double price = Double.parseDouble(scanner.nextLine());
//        this.shampooService.selectMoreExpensiveByPrice(price)
//                .forEach(System.out::println);

//        02
//        String size = scanner.nextLine();
//        Long id = Long.parseLong(scanner.nextLine());
//        this.shampooService.findBySizeAndLabelId(size, id)
//                .forEach(System.out::println);

//        01
//        String shampooSize = scanner.nextLine();
//        this.shampooService.findAllShampoosBySize(shampooSize)
//                .forEach(System.out::println);


    }
}
