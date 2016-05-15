package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table (name = "ZahtjevDbModel")
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

	@ManyToOne
	@JoinColumn(name="kreiraoKorisnikId")
	private KorisnikDbModel kreiraoKorisnik;
	
	@ManyToOne
	@JoinColumn(name="upucenoKorisnikId")
	private KorisnikDbModel upucenoKorisnik;
	
	@ManyToOne
	@JoinColumn(name="zahtjevTipId")
	private ZahtjevTipDbModel zahtjevTip;
	
	@ManyToOne
	@JoinColumn(name="zahtjevStatusId")
	private ZahtjevStatusDbModel zahtjevStatus;
	
	@ManyToOne
	@JoinColumn(name="dokumentVerzijaId")
	private DokumentVerzijaDbModel dokumentVerzija;
	
	
	public KorisnikDbModel getKreiraoKorisnik() {
		return kreiraoKorisnik;
	}

	public void setKreiraoKorisnik(KorisnikDbModel kreiraoKorisnik) {
		this.kreiraoKorisnik = kreiraoKorisnik;
	}

	public KorisnikDbModel getUpucenoKorisnik() {
		return upucenoKorisnik;
	}

	public void setUpucenoKorisnik(KorisnikDbModel upucenoKorisnik) {
		this.upucenoKorisnik = upucenoKorisnik;
	}

	public ZahtjevTipDbModel getZahtjevTip() {
		return zahtjevTip;
	}

	public void setZahtjevTip(ZahtjevTipDbModel zahtjevTip) {
		this.zahtjevTip = zahtjevTip;
	}

	public ZahtjevStatusDbModel getZahtjevStatus() {
		return zahtjevStatus;
	}

	public void setZahtjevStatus(ZahtjevStatusDbModel zahtjevStatus) {
		this.zahtjevStatus = zahtjevStatus;
	}

	public DokumentVerzijaDbModel getDokumentVerzija() {
		return dokumentVerzija;
	}

	public void setDokumentVerzija(DokumentVerzijaDbModel dokumentVerzija) {
		this.dokumentVerzija = dokumentVerzija;
	}

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