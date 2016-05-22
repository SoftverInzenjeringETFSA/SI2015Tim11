package ba.unsa.etf.si.tim11.bll;

import java.io.Serializable;
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
import ba.unsa.etf.si.tim11.dbmodels.ZahtjevDbModel;
import ba.unsa.etf.si.tim11.forms.DodavanjeZahtjeva;
import javassist.bytecode.Descriptor.Iterator;

public class DokumentRepository implements Serializable {
	
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
			//verzija.setDokumentVerzijaStatusId(1);
			verzija.setSadrzaj(sadrzaj);
			
			dodajverzijuDokumenta(verzija);
			
			return true;
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}

	}

	/**
	 * 
	 * @param dokumentVerzija
	 */
	public Boolean dodajverzijuDokumenta(DokumentVerzijaDbModel dokumentVerzija) {
		try {
			DbDMSContext.getInstance().getDokumentiVerzije().sacuvaj(dokumentVerzija);
			return true;
		} catch (Exception e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
			
		}

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
				throw new RuntimeException(e);
			}
		}
		return false;
	}

	public List<DokumentVerzijaDbModel> getDokumentByKorisnikAjDi(Integer korisnikAjDi) {
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("postavioKorisnikId", korisnikAjDi));

		return DbDMSContext.getInstance().getDokumentiVerzije().ucitajSveSaKriterujumom(kriterijum);
	}
	
	public List<DokumentVerzijaDbModel> getDokumentVerzijaByKorisnikAjDi(Integer korisnikAjDi) {
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("postavioKorisnikId", korisnikAjDi));

		return DbDMSContext.getInstance().getDokumentiVerzije().ucitajSveSaKriterujumom(kriterijum);
	}
	
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
		
		for (java.util.Iterator<DokumentVerzijaDbModel> iterator = lista.iterator(); iterator.hasNext();) {
		    DokumentVerzijaDbModel dokumentVerzijaDbModel = iterator.next();
		    
		    //izbacivanje onih za koje je izdat zahtjev za prikazivanje
			ArrayList<Criterion> kriterijumZahtjev = new ArrayList<Criterion>();
			kriterijumZahtjev.add(Restrictions.eq("dokumentVerzijaId", (Integer)(int)dokumentVerzijaDbModel.getDokumentVerzijaId()));
			kriterijumZahtjev.add(Restrictions.in("zahtjevStatusId", new Integer[]{1,3} ));
			kriterijumZahtjev.add(Restrictions.eq("aktivan", true));
			
			List<ZahtjevDbModel> listaZahtjeva = DbDMSContext.getInstance()
					.getZahtjevi()
					.ucitajSveSaKriterujumom(kriterijumZahtjev);
			
			if(listaZahtjeva.size() != 0)
				iterator.remove();
		}
		return lista;
	}
}