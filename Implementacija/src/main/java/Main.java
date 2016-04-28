import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import ba.unsa.etf.si.tim11.dal.*;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

import java.util.Map;

import static ba.unsa.etf.si.tim11.hibernate.DMSSessionFactory.getSession;

/**
 * Created by ensar on 4/25/16.
 */
public class Main {

	public static void main(final String[] args) throws Exception {
		try {
			test();
		} catch (Exception ex) {
			System.out.println("GRESKA: " + ex.getMessage());
		} finally {
			System.out.println("Kraj sesije");
		}
	}

	private static void test() {
		System.out.println("Unesite id studenta");
		long korisnikId = 1;
		long tipId = 1;
		
		//primjer koristenja context-a
		KorisnikDbModel s = DbDMSContext.getInstance().getKorisnici().ucitaj(korisnikId);
		KorisnikTipDbModel tip = DbDMSContext.getInstance().getKorisnikTipovi().ucitaj(tipId);
		
		if (s == null) {
			System.out.println("Nema studenta sa tim IDom u bazi");
		} else {
			System.out.println("Student: " + s.getIme() + " " + s.getPrezime()+" : "+s.getUsername());
		}
		
		if (tip == null) {
			System.out.println("Nema tipa sa tim IDom u bazi");
		} else {
			System.out.println("Tip: " + tip.getKorisnikTipNaziv());
		}
	}

}
