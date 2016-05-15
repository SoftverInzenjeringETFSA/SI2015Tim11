package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class KorisnikTipDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long korisnikTipId;
	private String korisnikTipNaziv;
	private Boolean aktivan;

	public long getKorisnikTipId() {
		return korisnikTipId;
	}

	public void setKorisnikTipId(long korisnikTipId) {
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
	
	@Override
    public String toString()
    {
        return korisnikTipNaziv;
    }
}