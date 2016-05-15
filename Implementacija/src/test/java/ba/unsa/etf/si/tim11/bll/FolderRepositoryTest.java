package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.FolderRepository;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;
import junit.framework.Assert;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class FolderRepositoryTest {

	@Test
	public void testDodajRootFolder() {
		
		
		//fail("Not yet implemented");
	}

	
	@Test
	public void testDodajFolder() {
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
		Sesija.setUsername("user");
		Sesija.setCertifikatAktivan(true);
		FolderRepository foldRep =new FolderRepository();
		FolderDbModel foldModel=new FolderDbModel();
		FolderDbModel roditeljModel=new FolderDbModel();
		foldModel.setAktivan(true);
		foldModel.setFolderNaziv("naziv foldera");
		foldModel.setRoditeljFolder(roditeljModel);
		roditeljModel.setAktivan(true);
		roditeljModel.setFolderNaziv("naziv");
		long idRoditelj =DbDMSContext.getInstance().getFolderi().sacuvaj(roditeljModel);
		foldModel.setRoditeljFolderId((int) idRoditelj);
		long idFold = DbDMSContext.getInstance().getFolderi().sacuvaj(foldModel);
		
		
		assertTrue(foldRep.dodajFolder((int) idRoditelj, foldModel));
		
		DbDMSContext.getInstance().getFolderi().obrisi(foldModel);
		DbDMSContext.getInstance().getFolderi().obrisi(roditeljModel);
		DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
	    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
	    
		
		//fail("Not yet implemented");
	}

	@Test
	public void testObrisiFolder() {
		
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
		Sesija.setUsername("user");
		Sesija.setCertifikatAktivan(true);
		FolderRepository foldRep =new FolderRepository();
		FolderDbModel foldModel=new FolderDbModel();
		FolderDbModel roditeljModel=new FolderDbModel();
		foldModel.setAktivan(true);
		foldModel.setFolderNaziv("naziv foldera");
		foldModel.setRoditeljFolder(roditeljModel);
		roditeljModel.setAktivan(true);
		roditeljModel.setFolderNaziv("naziv");
		long idRoditelj =DbDMSContext.getInstance().getFolderi().sacuvaj(roditeljModel);
		foldModel.setRoditeljFolderId((int) idRoditelj);
		long idFold = DbDMSContext.getInstance().getFolderi().sacuvaj(foldModel);
		
		
		assertTrue(foldRep.obrisiFolder((int) idFold));
		
		DbDMSContext.getInstance().getFolderi().obrisi(foldModel);
		DbDMSContext.getInstance().getFolderi().obrisi(roditeljModel);
		DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
	    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
	    
		//fail("Not yet implemented");
	}

	/*@Test
	public void testDodajPravaPristupaGrupiFolderu() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIzmijeniPravaPristupaGrupiFolderu() {
		//fail("Not yet implemented");
	}*/

	@Test
	public void testDajSveFoldereNaKojeImaPravo() {
		
		KorisnikDbModel korModel = new KorisnikDbModel();
		//KorisnikDbModel kor_noviModel= new KorisnikDbModel();
		KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		FolderXGrupaDbModel FGkor= new FolderXGrupaDbModel();
		GrupaXKorisnikDbModel GKkor=new GrupaXKorisnikDbModel() ;
		GrupaDbModel grupa=new GrupaDbModel();
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
		Sesija.setUsername("user");
		Sesija.setCertifikatAktivan(true);
		FolderRepository foldRep =new FolderRepository();
		FolderDbModel foldModel=new FolderDbModel();
		FolderDbModel roditeljModel=new FolderDbModel();
		foldModel.setAktivan(true);
		foldModel.setFolderNaziv("naziv foldera");
		foldModel.setRoditeljFolder(roditeljModel);
		int brojFoldPrije =foldRep.dajSveFoldereNaKojeImaPravo(korModel.getUsername()).size();
		foldModel.setKreiraoKorisnik(korModel);
		roditeljModel.setAktivan(true);
		roditeljModel.setFolderNaziv("naziv");
		grupa.setAktivan(true);
		grupa.setGrupaNaziv("neki naziv");
		grupa.setOdgovorniKorisnik(korModel);
		grupa.setOdgovorniKorisnikId((int) idKor);
		long idGrupe =DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		long idRoditelj =DbDMSContext.getInstance().getFolderi().sacuvaj(roditeljModel);
		foldModel.setRoditeljFolderId((int) idRoditelj);
		long idFold = DbDMSContext.getInstance().getFolderi().sacuvaj(foldModel);
		//foldRep.logovaniKorisnikImaPravoDodavanja((int) idFold);
		FGkor.setAktivan(true);
		FGkor.setFolder(foldModel);
		FGkor.setFolderId((int) idFold);
		FGkor.setPravoDodavanja(true);
		FGkor.setPravoSkidanja(true);
		FGkor.setGrupa(grupa);
		FGkor.setGrupaId((int) idGrupe);
		long idFGkor=DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(FGkor);
		GKkor.setAktivan(true);
		GKkor.setKorisnik(korModel);
		GKkor.setKorisnikId((int) idKor);
		GKkor.setGrupa(grupa);
		GKkor.setGrupaId((int) idGrupe);
		long idGKkor = DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(GKkor);
		
		assertEquals(brojFoldPrije+1,foldRep.dajSveFoldereNaKojeImaPravo(korModel.getUsername()));
		
		
		DbDMSContext.getInstance().getFolderi().obrisi(foldModel);
		DbDMSContext.getInstance().getFolderi().obrisi(roditeljModel);
		DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
	    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
	    
		//fail("Not yet implemented");
	}

	@Test
	public void testDajSveGrupeFoldereKorisnika() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajFoldere() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajPodfoldere() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajFoldereGrupe() {
		//fail("Not yet implemented");
	}

}
