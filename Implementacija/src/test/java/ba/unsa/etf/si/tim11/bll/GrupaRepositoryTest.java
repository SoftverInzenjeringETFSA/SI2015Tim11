package ba.unsa.etf.si.tim11.bll;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

public class GrupaRepositoryTest {

	private GrupaRepository grupaRep = new GrupaRepository();
	
	private GrupaDbModel kreirajMiGrupu(Integer idOdgovornog)
	{
		GrupaDbModel grupa = new GrupaDbModel();
		grupa.setAktivan(true);
		grupa.setDatumKreiranja(new Date());
		grupa.setGrupaNaziv("naziv grupe");
		grupa.setOdgovorniKorisnikId(idOdgovornog);
		return grupa;
	}
	
	private KorisnikDbModel kreirajMiKorisnika()
	{	
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
		return korModel;
	}
	
	@Test
	public void testDajGrupu() {
		
	}

	@Test
	public void testDajGrupe() {
		
	}

	@Test
	public void testIzmijeniGrupu() {
		
	}

	@Test
	public void testObrisiGrupu() {
		//Grupa 
	}

	@Test
	public void testUkloniSveKorisnikeIzGrupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testUkloniSvaPravaPristupaGrupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testOduzmiPravaPristupaGrupeNaFolder() {
		fail("Not yet implemented");
	}

	@Test
	public void testDodajGrupu() {
		fail("Not yet implemented");
	}

	@Test
	public void testDodajKorisnikaUGrupu() {
		fail("Not yet implemented");
	}

	@Test
	public void testOdbrisiKorisnikaIzGrupe() {
		fail("Not yet implemented");
	}

	@Test
	public void testDajGrupeVlasnika() {
		fail("Not yet implemented");
	}

	@Test
	public void testDajGrupeZaKorisnika() {
		fail("Not yet implemented");
	}

	@Test
	public void testDajGrupuPoNazivu() {
		fail("Not yet implemented");
	}

	@Test
	public void testDodajFolderXGrupaDbModele() {
		fail("Not yet implemented");
	}

	@Test
	public void testDodajGrupaXKorisnikDbModele() {
		fail("Not yet implemented");
	}

	@Test
	public void testAzurirajGrupu() {
		fail("Not yet implemented");
	}

	@Test
	public void testDaLiPostojiKorisnikUGrupi() {
		fail("Not yet implemented");
	}

}
