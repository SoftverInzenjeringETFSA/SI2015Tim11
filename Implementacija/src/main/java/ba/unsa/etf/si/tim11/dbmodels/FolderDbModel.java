package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;

@Entity
public class FolderDbModel extends BaseDbModel {

	private Integer folderId;
	private String folderNaziv;
	private Integer grupaId;
	private Integer kreriraoKorisnikId;
	private Integer roditeljFolderId;
	private Boolean aktivan;

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public String getFolderNaziv() {
		return folderNaziv;
	}

	public void setFolderNaziv(String folderNaziv) {
		this.folderNaziv = folderNaziv;
	}

	public Integer getGrupaId() {
		return grupaId;
	}

	public void setGrupaId(Integer grupaId) {
		this.grupaId = grupaId;
	}

	public Integer getKreriraoKorisnikId() {
		return kreriraoKorisnikId;
	}

	public void setKreriraoKorisnikId(Integer kreriraoKorisnikId) {
		this.kreriraoKorisnikId = kreriraoKorisnikId;
	}

	public Integer getRoditeljFolderId() {
		return roditeljFolderId;
	}

	public void setRoditeljFolderId(Integer roditeljFolderId) {
		this.roditeljFolderId = roditeljFolderId;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}