import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import ba.unsa.etf.si.tim11.dal.*;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

import java.util.Map;

import static ba.unsa.etf.si.tim11.hibernate.DMSSessionFactory.getSession;

/**
 * Created by ensar on 4/25/16.
 */
public class Main {

	public static void main(final String[] args) throws Exception {
		final Session session = getSession();
		/*try {
			System.out.println("querying all the managed entities...");
			final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
			for (Object key : metadataMap.keySet()) {
				final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
				final String entityName = classMetadata.getEntityName();
				final Query query = session.createQuery("from " + entityName);
				System.out.println("executing: " + query.getQueryString());
				for (Object o : query.list()) {
					System.out.println("  " + o);
				}
			}
		} catch (Exception ex) {
			System.out.println("GRESKA: " + ex.getMessage());
		} finally {
			System.out.println("Kraj sesije");
			session.close();
		}*/
		
		try {
			nadjiStudenta(session);
		} catch (Exception ex) {
			System.out.println("GRESKA: " + ex.getMessage());
		} finally {
			System.out.println("Kraj sesije");
			session.close();
		}
	}

	private static void nadjiStudenta(Session session) {
		//Transaction t = session.beginTransaction();
		System.out.println("Unesite id studenta");
		long id = 1;
		//KorisnikDbModel s = (KorisnikDbModel) session.get(KorisnikDbModel.class, id);
		
		//testiranje repository-a
		KorisnikDALRepository dal = new KorisnikDALRepository();
		
		KorisnikDbModel s = dal.ucitaj((long) 1, session);
		
		if (s == null) {
			System.out.println("Nema studenta sa tim IDom u bazi");
		} else {
			System.out.println("Student: " + s.getIme() + " " + s.getPrezime()+" : "+s.getUsername());
		}
		
		
		//t.commit();
	}

}
