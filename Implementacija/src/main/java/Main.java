import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;

import ba.unsa.etf.si.tim11.bll.UnitOfWork;
import ba.unsa.etf.si.tim11.dal.*;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;

import static ba.unsa.etf.si.tim11.hibernate.DMSSessionFactory.getSession;

/**
 * Created by ensar on 4/25/16.
 */
public class Main {

	public static void main(final String[] args) throws Exception {
		try {
			test();
			testJoin();
			testFolder();
			testKorisnikIDPoUsername();
		} catch (Exception ex) {
			System.out.println("GRESKA: " + ex);
		} finally {
			System.out.println("Kraj sesije");
		}
	}
	private static void testJoin(){
		long korisnikId = 1;
		KorisnikDbModel s = DbDMSContext.getInstance().getKorisnici().ucitaj(korisnikId);
		
		if (s == null) {
			System.out.println("Nema korisnika sa tim IDom u bazi");
		} else {
			if(s.getKorisnikTip() != null)
				System.out.println("Ime: " + s.getIme() + " " + s.getPrezime()+" : "+s.getUsername()+" TIP!!: "+s.getKorisnikTip().getKorisnikTipNaziv());
		}
	}
	
	private static void testFolder(){
		long id = 4;
		FolderDbModel fol = DbDMSContext.getInstance().getFolderi().ucitaj(id);
		
		if (fol == null) {
			System.out.println("Nema foldera sa tim IDom u bazi");
		} else {
			System.out.println("Foder: "+fol.getFolderNaziv());
			if(fol.getRoditeljFolder() != null){
				System.out.println("Roditelj: "+fol.getRoditeljFolder().getFolderNaziv());
			}
		}
		
	}
	
	private static void testKorisnikIDPoUsername(){
		UnitOfWork uow = new UnitOfWork();
		System.out.println("KOrisnikID po username");
		
		Integer korisnikId = uow.getKorisnikRepository().dajIdKorisnikaPoUsername("muhamed"); 
		if (korisnikId == null) {
			System.out.println("Nema korisnika sa usernemeom: "+"muhamed");
		} else {
			System.out.println("KorisnikID: "+korisnikId.toString());
		}
		
	}
	
	private static void test() {
		System.out.println("Unesite id studenta");
		
		long tipId = 1;
		
		//primjer koristenja context-a
		KorisnikTipDbModel tip = DbDMSContext.getInstance().getKorisnikTipovi().ucitaj(tipId);
		
		if (tip == null) {
			System.out.println("Nema tipa sa tim IDom u bazi");
		} else {
			System.out.println("Tip: " + tip.getKorisnikTipNaziv());
		}

		
		System.out.println("bez kriterijuma!!!");
		
		ArrayList<Criterion> kriterijum2 = new ArrayList<Criterion>();
		
		java.util.List<KorisnikDbModel> lista2 = DbDMSContext.getInstance()
						.getKorisnici()
						.ucitajSveSaKriterujumom(kriterijum2);
		for (KorisnikDbModel korisnikDbModel : lista2) {
			System.out.println("Ime: " + korisnikDbModel.getIme() + " prezime: " + korisnikDbModel.getPrezime()+" username: "+korisnikDbModel.getUsername());
		}
		
		System.out.println("korisnikId = 2 !!!");
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("korisnikID", (long)2));
		
		java.util.List<KorisnikDbModel> lista = DbDMSContext.getInstance()
						.getKorisnici()
						.ucitajSveSaKriterujumom(kriterijum);
		for (KorisnikDbModel korisnikDbModel : lista) {
			System.out.println("Ime: " + korisnikDbModel.getIme() + " prezime: " + korisnikDbModel.getPrezime()+" username: "+korisnikDbModel.getUsername());
		}
		
		System.out.println("like operator!!!");
		
		ArrayList<Criterion> kriterijum1 = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.like("username", "muha"));
		
		java.util.List<KorisnikDbModel> lista1 = DbDMSContext.getInstance()
						.getKorisnici()
						.ucitajSveSaKriterujumom(kriterijum1);
		for (KorisnikDbModel korisnikDbModel : lista1) {
			System.out.println("Ime: " + korisnikDbModel.getIme() + " prezime: " + korisnikDbModel.getPrezime()+" username: "+korisnikDbModel.getUsername());
		}
		
	}

}
