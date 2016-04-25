package ba.unsa.etf.si.tim11.dbmodels;

public class FolderXGrupaDbModel {

	private Integer folderXGrupaId;
	private Integer grupaId;
	private Integer folderId;
	private Boolean pravoSkidanja;
	private Boolean pravoDodavanja;
	private Boolean aktivan;

	public Integer getFolderXGrupaId() {
		return folderXGrupaId;
	}

	public void setFolderXGrupaId(Integer folderXGrupaId) {
		this.folderXGrupaId = folderXGrupaId;
	}

	public Integer getGrupaId() {
		return grupaId;
	}

	public void setGrupaId(Integer grupaId) {
		this.grupaId = grupaId;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public Boolean getPravoSkidanja() {
		return pravoSkidanja;
	}

	public void setPravoSkidanja(Boolean pravoSkidanja) {
		this.pravoSkidanja = pravoSkidanja;
	}

	public Boolean getPravoDodavanja() {
		return pravoDodavanja;
	}

	public void setPravoDodavanja(Boolean pravoDodavanja) {
		this.pravoDodavanja = pravoDodavanja;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}