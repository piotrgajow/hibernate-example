import hibernate.HibernateHelper;
import hibernate.entities.Author;
import hibernate.entities.Book;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        Session session = HibernateHelper.openSession();

        System.out.println("Get book with all dependencies eagerly");
        Book book = session.get(Book.class, 1L);
        System.out.println(book.getTitle());
        System.out.println(book.getAuthors().get(0).getSurname());
        System.out.println("\n");

        System.out.println("Get author");
        Author author = session.get(Author.class, 3L);
        System.out.println(author.getSurname());
        System.out.println(author.getBooks().get(0).getTitle());
        System.out.println("\n");

        session.close();

        HibernateHelper.closeSessionFactory();
    }

}
