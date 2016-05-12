package ba.unsa.etf.si.tim11.bll;

import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.viewmodels.KorisnikViewModel;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class KorisnikRepository {

	/**
	 * 
	 * @param korisnikId
	 */
	public KorisnikDbModel dajKorisnika(Integer korisnikId) {
		KorisnikDbModel korisnik = DbDMSContext.getInstance().getKorisnici().ucitaj((long)korisnikId);
		
		return korisnik;
		// TODO - implement KorisnikRepository.dajKorisnika
		//throw new UnsupportedOperationException();
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
	
	public List<KorisnikDbModel> dajSveKorisnike()
	{
		List<KorisnikDbModel> lista = DbDMSContext.getInstance().getKorisnici().ucitajSve();
		return lista;
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
		kriterijum.add(Restrictions.eq("username", username));
		
		
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

	public int dajPravaKorisnikaNaFolder(String userName, FolderDbModel selectedValue) {
		
		Integer idKorisnika = this.dajIdKorisnikaPoUsername(userName);
		FolderRepository f = new FolderRepository();
		
		List<FolderXGrupaDbModel> gf = f.dajSveGrupeFoldereKorisnika(idKorisnika);
		List<FolderXGrupaDbModel> novaLista = new ArrayList<FolderXGrupaDbModel>();
		for(FolderXGrupaDbModel fg : gf)
			if(fg.getFolder().getFolderId() == selectedValue.getFolderId())
				novaLista.add(fg);
		
		boolean pravoCitanja = false;
		boolean pravoPisanja = false;
		
		for(FolderXGrupaDbModel fg : novaLista)
			if(fg.getPravoDodavanja() && fg.getPravoSkidanja())
			{
				pravoPisanja = true;
				pravoCitanja = true;
				break;
			}
			else if(fg.getPravoDodavanja())
				pravoPisanja = true;
			else if(fg.getPravoSkidanja())
				pravoCitanja = true;
		
		if(pravoPisanja && pravoCitanja)
			return 0; // Korisnik ima pravo i citanja i pisanja
		else if(pravoPisanja)
			return 1; // Korisnik ima pravo pisanja samo
		else 
			return 2; // Korisnik ima pravo citanja samo
	}

	public List<KorisnikDbModel> dajKorisnikeGrupe(int grupaId) {
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("grupaId", grupaId));
		List<GrupaXKorisnikDbModel> grupeKorisnici = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);
		
		List<KorisnikDbModel> korisnici = new ArrayList<KorisnikDbModel>();
		
		for(GrupaXKorisnikDbModel gk : grupeKorisnici)
			korisnici.add(gk.getKorisnik());
		
		return korisnici;
	}

}