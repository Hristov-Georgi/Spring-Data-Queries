package springDataQueriesLab.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import springDataQueriesLab.entities.Ingredient;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String ingredientName);

    List<Ingredient> findByNameInOrderByNameAsc(List<String> ingredientNames);

    @Transactional
    @Modifying
    @Query("DELETE FROM Ingredient i WHERE i.name = :name")
    int deleteByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient i SET i.price = i.price * 1.1")
    void increasePriceBy10Percents();

    @Modifying
    @Transactional
    @Query("UPDATE Ingredient i SET i.price = (i.price + (i.price * :increment)) WHERE i.name IN :names")
    void increasePriceForListOfIngredients(@Param("increment") BigDecimal increment, @Param("names") List<String> names);

}
