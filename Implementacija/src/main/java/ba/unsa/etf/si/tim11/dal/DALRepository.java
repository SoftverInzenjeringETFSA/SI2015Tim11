package ba.unsa.etf.si.tim11.dal;

/**
 * Created by ensar on 4/26/16.
 */

import ba.unsa.etf.si.tim11.dbmodels.BaseDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.hibernate.DMSSessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static ba.unsa.etf.si.tim11.hibernate.DMSSessionFactory.getSession;

import java.util.List;
import java.util.logging.Logger;

//sad prima samo T
public class DALRepository<T>{
    private static final Logger logger =
            Logger.getLogger(DALRepository.class.getName());

    private static final String DELETE = "DELETE";
    private static final String FROM = "FROM";
    private static final String SPACE = " ";
    private static final String PARAMETER = "?";

    private Class<T> entityClass;
    private Session session;
    
    /**
     * Kreiraj repozitorij za odredjenu klasu
     * @param entityClass klasa repozitorija
     */
    public DALRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
        
    }

    /**
     * Ucitaj sve objekte iz baze
     * @param session Hibernate sesija
     * @return Lista svih objekata
     */
    public List<T> ucitajSve() {
    	session = DMSSessionFactory.getSession();
        Transaction t = this.session.beginTransaction();
        List lista = this.session.createCriteria(entityClass).list();
        session.close();
        return lista;
    }

    /**
     * Ucitaj objekat iz baze
     * @param id Id objekta
     * @param session Hibernate sesija
     * @return Trazeni objekat ili null ako ga nema
     */
    public T ucitaj(Long id) {
    	session = DMSSessionFactory.getSession();
        Transaction t = this.session.beginTransaction();
        T resultObject = (T) this.session.get(entityClass, id);
        session.close();
        return resultObject;
    }

    /**
     * Spasavanje objekta u bazu
     * @param object Objekat koji se spasava
     * @param session Hibernate sesija
     */
    public void sacuvaj(T object, Session session) {
    	session = DMSSessionFactory.getSession();
        Transaction t = session.beginTransaction();
        session.save(object);
        t.commit();
        session.close();
    }

    /**
     * Spasavanje objekta u bazu ili azuriranje ako objekat sa istim id-em vec postoji
     * @param object Objekat koji se spasava
     * @param session Hibernate sesija
     */
    public void sacuvajIliAzuriraj(T object, Session session) {
    	session = DMSSessionFactory.getSession();
        Transaction t = session.beginTransaction();
        session.saveOrUpdate(object);
        t.commit();
        session.close();
    }


    /**
     * Obrisi jedan objekat
     * @param object Objekat koji se brise
     * @param session Hibernate sesija
     */
    public void obrisi(T object, Session session) {
    	session = DMSSessionFactory.getSession();
        Transaction t = session.beginTransaction();
        session.delete(object);
        t.commit();
        session.close();
    }

    /**
     * Obrisi sve objekte
     * @param session Hibernate sesija
     */
    public void obrisiSve(Session session) {
    	session = DMSSessionFactory.getSession();
        Transaction t = session.beginTransaction();
        String queryString = DELETE + SPACE + FROM + PARAMETER;
        Query query = session.createQuery(queryString);
        query.setString(0, entityClass.getCanonicalName());
        query.executeUpdate();
        t.commit();
        session.close();
    }
}
