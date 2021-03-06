package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.DokumentRepository;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;

import java.util.Date;

import org.junit.Assert;
//import org.junit.Assert;
import org.junit.Test;

public class DokumentRepositoryTest {

	@Test
	public void testDodajDokument() {
		
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
		
		DokumentRepository dokRep=new DokumentRepository();
		DokumentDbModel dokModel =new DokumentDbModel();
		DokumentVerzijaDbModel dokVer=new DokumentVerzijaDbModel();
		dokModel.setAktivan(true);
		dokModel.setDokumentNaziv("naziv dokumenta");
		dokModel.setEkstenzija("eks");
		//long idDok=DbDMSContext.getInstance().getDokumenti().sacuvaj(dokModel);
		dokVer.setAktivan(true);
		dokVer.setDokument(dokModel);
		//dokVer.setDokumentId((int) idDok);
		String sadrzaj = "neki text nesto..";
		Sesija.setUsername("user");
		Sesija.setCertifikatAktivan(true);
		//byte[] nizbajta= sadrzaj.getBytes();
		dokVer.setSadrzaj(sadrzaj.getBytes());
		Assert.assertTrue(dokRep.dodajDokument(dokModel, dokVer.getSadrzaj()));
		//dokVer.setSadrzaj(000011110001);
		//Assert.assertTrue(dokRep.dodajDokument(dokModel, nizbajta));
		//fail("Not yet implemented");
	}

	@Test
	public void testDodajverzijuDokumenta() {
		
		
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
		
		DokumentRepository dokRep=new DokumentRepository();
		DokumentDbModel dokModel =new DokumentDbModel();
		DokumentVerzijaDbModel dokVer=new DokumentVerzijaDbModel();
		dokModel.setAktivan(true);
		dokModel.setDokumentNaziv("naziv dokumenta");
		dokModel.setEkstenzija("eks");
		long idDok=DbDMSContext.getInstance().getDokumenti().sacuvaj(dokModel);
		dokVer.setAktivan(true);
		dokVer.setDokument(dokModel);
		dokVer.setDokumentId((int) idDok);
		String sadrzaj = "neki text nesto..";
		Sesija.setUsername("user");
		Sesija.setCertifikatAktivan(true);
		//byte[] nizbajta= sadrzaj.getBytes();
		dokVer.setSadrzaj(sadrzaj.getBytes());
		Assert.assertTrue(dokRep.dodajverzijuDokumenta(dokVer));
		//dokVer.setSadrzaj(000011110001);
		//Assert.assertTrue(dokRep.dodajDokument(dokModel, nizbajta));
		//fail("Not yet implemented");
	}

	@Test
	public void testDajVerzijuDokumenta() {
		//fail("Not yet implemented");
	}

	@Test
	public void testObrisiDokument() {
		
		
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
		
		DokumentRepository dokRep=new DokumentRepository();
		DokumentDbModel dokModel =new DokumentDbModel();
		DokumentVerzijaDbModel dokVer=new DokumentVerzijaDbModel();
		dokModel.setAktivan(true);
		dokModel.setDokumentNaziv("naziv dokumenta");
		dokModel.setEkstenzija("eks");
		long idDok=DbDMSContext.getInstance().getDokumenti().sacuvaj(dokModel);
		dokVer.setAktivan(true);
		dokVer.setDokument(dokModel);
		//dokVer.setDokumentId((int) idDok);
		String sadrzaj = "neki text nesto..";
		Sesija.setUsername("user");
		Sesija.setCertifikatAktivan(true);
		//byte[] nizbajta= sadrzaj.getBytes();
		dokVer.setSadrzaj(sadrzaj.getBytes());
		Assert.assertTrue(dokRep.obrisiDokument((int) idDok));
		//dokVer.setSadrzaj(000011110001);
		
		//fail("Not yet implemented");
	}

	/*@Test
	public void testObrisiVerzijuDokumenta() {
		//fail("Not yet implemented");
	}
*/
	@Test
	public void testDajDokumente() {
		
		
		KorisnikDbModel korModel = new KorisnikDbModel();
		//KorisnikDbModel kor_noviModel= new KorisnikDbModel();
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
		FolderDbModel foldModel=new FolderDbModel();
		FolderDbModel roditeljModel=new FolderDbModel();
		roditeljModel.setAktivan(true);
		roditeljModel.setFolderNaziv("naziv");
		foldModel.setAktivan(true);
		foldModel.setFolderNaziv("naziv foldera");
		foldModel.setRoditeljFolder(roditeljModel);
		foldModel.setKreiraoKorisnik(korModel);
		foldModel.setFolderId(1);
		foldModel.setKreiraoKorisnikId((int)korModel.getKorisnikID());
		foldModel.setRoditeljFolderId((int)roditeljModel.getFolderId());
		
		
		long idKor = DbDMSContext.getInstance().getKorisnici().sacuvaj(korModel);
		long idFold = DbDMSContext.getInstance().getFolderi().sacuvaj(foldModel);
		
		DokumentRepository dokRep=new DokumentRepository();
		DokumentDbModel dokModel =new DokumentDbModel();
		DokumentVerzijaDbModel dokVer=new DokumentVerzijaDbModel();
		dokModel.setAktivan(true);
		dokModel.setDokumentNaziv("naziv dokumenta");
		dokModel.setEkstenzija("eks");
		long idDok=DbDMSContext.getInstance().getDokumenti().sacuvaj(dokModel);
		dokVer.setAktivan(true);
		dokVer.setDokument(dokModel);
		dokVer.setDokumentId((int) idDok);
		String sadrzaj = "neki text nesto..";
		Sesija.setUsername("user");
		Sesija.setCertifikatAktivan(true);
		byte[] nizbajta= sadrzaj.getBytes();
		dokVer.setSadrzaj(sadrzaj.getBytes());
		//int broj= dokRep.dajDokumente(i)
		dokRep.dodajDokument(dokModel, nizbajta);
		Assert.assertEquals(dokModel, dokRep.dajDokumente((int) idFold));
		//dokVer.setSadrzaj(000011110001);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testDajVerzijeDokumenta() {
		//fail("Not yet implemented");
	}

}
