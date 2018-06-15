import hibernate.HibernateHelper;
import hibernate.entities.Book;
import hibernate.entities.EBook;
import hibernate.entities.PaperBook;
import org.hibernate.Session;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        Session session = HibernateHelper.openSession();

        EBook ebook = new EBook();
        ebook.setTitle("Just Hibernate");
        ebook.setReleaseDate(LocalDate.of(2014, 6, 10));
        ebook.setSizeKB(615);

        PaperBook paperBook = new PaperBook();
        paperBook.setTitle("Hibernate: A Developers Notebook");
        paperBook.setReleaseDate(LocalDate.of(2004, 5, 20));
        paperBook.setHasHardCover(true);
        paperBook.setNumberOfPages(192);

        session.beginTransaction();
        session.persist(ebook);
        session.persist(paperBook);
        session.getTransaction().commit();

        session.createQuery("from Book", Book.class)
                .list()
                .forEach(System.out::println);

        session.close();

        HibernateHelper.closeSessionFactory();
    }

}
