package ba.unsa.etf.si.tim11.bll;


import ba.unsa.etf.si.tim11.dbmodels.ZahtjevDbModel;
import ba.unsa.etf.si.tim11.viewmodels.ZahtjevViewModel;

import java.io.Serializable;
import java.util.List;

public class ZahtjevRepository implements Serializable{

	/**
	 * 
	 * @param zahtjev
	 */
	public void dodajZahtjev(ZahtjevDbModel zahtjev) {
		// TODO - implement ZahtjevRepository.dodajZahtjev
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param statusId
	 * @param zahtjevId
	 */
	public void promijeniStatusZahtjev(Integer statusId, Integer zahtjevId) {
		// TODO - implement ZahtjevRepository.promijeniStatusZahtjev
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param zahtjevId
	 */
	public ZahtjevViewModel dajZahtjev(Integer zahtjevId) {
		// TODO - implement ZahtjevRepository.dajZahtjev
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dokumentVerzijaId
	 */
	public List<ZahtjevViewModel> dajZahtjeveZaVerziju(Integer dokumentVerzijaId) {
		// TODO - implement ZahtjevRepository.dajZahtjeveZaVerziju
		throw new UnsupportedOperationException();
	}

}