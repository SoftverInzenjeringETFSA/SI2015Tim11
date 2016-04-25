package ba.unsa.etf.si.tim11.dbmodels;

public class KorisnikTipDbModel extends BaseDbModel {

	private Integer korisnikTipId;
	private String korisnikTipNaziv;
	private Boolean aktivan;

	public Integer getKorisnikTipId() {
		return korisnikTipId;
	}

	public void setKorisnikTipId(Integer korisnikTipId) {
		this.korisnikTipId = korisnikTipId;
	}

	public String getKorisnikTipNaziv() {
		return korisnikTipNaziv;
	}

	public void setKorisnikTipNaziv(String korisnikTipNaziv) {
		this.korisnikTipNaziv = korisnikTipNaziv;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}