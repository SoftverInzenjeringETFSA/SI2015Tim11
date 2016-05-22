package ba.unsa.etf.si.tim11.hibernate;/**
 * Created by ensar on 4/25/16.
 */

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class DMSSessionFactory {
    private static final Logger logger =
            Logger.getLogger(DMSSessionFactory.class.getName());

    private static final SessionFactory ourSessionFactory;

    static {
    	//citanje postavki iz db.propeprties
    	try {
			java.util.Properties properties = new Properties();
			properties.load(new FileInputStream("db.properties"));
			System.out.println("Procitao properties");
			
			// Create the SessionFactory from hibernate.cfg.xml
			ourSessionFactory =  new Configuration().
					mergeProperties(properties).
					configure().
					buildSessionFactory();
			System.out.println("ucitao konekciju");
		} catch (Exception ex) {
			System.out.println("Greska "+ ex);
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
    	
        /*try {
            ourSessionFactory = new Configuration().
                    configure().
                    buildSessionFactory();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError(ex);
        }*/
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

}
