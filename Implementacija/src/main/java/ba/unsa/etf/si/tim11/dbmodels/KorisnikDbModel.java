package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;

@Entity
public class KorisnikDbModel implements java.io.Serializable {
	
	@Id
    @GeneratedValue
    @Column(name = "KorisniID")
	private long korisnikID;
	
	private String ime;
	private String prezime;
	private String adresa;
	private Date datumRodjenja;
	private String username;
	private String password;
	private Integer korisnikTipId;
	private Integer korisnikPozicijaId;
	private Boolean aktivan;
	
	@ManyToOne
	@JoinColumn(name="korisnikTipId")
	private KorisnikTipDbModel korisnikTip;
	
	@ManyToOne
	@JoinColumn(name="korisnikPozicijaId")
	private KorisnikPozicijaDbModel korisnikPozicija;
	
	public KorisnikPozicijaDbModel getKorisnikPozicija() {
		return korisnikPozicija;
	}

	public void setKorisnikPozicija(KorisnikPozicijaDbModel korisnikPozicija) {
		this.korisnikPozicija = korisnikPozicija;
	}

	public KorisnikTipDbModel getKorisnikTip() {
		return korisnikTip;
	}

	public void setKorisnikTip(KorisnikTipDbModel korisnikTip) {
		this.korisnikTip = korisnikTip;
	}

	public long getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(long korisnikID) {
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
	
	@Override
    public String toString()
    {
        return ime+" "+prezime;
    }
}