package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Blob;

@Entity
public class DokumentVerzijaDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long dokumentVerzijaId;
	private Integer dokumentId;
	private Integer postavioKorisnikId;
	private Integer dokumentVerzijaStatusId;
	private byte[] sadrzaj;
	private Boolean aktivan;

	@ManyToOne
	@JoinColumn(name="dokumentId")
	private DokumentDbModel dokument;
	
	@ManyToOne
	@JoinColumn(name="postavioKorisnikId")
	private KorisnikDbModel postavioKorisnik;
	
	@ManyToOne
	@JoinColumn(name="dokumentVerzijaStatusId")
	private DokumentVerzijaStatusDbModel dokumentVerzijaStatus;
	
	
	public DokumentDbModel getDokument() {
		return dokument;
	}

	public void setDokument(DokumentDbModel dokument) {
		this.dokument = dokument;
	}

	public KorisnikDbModel getPostavioKorisnik() {
		return postavioKorisnik;
	}

	public void setPostavioKorisnik(KorisnikDbModel postavioKorisnik) {
		this.postavioKorisnik = postavioKorisnik;
	}

	public DokumentVerzijaStatusDbModel getDokumentVerzijaStatus() {
		return dokumentVerzijaStatus;
	}

	public void setDokumentVerzijaStatus(DokumentVerzijaStatusDbModel dokumentVerzijaStatus) {
		this.dokumentVerzijaStatus = dokumentVerzijaStatus;
	}

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

	public byte[] getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(byte[] sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}