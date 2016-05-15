package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "ZahtjevStatusDbModel")
public class ZahtjevStatusDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long zahtjevStatusId;
	private String zahtjevStatusNaziv;
	private Boolean aktivan;

	public long getZahtjevStatusId() {
		return zahtjevStatusId;
	}

	public void setZahtjevStatusId(long zahtjevStatusId) {
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
	@Override
    public String toString()
    {
        return zahtjevStatusNaziv;
    }
}