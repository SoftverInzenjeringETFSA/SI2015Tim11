package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.DokumentRepository;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;
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
		//fail("Not yet implemented");
	}

	@Test
	public void testDajVerzijuDokumenta() {
		//fail("Not yet implemented");
	}

	@Test
	public void testObrisiDokument() {
		//fail("Not yet implemented");
	}

	@Test
	public void testObrisiVerzijuDokumenta() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajDokumente() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajVerzijeDokumenta() {
		//fail("Not yet implemented");
	}

}
