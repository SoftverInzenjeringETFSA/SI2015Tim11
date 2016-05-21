package ba.unsa.etf.si.tim11.bll;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.ZahtjevDbModel;
import ba.unsa.etf.si.tim11.dbmodels.ZahtjevStatusDbModel;
import ba.unsa.etf.si.tim11.viewmodels.ZahtjevViewModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class ZahtjevRepository implements Serializable {

	/**
	 * 
	 * @param zahtjev
	 */
	public void dodajZahtjev(ZahtjevDbModel zahtjev) {
		zahtjev.setAktivan(true);
		ZahtjevDbModel z = new ZahtjevDbModel();
		z = zahtjev;
		DbDMSContext.getInstance().getZahtjevi().sacuvaj(z);
	}

	/**
	 * 
	 * @param statusId
	 * @param zahtjevId
	 */
	public void promijeniStatusZahtjev(Integer statusId, Integer zahtjevId) {
		ZahtjevDbModel zahtjev = DbDMSContext.getInstance().getZahtjevi().ucitaj((long) zahtjevId);
		//ZahtjevStatusDbModel zahtjevStatus = DbDMSContext.getInstance().getZahtjevStatusi().ucitaj((long) statusId);
		zahtjev.setZahtjevStatusId(statusId);
	}

	/**
	 * 
	 * @param zahtjevId
	 */
	public ZahtjevDbModel dajZahtjev(Integer zahtjevId) {
		ZahtjevDbModel zahtjev = DbDMSContext.getInstance().getZahtjevi().ucitaj((long) zahtjevId);
		return zahtjev;
	}

	/**
	 * 
	 * @param dokumentVerzijaId
	 */
	public List<ZahtjevDbModel> dajZahtjeveZaVerziju(Integer dokumentVerzijaId) {
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("dokumentVerzijaId", dokumentVerzijaId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		List<ZahtjevDbModel> zahtjeviZaVerziju = DbDMSContext.getInstance().getZahtjevi().ucitajSveSaKriterujumom(kriterijum);
		return zahtjeviZaVerziju;
	}
	
	public List<ZahtjevDbModel> dajPrimljeneZahtjeve(Integer korisnikId) {
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("upucenoKorisnikId", korisnikId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		List<ZahtjevDbModel> primljeniZahtjevi = DbDMSContext.getInstance().getZahtjevi().ucitajSveSaKriterujumom(kriterijum);
		return primljeniZahtjevi;
	}
	
	public List<ZahtjevDbModel> dajPoslaneZahtjeve(Integer korisnikId) {
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("kreiraoKorisnikId", korisnikId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		List<ZahtjevDbModel> poslaniZahtjevi = DbDMSContext.getInstance().getZahtjevi().ucitajSveSaKriterujumom(kriterijum);
		return poslaniZahtjevi;
	}
}