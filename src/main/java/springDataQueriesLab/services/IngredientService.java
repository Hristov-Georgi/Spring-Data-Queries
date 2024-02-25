package springDataQueriesLab.services;

import springDataQueriesLab.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> selectByNameStartsWith(String ingredientName);


}
