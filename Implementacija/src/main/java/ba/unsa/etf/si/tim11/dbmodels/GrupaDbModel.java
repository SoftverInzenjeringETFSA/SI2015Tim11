package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table (name = "GrupaDbModel")
public class GrupaDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long grupaId;
	private String grupaNaziv;
	private Integer odgovorniKorisnikId;
	private Date datumKreiranja;
	private Boolean aktivan;

	@ManyToOne
	@JoinColumn(name="odgovorniKorisnikId")
	private KorisnikDbModel odgovorniKorisnik;
	
	public KorisnikDbModel getOdgovorniKorisnik() {
		return odgovorniKorisnik;
	}

	public void setOdgovorniKorisnik(KorisnikDbModel odgovorniKorisnik) {
		this.odgovorniKorisnik = odgovorniKorisnik;
	}

	public long getGrupaId() {
		return grupaId;
	}

	public void setGrupaId(long grupaId) {
		this.grupaId = grupaId;
	}
	
	public String getGrupaNaziv() {
		return grupaNaziv;
	}

	public void setGrupaNaziv(String grupaNaziv) {
		this.grupaNaziv = grupaNaziv;
	}

	public Integer getOdgovorniKorisnikId() {
		return odgovorniKorisnikId;
	}

	public void setOdgovorniKorisnikId(Integer odgovorniKorisnikId) {
		this.odgovorniKorisnikId = odgovorniKorisnikId;
	}

	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
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
        return grupaNaziv;
    }
}