package ba.unsa.etf.si.tim11.bll;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

public class DokumentRepository {
	/**
	 * 
	 * @param dokument
	 */
	public Boolean dodajDokument(DokumentDbModel dokument, String sadrzaj) {
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
			//fali sadrzaj
			
			dodajverzijuDokumenta(verzija);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
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
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * 
	 * @param dokumentId
	 */
	public Boolean obrisiDokument(Integer dokumentId) {
		// TODO - implement DokumentRepository.obrisiDokument
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dokumentVerzijaId
	 */
	public Boolean obrisiVerzijuDokumenta(Integer dokumentVerzijaId) {
		// TODO - implement DokumentRepository.obrisiVerzijuDokumenta
		throw new UnsupportedOperationException();
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
		return lista;
	}
}