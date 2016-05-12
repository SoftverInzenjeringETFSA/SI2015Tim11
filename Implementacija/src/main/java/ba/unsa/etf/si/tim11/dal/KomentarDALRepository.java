package ba.unsa.etf.si.tim11.dal;

import ba.unsa.etf.si.tim11.dbmodels.KomentarDbModel;

public class KomentarDALRepository extends DALRepository<KomentarDbModel> {

	public KomentarDALRepository() {
		super(KomentarDbModel.class);
	}
}