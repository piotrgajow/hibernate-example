import hibernate.HibernateHelper;
import hibernate.entities.Book;
import org.hibernate.Session;

import javax.persistence.OptimisticLockException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        Session session = HibernateHelper.openSession();

        Scanner scanner = new Scanner(System.in);

        Book book = session.get(Book.class, 1L);
        System.out.println("Książka 1 ma tytuł: " + book.getTitle());
        System.out.print("Podaj nowy tytuł: ");
        book.setTitle(scanner.nextLine());

        System.out.println("Wpisz coś żeby potwierdzić.");
        scanner.nextLine();

        try {
            session.beginTransaction();
            session.merge(book);
            session.getTransaction().commit();
            System.out.println("Zapisano zmianę");
        } catch(OptimisticLockException e) {
            System.out.println("Nie udało się zapisać zmiany. Ktoś w międzyczasie zmienił już tytuł książki");
            System.out.println(book.getTitle());
            System.out.println("Aktualny tytuł to: " + book.getTitle());
        }

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
