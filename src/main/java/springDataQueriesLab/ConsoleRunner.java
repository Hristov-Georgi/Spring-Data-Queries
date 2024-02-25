package springDataQueriesLab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springDataQueriesLab.services.IngredientService;
import springDataQueriesLab.services.ShampooService;

import java.util.ArrayList;
import java.util.List;
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






//        09
//        String ingredientName = scanner.nextLine();
//        System.out.println(ingredientService.deleteByName(ingredientName));
//
//        08
//        int numberOfIngredients = Integer.parseInt(scanner.nextLine());
//        shampooService.selectByIngredientSizeLessThan(numberOfIngredients)
//                .forEach(s -> System.out.println(s.getBrand()));

//        07
//        List<String> ingredientsNameList = new ArrayList<>();
//
//        while (scanner.hasNextLine()) {
//            String input = scanner.nextLine();
//
//            if (input.isBlank()) {
//                break;
//            }
//
//            ingredientsNameList.add(input);
//        }
//
//        shampooService.selectByIngredients(ingredientsNameList)
//                .forEach(s -> System.out.println(s.getBrand()));


//        06
//        Double price = Double.parseDouble(scanner.nextLine());
//        System.out.println(shampooService.selectCountByPriceLessThan(price));

//        05
//        List<String> names = new ArrayList<>();
//        while (scanner.hasNextLine()) {
//            String input = scanner.nextLine();
//
//            if (input.isBlank()) {
//                break;
//            }
//
//            names.add(input);
//        }
//
//        this.ingredientService.selectByNameIn(names)
//                .forEach(System.out::println);

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
