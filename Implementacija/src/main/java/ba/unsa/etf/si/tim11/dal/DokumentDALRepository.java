package ba.unsa.etf.si.tim11.dal;

import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;

public class DokumentDALRepository extends DALRepository<DokumentDbModel> {

	public DokumentDALRepository() {
		super(DokumentDbModel.class);
	}

}