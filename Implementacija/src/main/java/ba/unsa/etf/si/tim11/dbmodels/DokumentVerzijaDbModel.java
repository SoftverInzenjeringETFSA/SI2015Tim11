package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.sql.Blob;

@Entity
public class DokumentVerzijaDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long dokumentVerzijaId;
	private Integer dokumentId;
	private Integer postavioKorisnikId;
	private Integer dokumentVerzijaStatusId;
	private Blob sadrzaj;
	private Boolean aktivan;

	public long getDokumentVerzijaId() {
		return dokumentVerzijaId;
	}

	public void setDokumentVerzijaId(long dokumentVerzijaId) {
		this.dokumentVerzijaId = dokumentVerzijaId;
	}

	public Integer getDokumentId() {
		return dokumentId;
	}

	public void setDokumentId(Integer dokumentId) {
		this.dokumentId = dokumentId;
	}

	public Integer getPostavioKorisnikId() {
		return postavioKorisnikId;
	}

	public void setPostavioKorisnikId(Integer postavioKorisnikId) {
		this.postavioKorisnikId = postavioKorisnikId;
	}

	public Integer getDokumentVerzijaStatusId() {
		return dokumentVerzijaStatusId;
	}

	public void setDokumentVerzijaStatusId(Integer dokumentVerzijaStatusId) {
		this.dokumentVerzijaStatusId = dokumentVerzijaStatusId;
	}

	public Blob getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(Blob sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}