package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class KorisnikPozicijaDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long korisnikPozicijaId;
	private String korisnikPozicijaNaziv;
	private Boolean aktivan;

	public long getKorisnikPozicijaId() {
		return korisnikPozicijaId;
	}

	public void setKorisnikPozicijaId(long korisnikPozicijaId) {
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
	
	@Override
    public String toString()
    {
        return korisnikPozicijaNaziv;
    }
}