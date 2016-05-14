package ba.unsa.etf.si.tim11.bll;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.viewmodels.GrupaViewModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class GrupaRepository {

	/**
	 * 
	 * @param grupaId
	 */
	public GrupaViewModel dajGrupu(Integer grupaId) {
		// TODO - implement GrupaRepository.dajGrupu
		throw new UnsupportedOperationException();
	}

	public List<GrupaViewModel> dajGrupe() {
		// TODO - implement GrupaRepository.dajGrupe
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param grupa
	 */
	public Boolean izmijeniGrupu(GrupaDbModel grupa) {
		// TODO - implement GrupaRepository.izmijeniGrupu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param grupaId
	 */
	public Boolean obrisiGrupu(GrupaDbModel grupa) {
		grupa.setAktivan(false);
		DbDMSContext.getInstance().getGrupe().sacuvajIliAzuriraj(grupa);
		return true;
	}
	
	public void ukloniSveKorisnikeIzGrupe(Integer grupaId)
	{
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("grupaId", grupaId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<GrupaXKorisnikDbModel> grupeKorisnici = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);
		
		for(GrupaXKorisnikDbModel gk : grupeKorisnici)
		{
			gk.setAktivan(false);
			DbDMSContext.getInstance().getGrupeKorisnici().sacuvajIliAzuriraj(gk);
		}
	}
	
	public void ukloniSvaPravaPristupaGrupe(Integer grupaId)
	{
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("grupaId", grupaId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<FolderXGrupaDbModel> folderiGrupe = DbDMSContext.getInstance().getFolderiGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		for(FolderXGrupaDbModel fg : folderiGrupe)
		{
			fg.setAktivan(false);
			DbDMSContext.getInstance().getFolderiGrupe().sacuvajIliAzuriraj(fg);
		}
		
	}
	
	public void oduzmiPravaPristupaGrupeNaFolder(int idFoldera, int idGrupe)
	{
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("grupaId", idGrupe));
		kriterijum.add(Restrictions.eq("folderId", idFoldera));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<FolderXGrupaDbModel> folderiGrupe = DbDMSContext.getInstance().getFolderiGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		if(folderiGrupe.size() != 0)
		{
			folderiGrupe.get(0).setPravoDodavanja(false);
			folderiGrupe.get(0).setPravoSkidanja(false);
			folderiGrupe.get(0).setAktivan(false);
			
			DbDMSContext.getInstance().getFolderiGrupe().sacuvajIliAzuriraj(folderiGrupe.get(0));
		}
	}

	/**
	 * 
	 * @param grupa
	 */
	public Boolean dodajGrupu(GrupaDbModel grupa) {
		
		// Provjeri da li ima grupa sa istim nazivom koja je neaktivna
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("grupaNaziv", grupa.getGrupaNaziv()));
		kriterijum.add(Restrictions.eq("aktivan", false));
		
		List<GrupaDbModel> listaNeaktivnihGrupa = DbDMSContext.getInstance().getGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		if(listaNeaktivnihGrupa.size() != 0)
		{
			GrupaDbModel postojecaGrupa = listaNeaktivnihGrupa.get(0);
			postojecaGrupa.setAktivan(true);
			postojecaGrupa.setDatumKreiranja(grupa.getDatumKreiranja());
			postojecaGrupa.setOdgovorniKorisnikId(grupa.getOdgovorniKorisnikId());
			DbDMSContext.getInstance().getGrupe().sacuvajIliAzuriraj(postojecaGrupa);
		}
		else // Ako ne postoji sačuvaj kreiranu
			DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		return true;
	}

	/**
	 * 
	 * @param grupaXKorisnikDbModel
	 */
	public Boolean dodajKorisnikaUGrupu(GrupaXKorisnikDbModel grupaXKorisnikDbModel) {
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add( Restrictions.eq("korisnikId", grupaXKorisnikDbModel.getKorisnikId()));
		kriterijum.add( Restrictions.eq("grupaId", grupaXKorisnikDbModel.getGrupaId()));
		kriterijum.add( Restrictions.eq("aktivan", false));
		
		List<GrupaXKorisnikDbModel> listaPostojecih = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);
		
		if(listaPostojecih.size() != 0)
		{
			 listaPostojecih.get(0).setAktivan(true);
			 DbDMSContext.getInstance().getGrupeKorisnici().sacuvajIliAzuriraj(listaPostojecih.get(0));
		}
		else
			DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(grupaXKorisnikDbModel);
		
		return true;
	}

	/**
	 * 
	 * @param korisnikId
	 * @param grupaId
	 */
	public void odbrisiKorisnikaIzGrupe(Integer korisnikId, Integer grupaId) {
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add( Restrictions.eq("korisnikId", korisnikId));
		kriterijum.add( Restrictions.eq("grupaId", grupaId));
		kriterijum.add( Restrictions.eq("aktivan", true));
		
		List<GrupaXKorisnikDbModel> grupeKorisnici = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);
		
		GrupaXKorisnikDbModel gk = null;
		
		if(!grupeKorisnici.isEmpty())
		  gk = grupeKorisnici.get(0);
		
		if(gk != null)
		{
			gk.setAktivan(false);
			DbDMSContext.getInstance().getGrupeKorisnici().sacuvajIliAzuriraj(gk);
		}
	}
	
	public List<GrupaDbModel> dajGrupeVlasnika(Integer idKorisnika)
	{
		KorisnikRepository korRep = new KorisnikRepository();
		KorisnikDbModel kor = korRep.dajKorisnika(idKorisnika);
		List<GrupaDbModel> listaGrupa;
		
		if(kor.getKorisnikTip().getKorisnikTipNaziv().equals("Administrator"))
		{
			ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
			kriterijum.add(Restrictions.eq("aktivan", true));
			
			listaGrupa = DbDMSContext.getInstance().getGrupe().ucitajSveSaKriterujumom(kriterijum);
			return listaGrupa;
		}
					
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("odgovorniKorisnikId", idKorisnika));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		listaGrupa = DbDMSContext.getInstance().getGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		return listaGrupa;
	}
	
	public List<GrupaDbModel> dajGrupeZaKorisnika(Integer idKorisnika)
	{
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("korisnikId", idKorisnika));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<GrupaDbModel> listaGrupa = new ArrayList<GrupaDbModel>();
		List<GrupaXKorisnikDbModel> lista = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);
		
		for(GrupaXKorisnikDbModel gk : lista)
			listaGrupa.add(gk.getGrupa());
		
		return listaGrupa;
	}

	public GrupaDbModel dajGrupuPoNazivu(String text) {
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("grupaNaziv", text));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<GrupaDbModel> listaGrupa = DbDMSContext.getInstance().getGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		if(listaGrupa.isEmpty())
			return null;
		else
			return listaGrupa.get(0);
		
	}

	public void dodajFolderXGrupaDbModele(List<FolderXGrupaDbModel> listaDefinisanihPravaPristupa, Integer idNoveGrupe) {
		
		// Provjeri da li postoji zapis da grupa ima prava na folder koji je neaktivan pa ga aktiviraj
		// U suprotnom sacuvaj kreirani
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		List<FolderXGrupaDbModel> listaPostojecih;
		
		for(FolderXGrupaDbModel fg : listaDefinisanihPravaPristupa)
		{ 
				fg.setGrupaId(idNoveGrupe);
				kriterijum.clear();
				kriterijum.add(Restrictions.eq("grupaId", fg.getGrupaId()));
				kriterijum.add(Restrictions.eq("folderId", fg.getFolderId()));
				kriterijum.add(Restrictions.eq("aktivan", false));
				
				listaPostojecih = DbDMSContext.getInstance().getFolderiGrupe().ucitajSveSaKriterujumom(kriterijum);
				
				if(listaPostojecih.size() != 0)
				{
					listaPostojecih.get(0).setAktivan(true);
					listaPostojecih.get(0).setPravoDodavanja(fg.getPravoDodavanja());
					listaPostojecih.get(0).setPravoSkidanja(fg.getPravoSkidanja());
					DbDMSContext.getInstance().getFolderiGrupe().sacuvajIliAzuriraj(listaPostojecih.get(0));
				}
				else
				{
				 	fg.setGrupaId(idNoveGrupe);
				 	DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(fg);
				}
		}
		
	}

	public void dodajGrupaXKorisnikDbModele(List<KorisnikDbModel> listaDodanihKorisnika, Integer idNoveGrupe) 
	{
		GrupaXKorisnikDbModel novi = null;
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		List<GrupaXKorisnikDbModel> listaPostojecih;
		
		for(KorisnikDbModel kor : listaDodanihKorisnika)
		{
			novi = new GrupaXKorisnikDbModel();
			novi.setAktivan(true);
			novi.setDatumPristupa(new Date());
			novi.setDatumZadnjeIzmjene(new Date());
			novi.setGrupaId(idNoveGrupe);
			novi.setKorisnikId((int)kor.getKorisnikID());
			
			// Provjeri da li postoji zapis da je korisnik u grupi koji je neaktivan pa ga aktiviraj
			// U suprotnom sacuvaj kreirani
			kriterijum.clear();
			kriterijum.add(Restrictions.eq("grupaId", novi.getGrupaId()));
			kriterijum.add(Restrictions.eq("korisnikId", novi.getKorisnikId()));
			kriterijum.add(Restrictions.eq("aktivan", false));
			
			listaPostojecih = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);
			
			if(listaPostojecih.size() != 0)
			{
				listaPostojecih.get(0).setAktivan(true);
				listaPostojecih.get(0).setDatumPristupa(novi.getDatumPristupa());
				listaPostojecih.get(0).setDatumZadnjeIzmjene(novi.getDatumZadnjeIzmjene());
				DbDMSContext.getInstance().getGrupeKorisnici().sacuvajIliAzuriraj(listaPostojecih.get(0));
			}
			else
			{
				DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(novi);
			}
		}
		
	}

	public void azurirajGrupu(GrupaDbModel grupaZaIzmjenu) {
		DbDMSContext.getInstance().getGrupe().sacuvajIliAzuriraj(grupaZaIzmjenu);
		
	}
	
	public boolean daLiPostojiKorisnikUGrupi(Integer idKorisnika, Integer idGrupe)
	{
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("korisnikId", idKorisnika));
		kriterijum.add(Restrictions.eq("grupaId", idGrupe));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<GrupaXKorisnikDbModel> lista = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);

		if(lista.size() > 0)
			return true;
		else return false;
	}
	

}