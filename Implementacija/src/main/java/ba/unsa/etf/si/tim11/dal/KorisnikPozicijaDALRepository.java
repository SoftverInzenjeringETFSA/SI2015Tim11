package ba.unsa.etf.si.tim11.dal;

import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;

public class KorisnikPozicijaDALRepository extends DALRepository<KorisnikPozicijaDbModel> {

	public KorisnikPozicijaDALRepository() {
		super(KorisnikPozicijaDbModel.class);
	}
}