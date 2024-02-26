package springDataQueriesExercises.service;


import springDataQueriesExercises.entities.Author;

import java.util.List;

public interface AuthorService {
    Author getRandomAuthor();

    void registerAuthor(Author author);

    List<Author> selectByFirstNameEndingWith(String endsWith);


}
