package ba.unsa.etf.si.tim11.bll;

import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.viewmodels.GrupaViewModel;

import java.util.List;

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
		// TODO - implement GrupaRepository.dodajGrupu
		throw new UnsupportedOperationException();
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

}