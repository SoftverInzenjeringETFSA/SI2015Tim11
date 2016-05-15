package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class ZahtjevTipDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long zahtjevTipId;
	private String zahtjevTipNaziv;
	private Boolean aktivan;

	public long getZahtjevTipId() {
		return zahtjevTipId;
	}

	public void setZahtjevTipId(long zahtjevTipId) {
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
	@Override
    public String toString()
    {
        return zahtjevTipNaziv;
    }
}