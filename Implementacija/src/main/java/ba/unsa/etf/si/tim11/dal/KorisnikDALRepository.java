package ba.unsa.etf.si.tim11.dal;

import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

public class KorisnikDALRepository extends DALRepository<KorisnikDbModel> {

	public KorisnikDALRepository() {
		super(KorisnikDbModel.class);
	}
}