package springDataQueriesLab.services;

import springDataQueriesLab.entities.Shampoo;

import java.util.List;

public interface ShampooService {

    List<Shampoo> selectAllShampoosBySize(String size);

    List<Shampoo> selectBySizeAndLabelId(String size, Long id);

    List<Shampoo> selectMoreExpensiveByPrice(Double price);
}
