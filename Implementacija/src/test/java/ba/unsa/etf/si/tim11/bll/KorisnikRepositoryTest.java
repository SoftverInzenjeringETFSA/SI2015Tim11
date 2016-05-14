package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
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
	korModel.setDatumRodjenja(new Date());
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
    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
 
	//fail("Not yet implemented");
	}
@Test
	public void testKorisnikPostoji() {
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
	korModel.setDatumRodjenja(new Date());
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	//long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	korRep.dodajKorisnika(korModel);
	Assert.assertTrue(KorisnikRepository.korisnikPostoji(korModel.getUsername(), korModel.getPassword()));	
    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
 
	//fail("Not yet implemented");
	}
@Test
	public void testKorisnikAutenticiran() {
		
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
	korModel.setDatumRodjenja(new Date());
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	//long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	korRep.dodajKorisnika(korModel);
	Assert.assertTrue(KorisnikRepository.korisnikAutenticiran(korModel.getUsername(), korModel.getPassword()));;
    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
 
	//fail("Not yet implemented");
	}
@Test
	public void testDajKorisnike() {
		fail("Not yet implemented");
	}
@Test
	public void testDajSveKorisnike() {
		
	KorisnikRepository korRep = new KorisnikRepository();
	//KorisnikRepository korRep_novi = new KorisnikRepository();
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
	korModel.setDatumRodjenja(new Date());
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	//long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	int brojKor =korRep.dajSveKorisnike().size();
	korRep.dodajKorisnika(korModel);
	Assert.assertEquals(brojKor+1, korRep.dajSveKorisnike().size());
    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
 
	//fail("Not yet implemented");
	}
@Test
	public void testDodajKorisnika() {
	
	KorisnikRepository korRep = new KorisnikRepository();
	//KorisnikRepository korRep_novi = new KorisnikRepository();
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
	korModel.setDatumRodjenja(new Date());
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	//long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	//int brojKor =korRep.dajSveKorisnike().size();
	korRep.dodajKorisnika(korModel);
	Assert.assertTrue(korModel.getAktivan());
    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
 	//fail("Not yet implemented");
	}
@Test
	public void testIzmijeniKorisnika() {
		
	KorisnikRepository korRep = new KorisnikRepository();
	//KorisnikRepository korRep_novi = new KorisnikRepository();
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
	korModel.setDatumRodjenja(new Date());
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	//long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	//int brojKor =korRep.dajSveKorisnike().size();
	korRep.dodajKorisnika(korModel);
	Assert.assertTrue(korRep.izmijeniKorisnika(korModel));
    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
 
	//fail("Not yet implemented");
	}
@Test
	public void testObrisiKorisnika() {
	
	KorisnikRepository korRep = new KorisnikRepository();
	//KorisnikRepository korRep_novi = new KorisnikRepository();
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
	korModel.setDatumRodjenja(new Date());
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	//int brojKor =korRep.dajSveKorisnike().size();
	korRep.dodajKorisnika(korModel);
	Assert.assertTrue(korRep.obrisiKorisnika((int) idKor));

	//fail("Not yet implemented");
	}
@Test
	public void testKorisnikRepository() {
		
	
	//fail("Not yet implemented");
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
	
	KorisnikRepository korRep = new KorisnikRepository();
	//KorisnikRepository korRep_novi = new KorisnikRepository();
	KorisnikDbModel korModel = new KorisnikDbModel();
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
	korModel.setDatumRodjenja(new Date());
	korModel.setIme("neko ime");
	korModel.setKorisnikPozicija(pozicija);
	korModel.setKorisnikPozicijaId((int) idPozicije);
	korModel.setKorisnikTip(korTip);
	korModel.setKorisnikTipId((int) idTipa);
	korModel.setPassword("pass");
	korModel.setPrezime("neko prezime");
	korModel.setUsername("user");
	//long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	//KorisnikDbModel kor_noviModel= korRep.dajKorisnika((int) idKor);
	//int brojKor =korRep.dajSveKorisnike().size();
	korRep.dodajKorisnika(korModel);
	//Assert.assertEquals((int)idKor, korRep.dajIdKorisnikaPoUsername(korModel.getUsername()));
	
	
	//fail("Not yet implemented");
	}
@Test
	public void testDajSveKorisnikTipove() {
		
	
	
	//fail("Not yet implemented");
	}
@Test
	public void testDajPravaKorisnikaNaFolder() {
		

	KorisnikRepository korRep = new KorisnikRepository();
	//KorisnikRepository korRep_novi = new KorisnikRepository();
	KorisnikDbModel korModel = new KorisnikDbModel();
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
	//long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
	//KorisnikDbModel kor_noviModel= korRep.dajKorisnika((int) idKor);
	//int brojKor =korRep.dajSveKorisnike().size();
	korRep.dodajKorisnika(korModel);
	FolderDbModel fm =new FolderDbModel();
	int pravo=0;
	Assert.assertEquals(pravo, korRep.dajPravaKorisnikaNaFolder(korModel.getUsername(), fm));
	
	//fail("Not yet implemented");
	}
@Test
	public void testDajKorisnikeGrupe() {
		fail("Not yet implemented");
	}

}
