package springDataQueriesLab.services;

import springDataQueriesLab.entities.Shampoo;

import java.util.List;

public interface ShampooService {

    List<Shampoo> selectAllShampoosBySize(String size);

    List<Shampoo> selectBySizeAndLabelId(String size, Long id);

    List<Shampoo> selectMoreExpensiveByPrice(Double price);

    int selectCountByPriceLessThan(Double price);

    List<Shampoo> selectByIngredients(List<String> ingredientNameList);

    List<Shampoo> selectByIngredientSizeLessThan(int number);
}
