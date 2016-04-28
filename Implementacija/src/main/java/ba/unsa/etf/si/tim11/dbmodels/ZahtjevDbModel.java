package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Date;

@Entity
public class ZahtjevDbModel implements java.io.Serializable {

	@Id
    @GeneratedValue
	private long zahtjevId;
	private Date datumVrijemeKreiranja;
	private Integer kreiraoKorisnikId;
	private Integer upucenoKorisnikId;
	private Integer zahtjevTipId;
	private Integer zahtjevStatusId;
	private Integer dokumentVerzijaId;
	private Boolean aktivan;

	public long getZahtjevId() {
		return zahtjevId;
	}

	public void setZahtjevId(long zahtjevId) {
		this.zahtjevId = zahtjevId;
	}

	public Date getDatumVrijemeKreiranja() {
		return datumVrijemeKreiranja;
	}

	public void setDatumVrijemeKreiranja(Date datumVrijemeKreiranja) {
		this.datumVrijemeKreiranja = datumVrijemeKreiranja;
	}

	public Integer getKreiraoKorisnikId() {
		return kreiraoKorisnikId;
	}

	public void setKreiraoKorisnikId(Integer kreiraoKorisnikId) {
		this.kreiraoKorisnikId = kreiraoKorisnikId;
	}

	public Integer getUpucenoKorisnikId() {
		return upucenoKorisnikId;
	}

	public void setUpucenoKorisnikId(Integer upucenoKorisnikId) {
		this.upucenoKorisnikId = upucenoKorisnikId;
	}

	public Integer getZahtjevTipId() {
		return zahtjevTipId;
	}

	public void setZahtjevTipId(Integer zahtjevTipId) {
		this.zahtjevTipId = zahtjevTipId;
	}

	public Integer getZahtjevStatusId() {
		return zahtjevStatusId;
	}

	public void setZahtjevStatusId(Integer zahtjevStatusId) {
		this.zahtjevStatusId = zahtjevStatusId;
	}

	public Integer getDokumentVerzijaId() {
		return dokumentVerzijaId;
	}

	public void setDokumentVerzijaId(Integer dokumentVerzijaId) {
		this.dokumentVerzijaId = dokumentVerzijaId;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}