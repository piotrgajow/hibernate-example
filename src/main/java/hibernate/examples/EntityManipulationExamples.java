package hibernate.examples;

import hibernate.entities.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class EntityManipulationExamples {

    private Session session;

    public EntityManipulationExamples(Session session) {
        this.session = session;
    }

    public Book findBookById(Long id) {
        return session.get(Book.class, id);
    }

    public List<Book> findAllBooks() {
        Query<Book> query = session.createQuery("from Book", Book.class);
        return query.list();
    }

    public List<Book> findBooksByPageCountGraterThan150() {
        Query<Book> query = session.createQuery("from Book where numberOfPages > 150", Book.class);
        return query.list();
    }

    public List<Book> findBooksByParametrizedPageCount(Integer pageCount) {
        Query<Book> query = session.createQuery("from Book where numberOfPages >= :pages", Book.class);
        query.setParameter("pages", pageCount);
        return query.list();
    }

    public Book createNewBook() {
        Book book = new Book();
        book.setTitle("New book");
        book.setHasHardCover(false);
        book.setNumberOfPages(15);
        book.setReleaseDate(LocalDate.of(2020, 1, 1));

        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();
        return book;
    }

    public Book updateExistingBook(Book book) {
        book.setReleaseDate(LocalDate.now());

        session.beginTransaction();
        session.merge(book);
        session.getTransaction().commit();
        return book;
    }

    public Book replaceExistingBook(Long idOfBookToBeReplaced) {
        Book book = new Book();
        book.setId(idOfBookToBeReplaced);
        book.setTitle("NEW BOOK");
        book.setNumberOfPages(30);

        session.beginTransaction();
        session.merge(book);
        session.getTransaction().commit();
        return book;
    }

    public void deleteBook(Long bookId) {
        Book book = session.get(Book.class, bookId);
        session.beginTransaction();
        session.remove(book);
        session.getTransaction().commit();
    }

}
