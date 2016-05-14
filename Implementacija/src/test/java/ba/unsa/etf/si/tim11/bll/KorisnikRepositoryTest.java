package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class KorisnikRepositoryTest extends TestCase {
@Test
	public void testDajKorisnika() {
	KorisnikRepository korRep = new KorisnikRepository();
	KorisnikDbModel korModel = new KorisnikDbModel();
	//KorisnikDbModel kor_noviModel= new KorisnikDbModel();
	KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
	KorisnikTipDbModel korTip = new KorisnikTipDbModel();
	korTip.setAktivan(true);
	korTip.setKorisnikTipNaziv("naziv tipa");
	long idTipa =DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(korTip);
	pozicija.setKorisnikPozicijaNaziv("neki direktor");
	pozicija.setAktivan(true);
	long idPozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicija);
	korModel.setAdresa("neka adresa");
	korModel.setAktivan(true);
	korModel.setDatumRodjenja(new Date("02.02.2001"));
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	korRep.dodajKorisnika(korModel);
	Assert.assertEquals(korModel.getIme(), korRep.dajKorisnika((int) idKor).getIme());
		//fail("Not yet implemented");
	}
@Test
	public void testKorisnikPostoji() {
		fail("Not yet implemented");
	}
@Test
	public void testKorisnikAutenticiran() {
		fail("Not yet implemented");
	}
@Test
	public void testDajKorisnike() {
		fail("Not yet implemented");
	}
@Test
	public void testDajSveKorisnike() {
		fail("Not yet implemented");
	}
@Test
	public void testDodajKorisnika() {
		fail("Not yet implemented");
	}
@Test
	public void testIzmijeniKorisnika() {
		fail("Not yet implemented");
	}
@Test
	public void testObrisiKorisnika() {
		fail("Not yet implemented");
	}
@Test
	public void testKorisnikRepository() {
		fail("Not yet implemented");
	}
@Test
	public void testDajSveTipoveKorisnika() {
		fail("Not yet implemented");
	}
@Test
	public void testDajSvePozicijeKorisnika() {
		fail("Not yet implemented");
	}
@Test
	public void testDajIdKorisnikaPoUsername() {
		fail("Not yet implemented");
	}
@Test
	public void testDajSveKorisnikTipove() {
		fail("Not yet implemented");
	}
@Test
	public void testDajPravaKorisnikaNaFolder() {
		fail("Not yet implemented");
	}
@Test
	public void testDajKorisnikeGrupe() {
		fail("Not yet implemented");
	}

}
