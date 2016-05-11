package ba.unsa.etf.si.tim11.bll;

import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.viewmodels.KorisnikViewModel;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class KorisnikRepository {

	/**
	 * 
	 * @param korisnikId
	 */
	public KorisnikViewModel dajKorisnika(Integer korisnikId) {
		KorisnikDbModel korisnik = DbDMSContext.getInstance().getKorisnici().ucitaj((long)korisnikId);
		
		
		// TODO - implement KorisnikRepository.dajKorisnika
		throw new UnsupportedOperationException();
	}
	
	public static Boolean korisnikPostoji(String username, String password) {
		List<KorisnikDbModel> lista = DbDMSContext.getInstance().getKorisnici().ucitajSve();
		System.out.println("Uneseno, username: " + username + ", password: " + password);
		
		for(KorisnikDbModel korisnik : lista){
			System.out.println("Student: " + korisnik.getIme() + " " + korisnik.getPrezime()+" : "+korisnik.getUsername()+" : "+korisnik.getPassword());
			
			if(korisnik.getUsername().equals(username) && korisnik.getPassword().equals(password))
				return true;
		}
		return false;
	}
	
	public static Boolean korisnikAutenticiran(String username, String password){
		if(korisnikPostoji(username, password)){
			Sesija.setUsername(username);
			Sesija.setCertifikatAktivan(true);
			
			return true;
		}
		return false;
	}
	
	public List<KorisnikViewModel> dajKorisnike() {
		// TODO - implement KorisnikRepository.dajKorisnike
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param korisnik
	 */
	public void dodajKorisnika(KorisnikDbModel korisnik) {
		korisnik.setAktivan(true);
			KorisnikDbModel k=new KorisnikDbModel();
			k=korisnik;
			DbDMSContext.getInstance().getKorisnici().sacuvaj(k);
	}

	/**
	 * 
	 * @param korisnik
	 */
	public Boolean izmijeniKorisnika(KorisnikDbModel korisnik) {
		// TODO - implement KorisnikRepository.izmijeniKorisnika
		KorisnikDbModel k=new KorisnikDbModel();
		k=korisnik;
		DbDMSContext.getInstance().getKorisnici().sacuvajIliAzuriraj(k);
		return true;

	}

	/**
	 * 
	 * @param korinikId
	 */
	public Boolean obrisiKorisnika(Integer korinikId) {
		// TODO - implement KorisnikRepository.obrisiKorisnika
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param session
	 */
	public KorisnikRepository() {
		// TODO - implement KorisnikRepository.KorisnikRepository
		//throw new UnsupportedOperationException();
	}
	
	public List<KorisnikTipDbModel> dajSveTipoveKorisnika()
	{
		return DbDMSContext.getInstance().getKorisnikTipovi().ucitajSve();
	}
	public List<KorisnikPozicijaDbModel> dajSvePozicijeKorisnika()
	{
		return DbDMSContext.getInstance().getKorisnikPozicije().ucitajSve();
	}
	public Integer dajIdKorisnikaPoUsername(String username){
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eqOrIsNull("username", username));
		java.util.List<KorisnikDbModel> lista = DbDMSContext.getInstance()
						.getKorisnici()
						.ucitajSveSaKriterujumom(kriterijum);
		

		if(lista.size() != 0){
			for (KorisnikDbModel korisnikDbModel : lista) {
				return (int)(long)korisnikDbModel.getKorisnikID();
			}
		}
		return null;
	}
	public List<KorisnikTipDbModel> dajSveKorisnikTipove() {
		return DbDMSContext.getInstance().getKorisnikTipovi().ucitajSve();
	}
}