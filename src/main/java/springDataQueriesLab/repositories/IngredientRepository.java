package springDataQueriesLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springDataQueriesLab.entities.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String ingredientName);
}
