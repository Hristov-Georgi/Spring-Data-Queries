package springDataQueriesLab.services.serviceImpl;

import org.springframework.stereotype.Service;
import springDataQueriesLab.entities.Ingredient;
import springDataQueriesLab.repositories.IngredientRepository;
import springDataQueriesLab.services.IngredientService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    protected IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> selectByNameStartsWith(String ingredientName) {
        return ingredientRepository.findByNameStartingWith(ingredientName);
    }

    @Override
    public List<Ingredient> selectByNameIn(List<String> ingredientNames) {
        return ingredientRepository.findByNameInOrderByNameAsc(ingredientNames);
    }

    @Override
    public int deleteByName(String name) {
        return ingredientRepository.deleteByName(name);
    }

    @Override
    public void increaseIngredientsPriceBy10Percent() {
        ingredientRepository.increasePriceBy10Percents();
    }

    @Override
    public void increasePriceOfIngredientsInList(Double percentage, List<String> namesList) {
        BigDecimal rise = BigDecimal.valueOf(percentage / 100);

        ingredientRepository.increasePriceForListOfIngredients(rise, namesList);
    }
}
