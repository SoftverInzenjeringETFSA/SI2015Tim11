package ba.unsa.etf.si.tim11.dbmodels;

public class ZahtjevStatusDbModel {

	private Integer zahtjevStatusId;
	private String zahtjevStatusNaziv;
	private Boolean aktivan;

	public Integer getZahtjevStatusId() {
		return zahtjevStatusId;
	}

	public void setZahtjevStatusId(Integer zahtjevStatusId) {
		this.zahtjevStatusId = zahtjevStatusId;
	}

	public String getZahtjevStatusNaziv() {
		return zahtjevStatusNaziv;
	}

	public void setZahtjevStatusNaziv(String zahtjevStatusNaziv) {
		this.zahtjevStatusNaziv = zahtjevStatusNaziv;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}