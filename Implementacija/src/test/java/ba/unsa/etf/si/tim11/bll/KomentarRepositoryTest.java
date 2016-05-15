package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.KomentarRepository;
import ba.unsa.etf.si.tim11.dbmodels.KomentarDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class KomentarRepositoryTest {

	@Test
	public void testDodajKomentar() {
	/*	KorisnikDbModel korModel = new KorisnikDbModel();
		KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		korTip.setAktivan(true);
		korTip.setKorisnikTipNaziv("Administrator");
		long idTipa =DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(korTip);
		pozicija.setKorisnikPozicijaNaziv("neki direktor");
		pozicija.setAktivan(true);
		long idPozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicija);
		korModel.setAdresa("neka adresa");
		korModel.setAktivan(true);
		korModel.setDatumRodjenja(new Date());
		korModel.setIme("neko ime");
		korModel.setKorisnikPozicija(pozicija);
		korModel.setKorisnikPozicijaId((int) idPozicije);
		korModel.setKorisnikTip(korTip);
		korModel.setKorisnikTipId((int) idTipa);
		korModel.setPassword("pass");
		korModel.setPrezime("neko prezime");
		korModel.setUsername("user");
		long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);*/
		KomentarDbModel komModel=new KomentarDbModel();
		KomentarRepository komRep=new KomentarRepository();
		/*DokumentVerzijaDbModel dokVerzija =new DokumentVerzijaDbModel();
		DokumentDbModel dok=new DokumentDbModel();
		FolderDbModel fm =new FolderDbModel();
		fm.setAktivan(true);
		fm.setFolderNaziv("naziv foldera");
		fm.setKreiraoKorisnikId((int) korModel.getKorisnikID());
		long folderId=DbDMSContext.getInstance().getFolderi().sacuvaj(fm);
		dok.setDokumentNaziv("neki naziv dokumenta");
		dok.setEkstenzija("exe");
		dok.setFolder(fm);
		dok.setFolderId((int) folderId);
		long dokId=DbDMSContext.getInstance().getDokumenti().sacuvaj(dok);
		dokVerzija.setAktivan(true);
		dokVerzija.setDokument(dok);
		dokVerzija.setDokumentId((int) dokId);
		dokVerzija.setPostavioKorisnik(korModel);
		dokVerzija.setPostavioKorisnikId((int) idKor);
		long dokV=DbDMSContext.getInstance().getDokumentiVerzije().sacuvaj(dokVerzija);*/
		komModel.setAktivan(true);
		komModel.setDatumVrijemeKomentara(new Date());
		//komModel.setDokumentVerzija(dokVerzija);
		//komModel.setDokumentVerzijaId((int) dokV);
		komModel.setKomentar("neki komentar");
		//komModel.setKorisnik(korModel);
		//komModel.setKorisnikId((int) idKor);
		
		Assert.assertTrue(komRep.dodajKomentar(komModel));
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testObrisiKomentar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajKomentar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajKomentareZaVerziju() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajKomentare() {
		/*	KorisnikDbModel korModel = new KorisnikDbModel();
		KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		korTip.setAktivan(true);
		korTip.setKorisnikTipNaziv("Administrator");
		long idTipa =DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(korTip);
		pozicija.setKorisnikPozicijaNaziv("neki direktor");
		pozicija.setAktivan(true);
		long idPozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicija);
		korModel.setAdresa("neka adresa");
		korModel.setAktivan(true);
		korModel.setDatumRodjenja(new Date());
		korModel.setIme("neko ime");
		korModel.setKorisnikPozicija(pozicija);
		korModel.setKorisnikPozicijaId((int) idPozicije);
		korModel.setKorisnikTip(korTip);
		korModel.setKorisnikTipId((int) idTipa);
		korModel.setPassword("pass");
		korModel.setPrezime("neko prezime");
		korModel.setUsername("user");
		long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);*/
		KomentarDbModel komModel=new KomentarDbModel();
		KomentarRepository komRep=new KomentarRepository();
		DokumentVerzijaDbModel dokVerzija =new DokumentVerzijaDbModel();
		/*DokumentDbModel dok=new DokumentDbModel();
		FolderDbModel fm =new FolderDbModel();
		fm.setAktivan(true);
		fm.setFolderNaziv("naziv foldera");
		fm.setKreiraoKorisnikId((int) korModel.getKorisnikID());
		long folderId=DbDMSContext.getInstance().getFolderi().sacuvaj(fm);
		dok.setDokumentNaziv("neki naziv dokumenta");
		dok.setEkstenzija("exe");
		dok.setFolder(fm);
		dok.setFolderId((int) folderId);
		long dokId=DbDMSContext.getInstance().getDokumenti().sacuvaj(dok);*/
		dokVerzija.setAktivan(true);
		//dokVerzija.setDokument(dok);
		//dokVerzija.setDokumentId((int) dokId);
		//dokVerzija.setPostavioKorisnik(korModel);
		//dokVerzija.setPostavioKorisnikId((int) idKor);
		long dokV=DbDMSContext.getInstance().getDokumentiVerzije().sacuvaj(dokVerzija);
		komModel.setAktivan(true);
		komModel.setDatumVrijemeKomentara(new Date());
		komModel.setDokumentVerzija(dokVerzija);
		komModel.setDokumentVerzijaId((int) dokV);
		komModel.setKomentar("neki komentar");
		long komId= DbDMSContext.getInstance().getKomentari().sacuvaj(komModel);
		//komModel.setKorisnik(korModel);
		//komModel.setKorisnikId((int) idKor);
		int brKom=komRep.dajKomentare((int) dokV).size();
		komRep.dodajKomentar(komModel);
		Assert.assertEquals(brKom+1, komRep.dajKomentare((int) dokV).size());
		
		//fail("Not yet implemented");
	}

}
