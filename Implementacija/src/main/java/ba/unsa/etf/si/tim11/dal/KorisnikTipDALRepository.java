package ba.unsa.etf.si.tim11.dal;

import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

public class KorisnikTipDALRepository extends DALRepository<KorisnikTipDbModel> {

	public KorisnikTipDALRepository() {
		super(KorisnikTipDbModel.class);
	}
}