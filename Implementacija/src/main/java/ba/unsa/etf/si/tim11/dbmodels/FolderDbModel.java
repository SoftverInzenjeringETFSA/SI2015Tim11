package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FolderDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long folderId;
	private String folderNaziv;
	private Integer kreiraoKorisnikId;
	private Integer roditeljFolderId;
	private Boolean aktivan;

	@ManyToOne
	@JoinColumn(name="korisnikID")
	private KorisnikDbModel kreiraoKorisnik;
	
	@ManyToOne
	@JoinColumn(name="folderId")
	private FolderDbModel roditeljFolder;
	
	public KorisnikDbModel getKreiraoKorisnik() {
		return kreiraoKorisnik;
	}

	public void setKreiraoKorisnik(KorisnikDbModel kreiraoKorisnik) {
		this.kreiraoKorisnik = kreiraoKorisnik;
	}


	public FolderDbModel getRoditeljFolder() {
		return roditeljFolder;
	}

	public void setRoditeljFolder(FolderDbModel roditeljFolder) {
		this.roditeljFolder = roditeljFolder;
	}

	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	public String getFolderNaziv() {
		return folderNaziv;
	}

	public void setFolderNaziv(String folderNaziv) {
		this.folderNaziv = folderNaziv;
	}


	public Integer getKreiraoKorisnikId() {
		return kreiraoKorisnikId;
	}

	public void setKreiraoKorisnikId(Integer kreiraoKorisnikId) {
		this.kreiraoKorisnikId = kreiraoKorisnikId;
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