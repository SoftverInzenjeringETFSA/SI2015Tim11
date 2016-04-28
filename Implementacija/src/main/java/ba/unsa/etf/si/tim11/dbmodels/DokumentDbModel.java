package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DokumentDbModel implements java.io.Serializable{

	@Id
    @GeneratedValue
	private long dokumentId;
	private Integer folderId;
	private String dokumentNaziv;
	private String ekstenzija;
	private Boolean aktivan;

	public long getDokumentId() {
		return dokumentId;
	}

	public void setDokumentId(long dokumentId) {
		this.dokumentId = dokumentId;
	}

	public Integer getFolderId() {
		return folderId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public String getDokumentNaziv() {
		return dokumentNaziv;
	}

	public void setDokumentNaziv(String dokumentNaziv) {
		this.dokumentNaziv = dokumentNaziv;
	}

	public String getEkstenzija() {
		return ekstenzija;
	}

	public void setEkstenzija(String ekstenzija) {
		this.ekstenzija = ekstenzija;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}