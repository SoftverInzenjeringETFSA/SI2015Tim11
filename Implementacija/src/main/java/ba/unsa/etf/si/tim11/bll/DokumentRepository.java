package ba.unsa.etf.si.tim11.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.forms.ZahtjevZaOdobrenje;

public class DokumentRepository {
	
	final static Logger logger = Logger.getLogger(DokumentRepository.class.toString());
	/**
	 * 
	 * @param dokument
	 */
	public Boolean dodajDokument(DokumentDbModel dokument, byte[] sadrzaj) {
		try {
			KorisnikRepository kor = new KorisnikRepository();
			
			//dodavanje dokuemnta
			long dokumentId = DbDMSContext.getInstance().getDokumenti().sacuvaj(dokument);
			
			//dodavanje inicijalne verzije
			DokumentVerzijaDbModel verzija = new DokumentVerzijaDbModel();
			verzija.setAktivan(true);
			verzija.setDokumentId((Integer)(int)dokumentId);
			verzija.setPostavioKorisnikId(kor.dajIdKorisnikaPoUsername(Sesija.getUsername()));
			//fali status
			verzija.setSadrzaj(sadrzaj);
			
			dodajverzijuDokumenta(verzija);
			
			return true;
			
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * 
	 * @param dokumentId
	 * @param dokumentVerzija
	 */
	public Boolean dodajverzijuDokumenta(DokumentVerzijaDbModel dokumentVerzija) {
		try {
			DbDMSContext.getInstance().getDokumentiVerzije().sacuvaj(dokumentVerzija);
			return true;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}
	
	public DokumentVerzijaDbModel dajVerzijuDokumenta(long dokumentVerzijaId) {
		return DbDMSContext.getInstance().getDokumentiVerzije().ucitaj(dokumentVerzijaId);
	}
	
	/**
	 * 
	 * @param dokumentId
	 */
	public Boolean obrisiDokument(Integer dokumentId) {
		DokumentDbModel dokument = DbDMSContext.getInstance().getDokumenti().ucitaj((long)(int)dokumentId);
		if(dokument != null){
			dokument.setAktivan(false);
			
			try {
				DbDMSContext.getInstance().getDokumenti().sacuvajIliAzuriraj(dokument);
				return true;
			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		return false;
	}

	/**
	 * 
	 * @param dokumentVerzijaId
	 */
	/*public Boolean obrisiVerzijuDokumenta(Integer dokumentVerzijaId) {
		
		
			throw new UnsupportedOperationException();
		
		
	}*/
	
	public List<DokumentDbModel> dajDokumente(Integer folderId){
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("folderId", folderId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<DokumentDbModel> lista = DbDMSContext.getInstance()
				.getDokumenti()
				.ucitajSveSaKriterujumom(kriterijum);
		return lista;
	}
	
	public List<DokumentVerzijaDbModel> dajVerzijeDokumenta(Integer dokumentId){
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("dokumentId", dokumentId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<DokumentVerzijaDbModel> lista = DbDMSContext.getInstance()
				.getDokumentiVerzije()
				.ucitajSveSaKriterujumom(kriterijum);
		return lista;
	}
}