package springDataQueriesLab.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import springDataQueriesLab.entities.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String ingredientName);

    List<Ingredient> findByNameInOrderByNameAsc(List<String> ingredientNames);

    @Transactional
    @Modifying
    @Query("DELETE FROM Ingredient i WHERE i.name = :name")
    int deleteByName(String name);

}
