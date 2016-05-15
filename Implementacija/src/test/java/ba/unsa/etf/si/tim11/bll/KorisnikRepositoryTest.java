package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

import java.util.Date;
import java.util.List;

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
	korRep.dodajKorisnika(korModel);
	Assert.assertTrue(KorisnikRepository.korisnikAutenticiran(korModel.getUsername(), korModel.getPassword()));;
    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
 
	//fail("Not yet implemented");
	}
@Test
	public void testDajKorisnike() {
	KorisnikRepository korRep = new KorisnikRepository();
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
	korModel.setUsername("korisnickoIme");
	korRep.dodajKorisnika(korModel);
	
	List<KorisnikDbModel> korisnici = korRep.dajSveKorisnike();
	
	assertTrue(korisnici.size() > 0);
	
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
		KorisnikRepository korRep = new KorisnikRepository();
		
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		korTip.setAktivan(true);
		korTip.setKorisnikTipNaziv("naziv tipa");
		DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(korTip);
		List<KorisnikTipDbModel> lista = korRep.dajSveTipoveKorisnika();
		
		assertTrue(lista.size() > 0);
	}
@Test
	public void testDajSvePozicijeKorisnika() {
	
		KorisnikRepository korRep = new KorisnikRepository();
		
		KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
		pozicija.setKorisnikPozicijaNaziv("neki direktor");
		pozicija.setAktivan(true);
		DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicija);
		
		List<KorisnikPozicijaDbModel> lista = korRep.dajSvePozicijeKorisnika();
		
		assertTrue(lista.size() > 0);
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
		
		KorisnikRepository korRep = new KorisnikRepository();
		
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		korTip.setAktivan(true);
		korTip.setKorisnikTipNaziv("naziv tipa");
		DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(korTip);
		List<KorisnikTipDbModel> lista = korRep.dajSveKorisnikTipove();
		
		assertTrue(lista.size() > 0);
	
	
	//fail("Not yet implemented");
	}
	@Test
	public void testDajPravaKorisnikaNaFolder() 
	{
		
		KorisnikRepository korRep = new KorisnikRepository();
		KorisnikDbModel korModel = new KorisnikDbModel();
		KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		
		korTip.setAktivan(true);
		korTip.setKorisnikTipNaziv("Administrator");
		
		long idTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(korTip);
		
		pozicija.setKorisnikPozicijaNaziv("neki direktor");
		pozicija.setAktivan(true);
		
		long idPozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicija);
		
		korModel.setAdresa("neka adresa");
		korModel.setAktivan(true);
		korModel.setDatumRodjenja(new Date());
		korModel.setIme("neko ime");
		
		korModel.setKorisnikPozicijaId((int) idPozicije);
		korModel.setKorisnikTipId((int)idTipa);
		
		korModel.setPassword("pass");
		korModel.setPrezime("neko prezime");
		korModel.setUsername("user");
		korRep.dodajKorisnika(korModel);
		
		FolderDbModel fm =new FolderDbModel();
		fm.setFolderNaziv("neki folder");
		fm.setKreiraoKorisnikId((int)korRep.dajIdKorisnikaPoUsername(korModel.getUsername()));
		fm.setAktivan(true);
		long idFoldera = DbDMSContext.getInstance().getFolderi().sacuvaj(fm);
		FolderDbModel sacuvani = DbDMSContext.getInstance().getFolderi().ucitaj(idFoldera);
		
		Assert.assertEquals(0, korRep.dajPravaKorisnikaNaFolder(korModel.getUsername(), sacuvani));
	    DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
	    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
	    DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
	    DbDMSContext.getInstance().getFolderi().obrisi(sacuvani);
		
	}

	@Test
	public void testDajKorisnikeGrupe() {
		
		KorisnikRepository korRep = new KorisnikRepository();
//	GrupaRepository grupaRep = new GrupaRepository();
		
		KorisnikDbModel korModel = new KorisnikDbModel();
		KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		korTip.setAktivan(true);
		korTip.setKorisnikTipNaziv("Administrator");
		//long idTipa =DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(korTip);
		pozicija.setKorisnikPozicijaNaziv("neki direktor");
		pozicija.setAktivan(true);
		long idPozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicija);
		korModel.setAdresa("neka adresa");
		korModel.setAktivan(true);
		korModel.setDatumRodjenja(new Date());
		korModel.setIme("neko ime");
		korModel.setKorisnikPozicija(pozicija);
		korModel.setKorisnikPozicijaId((int) idPozicije);
		korModel.setKorisnikTipId((int)korTip.getKorisnikTipId());
		korModel.setPassword("pass");
		korModel.setPrezime("neko prezime");
		korModel.setUsername("user");
		korRep.dodajKorisnika(korModel);
		
		GrupaDbModel grupa = new GrupaDbModel();
		
		grupa.setAktivan(true);
		grupa.setDatumKreiranja(new Date());
		grupa.setGrupaNaziv("naziv grupe");
		long idGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		//grupa.setOdgovorniKorisnikId(korRep.dajIdKorisnikaPoUsername(korModel.getUsername()));
		
		GrupaXKorisnikDbModel kg = new GrupaXKorisnikDbModel();
		kg.setAktivan(true);
		kg.setDatumZadnjeIzmjene(new Date());
		kg.setDatumPristupa(new Date());
		kg.setGrupaId((int)idGrupe);
		kg.setKorisnikId((int)korModel.getKorisnikID());
		
		DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(kg);
		
		List<KorisnikDbModel> lista = korRep.dajKorisnikeGrupe((int)idGrupe);
		
		assertTrue(lista.size() > 0);
		
	}

}
