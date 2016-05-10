package ba.unsa.etf.si.tim11.bll;

import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.viewmodels.KorisnikViewModel;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;

import java.util.List;

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
		if(korisnikPostoji(username, password))
			return true;
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
	public void dodajKorisnika(KorisnikViewModel korisnik) {
		// TODO - implement KorisnikRepository.dodajKorisnika
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param korisnik
	 */
	public Boolean izmijeniKorisnika(KorisnikDbModel korisnik) {
		// TODO - implement KorisnikRepository.izmijeniKorisnika
		throw new UnsupportedOperationException();
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
	public KorisnikRepository(Sesija session) {
		// TODO - implement KorisnikRepository.KorisnikRepository
		throw new UnsupportedOperationException();
	}

}