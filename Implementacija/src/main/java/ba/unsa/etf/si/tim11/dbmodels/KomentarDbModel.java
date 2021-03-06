package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
public class KomentarDbModel implements java.io.Serializable{

	@Id
    @GeneratedValue
	private long komentarId;
	private Integer korisnikId;
	private Integer dokumentVerzijaId;
	private String komentar;
	private Date datumVrijemeKomentara;
	private Boolean aktivan;

	@ManyToOne
	@JoinColumn(name="korisnikId")
	private KorisnikDbModel korisnik;
	
	public KorisnikDbModel getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(KorisnikDbModel korisnik) {
		this.korisnik = korisnik;
	}

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	
	public DokumentVerzijaDbModel getDokumentVerzija() {
		return dokumentVerzija;
	}

	public void setDokumentVerzija(DokumentVerzijaDbModel dokumentVerzija) {
		this.dokumentVerzija = dokumentVerzija;
	}

	@ManyToOne
	@JoinColumn(name="dokumentVerzijaId")
	private DokumentVerzijaDbModel dokumentVerzija;
	
	
	public long getKomentarId() {
		return komentarId;
	}

	public void setKomentarId(long komentarId) {
		this.komentarId = komentarId;
	}

	public Integer getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Integer korisnikId) {
		this.korisnikId = korisnikId;
	}

	public Integer getDokumentVerzijaId() {
		return dokumentVerzijaId;
	}

	public void setDokumentVerzijaId(Integer dokumentVerzijaId) {
		this.dokumentVerzijaId = dokumentVerzijaId;
	}

	public Date getDatumVrijemeKomentara() {
		return datumVrijemeKomentara;
	}

	public void setDatumVrijemeKomentara(Date datumVrijemeKomentara) {
		this.datumVrijemeKomentara = datumVrijemeKomentara;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}