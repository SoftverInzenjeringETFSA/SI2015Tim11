package ba.unsa.etf.si.tim11.dal;

import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;

public class DokumentVerzijaDAlRepository extends DALRepository<DokumentVerzijaDbModel> {

	public DokumentVerzijaDAlRepository() {
		super(DokumentVerzijaDbModel.class);
	}
}