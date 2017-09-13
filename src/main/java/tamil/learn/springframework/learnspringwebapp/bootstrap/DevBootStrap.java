/* Created by Murugan_Nagarajan on 9/14/2017 */
package tamil.learn.springframework.learnspringwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tamil.learn.springframework.learnspringwebapp.model.Author;
import tamil.learn.springframework.learnspringwebapp.model.Book;
import tamil.learn.springframework.learnspringwebapp.repository.AuthorRepository;
import tamil.learn.springframework.learnspringwebapp.repository.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author martin = new Author("Marting Fowler");
        Book eaa = new Book("Patterns of Enterprise Application Architecture", 68734839);
        eaa.getAuthors().add(martin);

        authorRepository.save(martin);
        bookRepository.save(eaa);

        Author craig = new Author("Craig Walls");
        Author john = new Author("John Thomas");
        Book sia = new Book("Spring In Action", 89049469);
        sia.getAuthors().add(craig);
        sia.getAuthors().add(john);

        authorRepository.save(craig);
        authorRepository.save(john);
        bookRepository.save(sia);
    }
}
