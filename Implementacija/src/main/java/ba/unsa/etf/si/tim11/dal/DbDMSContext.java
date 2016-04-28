package ba.unsa.etf.si.tim11.dal;

public class DbDMSContext {

	private static DbDMSContext instance;

	private DokumentDALRepository dokumenti;
	private ZahtjevDALRepository zahtjevi;
	private KorisnikTipDALRepository korisnikTipovi;
	private ZahtjevTipDALRepository zahtjevTipovi;
	private ZahtjevStatusDALRepository zahtjevStatusi;
	private DokumentVerzijaDAlRepository dokumentiVerzije;
	private DokumentVerzijaStatusDALRepository dokumentVerzijaStatusi;
	private GrupaDALRepository grupe;
	private KorisnikPozicijaDALRepository korisnikPozicije;
	private KorisnikDALRepository korisnici;
	private GrupaXKorisnikDALRepository grupeKorisnici;
	private FolderDALRepository folderi;
	private FolderXGrupaDALRepository folderiGrupe;

	private DbDMSContext() {
		korisnici = new KorisnikDALRepository();
		korisnikPozicije = new KorisnikPozicijaDALRepository();
		korisnikTipovi = new KorisnikTipDALRepository();
		dokumenti = new DokumentDALRepository();
		dokumentiVerzije = new DokumentVerzijaDAlRepository();
		dokumentVerzijaStatusi = new DokumentVerzijaStatusDALRepository();
		zahtjevi = new ZahtjevDALRepository();
		zahtjevStatusi = new ZahtjevStatusDALRepository();
		zahtjevTipovi = new ZahtjevTipDALRepository();
		grupe = new GrupaDALRepository();
		grupeKorisnici = new GrupaXKorisnikDALRepository();
		folderi = new FolderDALRepository();
		folderiGrupe = new FolderXGrupaDALRepository();
	}

	public static DbDMSContext getInstance() {
		if(instance == null) {
			instance = new DbDMSContext();
		}
		return instance;
	}

	public DokumentDALRepository getDokumenti() {
		return dokumenti;
	}

	public void setDokumenti(DokumentDALRepository dokumenti) {
		this.dokumenti = dokumenti;
	}

	public ZahtjevDALRepository getZahtjevi() {
		return zahtjevi;
	}

	public void setZahtjevi(ZahtjevDALRepository zahtjevi) {
		this.zahtjevi = zahtjevi;
	}

	public KorisnikTipDALRepository getKorisnikTipovi() {
		return korisnikTipovi;
	}

	public void setKorisnikTipovi(KorisnikTipDALRepository korisnikTipovi) {
		this.korisnikTipovi = korisnikTipovi;
	}

	public ZahtjevTipDALRepository getZahtjevTipovi() {
		return zahtjevTipovi;
	}

	public void setZahtjevTipovi(ZahtjevTipDALRepository zahtjevTipovi) {
		this.zahtjevTipovi = zahtjevTipovi;
	}

	public ZahtjevStatusDALRepository getZahtjevStatusi() {
		return zahtjevStatusi;
	}

	public void setZahtjevStatusi(ZahtjevStatusDALRepository zahtjevStatusi) {
		this.zahtjevStatusi = zahtjevStatusi;
	}

	public DokumentVerzijaDAlRepository getDokumentiVerzije() {
		return dokumentiVerzije;
	}

	public void setDokumentiVerzije(DokumentVerzijaDAlRepository dokumentiVerzije) {
		this.dokumentiVerzije = dokumentiVerzije;
	}

	public DokumentVerzijaStatusDALRepository getDokumentVerzijaStatusi() {
		return dokumentVerzijaStatusi;
	}

	public void setDokumentVerzijaStatusi(DokumentVerzijaStatusDALRepository dokumentVerzijaStatusi) {
		this.dokumentVerzijaStatusi = dokumentVerzijaStatusi;
	}

	public GrupaDALRepository getGrupe() {
		return grupe;
	}

	public void setGrupe(GrupaDALRepository grupe) {
		this.grupe = grupe;
	}

	public KorisnikPozicijaDALRepository getKorisnikPozicije() {
		return korisnikPozicije;
	}

	public void setKorisnikPozicije(KorisnikPozicijaDALRepository korisnikPozicije) {
		this.korisnikPozicije = korisnikPozicije;
	}

	public KorisnikDALRepository getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(KorisnikDALRepository korisnici) {
		this.korisnici = korisnici;
	}

	public GrupaXKorisnikDALRepository getGrupeKorisnici() {
		return grupeKorisnici;
	}

	public void setGrupeKorisnici(GrupaXKorisnikDALRepository grupeKorisnici) {
		this.grupeKorisnici = grupeKorisnici;
	}

	public FolderDALRepository getFolderi() {
		return folderi;
	}

	public void setFolderi(FolderDALRepository folderi) {
		this.folderi = folderi;
	}

	public FolderXGrupaDALRepository getFolderiGrupe() {
		return folderiGrupe;
	}

	public void setFolderiGrupe(FolderXGrupaDALRepository folderiGrupe) {
		this.folderiGrupe = folderiGrupe;
	}
}