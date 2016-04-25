package ba.unsa.etf.si.tim11.dbmodels;

public class ZahtjevTipDbModel extends BaseDbModel {

	private Integer zahtjevTipId;
	private String zahtjevTipNaziv;
	private Boolean aktivan;

	public Integer getZahtjevTipId() {
		return zahtjevTipId;
	}

	public void setZahtjevTipId(Integer zahtjevTipId) {
		this.zahtjevTipId = zahtjevTipId;
	}

	public String getZahtjevTipNaziv() {
		return zahtjevTipNaziv;
	}

	public void setZahtjevTipNaziv(String zahtjevTipNaziv) {
		this.zahtjevTipNaziv = zahtjevTipNaziv;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}