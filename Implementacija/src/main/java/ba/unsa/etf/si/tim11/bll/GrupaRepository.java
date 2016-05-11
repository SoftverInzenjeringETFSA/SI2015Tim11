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
	public Boolean obrisiGrupu(Integer grupaId) {
		// TODO - implement GrupaRepository.obrisiGrupu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param grupa
	 */
	public Boolean dodajGrupu(GrupaDbModel grupa) {
		DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		return true;
	}

	/**
	 * 
	 * @param grupaXKorisnikDbModel
	 */
	public Boolean dodajKorisnikaUGrupu(GrupaXKorisnikDbModel grupaXKorisnikDbModel) {
		// TODO - implement GrupaRepository.dodajKorisnikaUGrupu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param korisnikId
	 * @param grupaId
	 */
	public void odbrisiKorisnikaIzGrupe(Integer korisnikId, Integer grupaId) {
		// TODO - implement GrupaRepository.odbrisiKorisnikaIzGrupe
		throw new UnsupportedOperationException();
	}
	
	public List<GrupaDbModel> dajGrupeZaKorisnika(Integer idKorisnika)
	{
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("korisnikId", idKorisnika));
		
		List<GrupaDbModel> listaGrupa = new ArrayList<GrupaDbModel>();
		List<GrupaXKorisnikDbModel> lista = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSveSaKriterujumom(kriterijum);
		
		for(GrupaXKorisnikDbModel gk : lista)
			listaGrupa.add(gk.getGrupa());
		
		return listaGrupa;
	}

	public GrupaDbModel dajGrupuPoNazivu(String text) {
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("naziv", text));
		List<GrupaDbModel> listaGrupa = DbDMSContext.getInstance().getGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		if(listaGrupa.isEmpty())
			return null;
		else
			return listaGrupa.get(0);
		
	}

	public void dodajFolderXGrupaDbModele(List<FolderXGrupaDbModel> listaDefinisanihPravaPristupa, Integer idNoveGrupe) {
		
		for(FolderXGrupaDbModel fg : listaDefinisanihPravaPristupa)
			{ 
			 	fg.setGrupaId(idNoveGrupe);
			 	DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(fg);
			}
		
	}

	public void dodajGrupaXKorisnikDbModele(List<KorisnikDbModel> listaDodanihKorisnika, Integer idNoveGrupe) {
		
		GrupaXKorisnikDbModel novi = null;
		
		for(KorisnikDbModel kor : listaDodanihKorisnika)
		{
			novi = new GrupaXKorisnikDbModel();
			novi.setAktivan(true);
			novi.setDatumPristupa(new Date());
			novi.setDatumZadnjeIzmjene(new Date());
			novi.setGrupaId(idNoveGrupe);
			novi.setKorisnikId((int)kor.getKorisnikID());
			
			DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(novi);
		}
		
	}
	

}