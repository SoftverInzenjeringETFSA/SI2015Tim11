package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;

@Entity
public class KorisnikPozicijaDbModel extends BaseDbModel {

	private Integer korisnikPozicijaId;
	private String korisnikPozicijaNaziv;
	private Boolean aktivan;

	public Integer getKorisnikPozicijaId() {
		return korisnikPozicijaId;
	}

	public void setKorisnikPozicijaId(Integer korisnikPozicijaId) {
		this.korisnikPozicijaId = korisnikPozicijaId;
	}

	public String getKorisnikPozicijaNaziv() {
		return korisnikPozicijaNaziv;
	}

	public void setKorisnikPozicijaNaziv(String korisnikPozicijaNaziv) {
		this.korisnikPozicijaNaziv = korisnikPozicijaNaziv;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}