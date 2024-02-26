package springDataQueriesLab.services;

import springDataQueriesLab.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> selectByNameStartsWith(String ingredientName);

    List<Ingredient> selectByNameIn(List<String> ingredientNames);

    int deleteByName(String name);

    void increaseIngredientsPriceBy10Percent();

    void increasePriceOfIngredientsInList(Double percentage, List<String> namesList);
}
