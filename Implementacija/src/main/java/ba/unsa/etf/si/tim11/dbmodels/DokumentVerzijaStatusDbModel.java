package ba.unsa.etf.si.tim11.dbmodels;

public class DokumentVerzijaStatusDbModel {

	private Integer dokumentVerzijaStatusId;
	private String dokumentVerzijaStatusNaziv;
	private Boolean aktivan;

	public Integer getDokumentVerzijaStatusId() {
		return dokumentVerzijaStatusId;
	}

	public void setDokumentVerzijaStatusId(Integer dokumentVerzijaStatusId) {
		this.dokumentVerzijaStatusId = dokumentVerzijaStatusId;
	}

	public String getDokumentVerzijaStatusNaziv() {
		return dokumentVerzijaStatusNaziv;
	}

	public void setDokumentVerzijaStatusNaziv(String dokumentVerzijaStatusNaziv) {
		this.dokumentVerzijaStatusNaziv = dokumentVerzijaStatusNaziv;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}