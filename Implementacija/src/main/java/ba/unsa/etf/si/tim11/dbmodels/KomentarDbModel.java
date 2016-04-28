package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class KomentarDbModel implements java.io.Serializable{

	@Id
    @GeneratedValue
	private long komentarId;
	private Integer korisnikId;
	private Integer dokumentVerzijaId;
	private Date dokumentVrijemeKreiranja;
	private Boolean aktivan;

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

	public Date getDokumentVrijemeKreiranja() {
		return dokumentVrijemeKreiranja;
	}

	public void setDokumentVrijemeKreiranja(Date dokumentVrijemeKreiranja) {
		this.dokumentVrijemeKreiranja = dokumentVrijemeKreiranja;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}