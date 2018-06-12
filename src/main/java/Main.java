import hibernate.HibernateHelper;
import hibernate.entities.Book;
import hibernate.examples.EntityManipulationExamples;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        Session session = HibernateHelper.openSession();

        Book book;
        List<Book> books;

        EntityManipulationExamples examples = new EntityManipulationExamples(session);

        book = examples.findBookById(1L);
        displayResult("Book of id 1", book);

        books = examples.findAllBooks();
        displayResult("All books", books);

        books = examples.findBooksByPageCountGraterThan150();
        displayResult("Books with more than 150 pages", books);

        books = examples.findBooksByParametrizedPageCount(100);
        displayResult("Books with more than 100 pages", books);

        book = examples.createNewBook();
        displayResult("Newly created book", book);

        books = examples.findAllBooks();
        displayResult("All books", books);

        book = examples.updateExistingBook(book);
        displayResult("Updated book", book);

        books = examples.findAllBooks();
        displayResult("All books", books);

        book = examples.replaceExistingBook(book.getId());
        displayResult("Replaced book", book);

        books = examples.findAllBooks();
        displayResult("All books", books);

        examples.deleteBook(book.getId());
        System.out.println("Deleting book " + book.getId());

        books = examples.findAllBooks();
        displayResult("All books", books);

        session.close();

        HibernateHelper.closeSessionFactory();
    }

    private static void displayResult(String label, Book book) {
        System.out.println(label);
        System.out.println(book);
        System.out.println("\n");
    }

    private static void displayResult(String label, List<Book> books) {
        System.out.println(label);
        books.forEach(System.out::println);
        System.out.println("\n");
    }

}
