package ba.unsa.etf.si.tim11.dbmodels;

import java.sql.Blob;

public class DokumentVerzijaDbModel {

	private Integer dokumentVerzijaId;
	private Integer dokumentId;
	private Integer postavioKorisnikId;
	private Integer dokumentVerzijaStatusId;
	private Blob sadrzaj;
	private Boolean aktivan;

	public Integer getDokumentVerzijaId() {
		return dokumentVerzijaId;
	}

	public void setDokumentVerzijaId(Integer dokumentVerzijaId) {
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