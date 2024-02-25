package springDataQueriesLab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springDataQueriesLab.entities.Shampoo;
import springDataQueriesLab.entities.Size;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySize(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, Long id);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    int countByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients i WHERE i.name IN :ingredientNameList")
    List<Shampoo> findByIngredientsIn(List<String> ingredientNameList);

    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :number")
    List<Shampoo> findByIngredientsCountLessThan(int number);


}
