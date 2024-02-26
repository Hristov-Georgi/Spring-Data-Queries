package springDataQueriesExercises.service;


import springDataQueriesExercises.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();

    void registerCategory(Category category);
}
