package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class DokumentVerzijaStatusDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long dokumentVerzijaStatusId;
	private String dokumentVerzijaStatusNaziv;
	private Boolean aktivan;

	public long getDokumentVerzijaStatusId() {
		return dokumentVerzijaStatusId;
	}

	public void setDokumentVerzijaStatusId(long dokumentVerzijaStatusId) {
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
	@Override
    public String toString()
    {
        return dokumentVerzijaStatusNaziv;
    }
}