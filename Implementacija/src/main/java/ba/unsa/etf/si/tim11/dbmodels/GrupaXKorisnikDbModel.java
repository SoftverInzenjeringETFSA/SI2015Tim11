package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class GrupaXKorisnikDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long grupaXKorisnikId;
	private Integer grupaId;
	private Integer korisnikId;
	private Date datumPristupa;
	private Date datumZadnjeIzmjene;
	private Boolean aktivan;

	@ManyToOne
	@JoinColumn(name="grupaId")
	private GrupaDbModel grupa;
	
	@ManyToOne
	@JoinColumn(name="korisnikId")
	private KorisnikDbModel korisnik;
	
	public GrupaDbModel getGrupa() {
		return grupa;
	}

	public void setGrupa(GrupaDbModel grupa) {
		this.grupa = grupa;
	}
	
	public KorisnikDbModel getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDbModel korisnik) {
		this.korisnik = korisnik;
	}

	public long getGrupaXKorisnikId() {
		return grupaXKorisnikId;
	}

	public void setGrupaXKorisnikId(long grupaXKorisnikId) {
		this.grupaXKorisnikId = grupaXKorisnikId;
	}

	public Integer getGrupaId() {
		return grupaId;
	}

	public void setGrupaId(Integer grupaId) {
		this.grupaId = grupaId;
	}

	public Integer getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Integer korisnikId) {
		this.korisnikId = korisnikId;
	}

	public Date getDatumPristupa() {
		return datumPristupa;
	}

	public void setDatumPristupa(Date datumPristupa) {
		this.datumPristupa = datumPristupa;
	}

	public Date getDatumZadnjeIzmjene() {
		return datumZadnjeIzmjene;
	}

	public void setDatumZadnjeIzmjene(Date datumZadnjeIzmjene) {
		this.datumZadnjeIzmjene = datumZadnjeIzmjene;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}