import hibernate.HibernateHelper;

public class Main {

    public static void main(String[] args) {
        HibernateHelper.prepareSessionFactory();

        HibernateHelper.closeSessionFactory();
    }

}
