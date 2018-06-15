import hibernate.HibernateHelper;
import hibernate.entities.Book;
import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.exception.RevisionDoesNotExistException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        Session session = HibernateHelper.openSession();

        Book book = createBook(session);
        Date date = new Date();
        wait(2);
        updateBook(book, session);

        showBookHistory(book, session);

        Date yesterday = new Date(date.getTime() - 24*60*60*1000);

        showBookAtDate(book, date, session);
        showBookAtDate(book, new Date(), session);
        showBookAtDate(book, yesterday, session);

        session.close();

        HibernateHelper.closeSessionFactory();
    }

    private static Book createBook(Session session) {
        Book book = new Book();
        book.setTitle("Hibernate: A Developers Notebook");
        book.setReleaseDate(LocalDate.of(2004, 5, 20));
        book.setHasHardCover(true);
        book.setNumberOfPages(192);

        session.beginTransaction();
        session.persist(book);
        session.getTransaction().commit();

        return book;
    }

    private static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void updateBook(Book book, Session session) {
        book.setTitle("Just Hibernate");
        book.setReleaseDate(LocalDate.of(2014, 6, 10));
        book.setHasHardCover(false);
        book.setNumberOfPages(140);

        session.beginTransaction();
        session.merge(book);
        session.getTransaction().commit();
    }

    private static void showBookHistory(Book book, Session session) {
        AuditReader auditReader = AuditReaderFactory.get(session);
        List<Number> revisionNumbers = auditReader.getRevisions(Book.class, book.getId());
        revisionNumbers.forEach(revisionNumber -> {
            Book bookRevision = auditReader.find(Book.class, book.getId(), revisionNumber);
            System.out.println("Revision " + revisionNumber);
            System.out.println(bookRevision);
        });
    }

    private static void showBookAtDate(Book book, Date date, Session session) {
        AuditReader auditReader = AuditReaderFactory.get(session);

        try {
            Book bookRevision = auditReader.find(Book.class, book.getId(), date);
            System.out.println(bookRevision);
        } catch (RevisionDoesNotExistException e) {
            System.out.println("No book revision found for date " + date);
        }
    }

}
