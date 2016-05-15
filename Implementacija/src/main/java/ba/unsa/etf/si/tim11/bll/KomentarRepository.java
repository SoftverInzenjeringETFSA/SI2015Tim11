package ba.unsa.etf.si.tim11.bll;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KomentarDbModel;
import ba.unsa.etf.si.tim11.viewmodels.KomentarViewModel;

public class KomentarRepository implements Serializable{
	final static Logger logger = Logger.getLogger(KomentarRepository.class.toString());
	/**
	 * 
	 * @param komentar
	 */
	public Boolean dodajKomentar(KomentarDbModel komentar) {
		try {
			DbDMSContext.getInstance().getKomentari().sacuvaj(komentar);
			return true;
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * 
	 * @param komentar
	 */
	/*public void obrisiKomentar(KomentarDbModel komentar) {
		// TODO - implement KomentarRepository.obrisiKomentar
		throw new UnsupportedOperationException();
	}*/

	/**
	 * 
	 * @param komentarId
	 */
	/*public KomentarViewModel dajKomentar(Integer komentarId) {
		// TODO - implement KomentarRepository.dajKomentar
		throw new UnsupportedOperationException();
	}*/

	/**
	 * 
	 * @param dokumentVerzijaId
	 */
	/*public void dajKomentareZaVerziju(Integer dokumentVerzijaId) {
		// TODO - implement KomentarRepository.dajKomentareZaVerziju
		throw new UnsupportedOperationException();
	}*/
	
	public List<KomentarDbModel> dajKomentare(Integer dokumentVerzijaId){
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("dokumentVerzijaId", dokumentVerzijaId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<KomentarDbModel> lista = DbDMSContext.getInstance()
				.getKomentari()
				.ucitajSveSaKriterujumom(kriterijum);
		return lista;
	}
}