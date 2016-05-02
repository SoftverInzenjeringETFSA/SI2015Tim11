package ba.unsa.etf.si.tim11.dal;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;

public class FolderDALRepository extends DALRepository<FolderDbModel> {

	public FolderDALRepository() {
		super(FolderDbModel.class);
	}
}