import hibernate.HibernateHelper;
import hibernate.entities.Author;
import hibernate.entities.Book;
import org.hibernate.Session;


public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        Session session = HibernateHelper.openSession();

        Book book = session.get(Book.class, 1L);
        System.out.println("Book 1 and its main author");
        System.out.println(book);
        System.out.println(book.getMainAuthor());
        System.out.println("\n");

        Author author = session.get(Author.class, 2L);
        System.out.println("Author 2 and his first book");
        System.out.println(author);
        System.out.println(author.getFirstBook());
        System.out.println("\n");

        session.close();

        HibernateHelper.closeSessionFactory();
    }

}
