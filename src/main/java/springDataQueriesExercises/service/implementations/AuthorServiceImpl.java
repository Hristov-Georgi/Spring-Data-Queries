package springDataQueriesExercises.service.implementations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springDataQueriesExercises.entities.Author;
import springDataQueriesExercises.repositories.AuthorRepository;
import springDataQueriesExercises.service.AuthorService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {

        long authorsNumber = authorRepository.count();

        Random rnd = new Random();
        long authorId = rnd.nextInt((int) authorsNumber) + 1;

        if(authorRepository.findById(authorId).isEmpty()) {
            getRandomAuthor();
        }
        return authorRepository.findById(authorId).get();
    }

    @Override
    public void registerAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public List<Author> selectByFirstNameEndingWith(String endsWith) {

        return authorRepository.findByFirstNameEndingWith(endsWith);
    }


}
