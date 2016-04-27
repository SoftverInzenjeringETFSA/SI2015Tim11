package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class KorisnikDbModel extends BaseDbModel {

	private Integer korisnikID;
	private String ime;
	private String prezime;
	private String adresa;
	private Date datumRodjenja;
	private String username;
	private String password;
	private Integer korisnikTipId;
	private Integer korisnikPozicijaId;
	private Boolean aktivan;

	public Integer getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(Integer korisnikID) {
		this.korisnikID = korisnikID;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getKorisnikTipId() {
		return korisnikTipId;
	}

	public void setKorisnikTipId(Integer korisnikTipId) {
		this.korisnikTipId = korisnikTipId;
	}

	public Integer getKorisnikPozicijaId() {
		return korisnikPozicijaId;
	}

	public void setKorisnikPozicijaId(Integer korisnikPozicijaId) {
		this.korisnikPozicijaId = korisnikPozicijaId;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}