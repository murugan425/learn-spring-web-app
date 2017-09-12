/* Created by Murugan_Nagarajan on 9/13/2017 */
package tamil.learn.springframework.learnspringwebapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private Integer bookISBN;
    private String bookName;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(Integer bookId) {
        this.bookId = bookId;
    }

    public Book(Integer bookId, Integer bookISBN, String bookName, Set<Author> authors) {
        this.bookId = bookId;
        this.bookISBN = bookISBN;
        this.bookName = bookName;
        this.authors = authors;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(Integer bookISBN) {
        this.bookISBN = bookISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return bookId.equals(book.bookId) && bookISBN.equals(book.bookISBN);
    }

    @Override
    public int hashCode() {
        int result = bookId.hashCode();
        result = 31 * result + bookISBN.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookISBN=" + bookISBN +
                ", bookName='" + bookName + '\'' +
                ", authors=" + authors +
                '}';
    }
}
