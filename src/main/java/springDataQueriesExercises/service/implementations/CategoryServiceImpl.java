package springDataQueriesExercises.service.implementations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDataQueriesExercises.entities.Category;
import springDataQueriesExercises.repositories.CategoryRepository;
import springDataQueriesExercises.service.CategoryService;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random rnd = new Random();
        Set<Long> categoryIdHashSet = new HashSet<>();

        long totalCategories = categoryRepository.count();

        int categoriesPerBook = rnd.nextInt((int) totalCategories) + 1;

        for (int i = 0; i < categoriesPerBook; i++) {
            long singleCategory = rnd.nextInt((int) totalCategories) + 1;

            if (categoryRepository.findById(singleCategory).isPresent()) {

                categoryIdHashSet.add(singleCategory);
            }
        }

        return new HashSet<>(categoryRepository.findAllById(categoryIdHashSet));
    }

    @Override
    public void registerCategory(Category category) {
        categoryRepository.save(category);
    }
}
