package ba.unsa.etf.si.tim11.hibernate;/**
 * Created by ensar on 4/25/16.
 */

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Logger;

public class DMSSessionFactory {
    private static final Logger logger =
            Logger.getLogger(DMSSessionFactory.class.getName());

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            ourSessionFactory = new Configuration().
                    configure().
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

}
