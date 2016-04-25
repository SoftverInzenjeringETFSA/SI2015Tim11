package ba.unsa.etf.si.tim11.dal;

import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;

public class GrupaDALRepository extends DALRepository<GrupaDbModel> {

	public GrupaDALRepository() {
		super(GrupaDbModel.class);
	}
}