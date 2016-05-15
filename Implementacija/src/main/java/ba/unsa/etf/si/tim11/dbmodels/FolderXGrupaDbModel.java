package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "FolderXGrupaDbModel")
public class FolderXGrupaDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long folderXGrupaId;
	private Integer grupaId;
	private Integer folderId;
	private Boolean pravoSkidanja;
	private Boolean pravoDodavanja;
	private Boolean aktivan;

	@ManyToOne
	@JoinColumn(name="grupaId")
	private GrupaDbModel grupa;
	
	@ManyToOne
	@JoinColumn(name="folderId")
	private FolderDbModel folder;
	
	
	public GrupaDbModel getGrupa() {
		return grupa;
	}

	public void setGrupa(GrupaDbModel grupa) {
		this.grupa = grupa;
	}

	public FolderDbModel getFolder() {
		return folder;
	}

	public void setFolder(FolderDbModel folder) {
		this.folder = folder;
	}

	public long getFolderXGrupaId() {
		return folderXGrupaId;
	}

	public void setFolderXGrupaId(long folderXGrupaId) {
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