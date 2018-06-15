import hibernate.HibernateHelper;
import hibernate.entities.Book;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        Session session = HibernateHelper.openSession();

        Book book;

        System.out.println("Before get");
        book = session.get(Book.class, 1L);
        System.out.println("After get");
        System.out.println(book);

        System.out.println("Before load");
        book = session.load(Book.class, 2L);
        System.out.println("After load");
        System.out.println(book);

        System.out.println("Before get");
        book = session.load(Book.class, 2L);
        System.out.println("After get");
        System.out.println(book);

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
