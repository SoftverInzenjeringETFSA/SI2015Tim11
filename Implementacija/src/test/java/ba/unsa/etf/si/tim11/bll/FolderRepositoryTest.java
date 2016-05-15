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
import java.util.List;

import org.junit.Test;

public class FolderRepositoryTest {
	
	private FolderRepository folderRep = new FolderRepository();
	
	private FolderDbModel kreirajMiFolder()
	{
		FolderDbModel folder = new FolderDbModel();
		folder.setAktivan(true);
		folder.setFolderNaziv("naziv foldera");
		return folder;		
	}
	
	private GrupaDbModel kreirajMiGrupu(Integer idOdgovornog)
	{
		GrupaDbModel grupa = new GrupaDbModel();
		grupa.setAktivan(true);
		grupa.setDatumKreiranja(new Date());
		grupa.setGrupaNaziv("naziv grupe");
		grupa.setOdgovorniKorisnikId(idOdgovornog);
		return grupa;
	}
	
	private KorisnikTipDbModel kreirajMiTipKorisnika()
	{
		KorisnikTipDbModel korTip = new KorisnikTipDbModel();
		
		korTip.setAktivan(true);
		korTip.setKorisnikTipNaziv("naziv tipa");
		
		return korTip;
		
	}
	
	private KorisnikPozicijaDbModel kreirajMiPozicijuKorisnika()
	{
		KorisnikPozicijaDbModel pozicija = new KorisnikPozicijaDbModel();
		
		pozicija.setAktivan(true);
		
		return pozicija;
		
	}

	private KorisnikDbModel kreirajMiKorisnika()
	{	
		KorisnikDbModel korModel = new KorisnikDbModel();
		korModel.setAdresa("neka adresa");
		korModel.setAktivan(true);
		korModel.setDatumRodjenja(new Date());
		korModel.setIme("neko ime");
		korModel.setPassword("password");
		korModel.setPrezime("neko prezime");
		korModel.setUsername("userName");
		return korModel;
	}
	
	private GrupaXKorisnikDbModel kreirajMiGrupuKorisnika(Integer idKorisnika, Integer idGrupe)
	{
		GrupaXKorisnikDbModel gk = new GrupaXKorisnikDbModel();
		gk.setAktivan(true);
		gk.setDatumPristupa(new Date());
		gk.setGrupaId(idGrupe);
		gk.setKorisnikId(idKorisnika);
		gk.setDatumZadnjeIzmjene(new Date());
		
		return gk;
	}
	
	private FolderXGrupaDbModel kreirajMiGrupuFolder(Integer idGrupe, Integer idFoldera)
	{
		FolderXGrupaDbModel fg = new FolderXGrupaDbModel();
		fg.setAktivan(true);
		fg.setGrupaId(idGrupe);
		fg.setFolderId(idFoldera);
		fg.setPravoDodavanja(true);
		fg.setPravoSkidanja(true);
		return fg;
	}
	
	
	
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
		
		assertEquals(brojFoldPrije+2,foldRep.dajSveFoldereNaKojeImaPravo(korModel.getUsername()).size());
		
		
		DbDMSContext.getInstance().getFolderi().obrisi(foldModel);
		DbDMSContext.getInstance().getFolderi().obrisi(roditeljModel);
		DbDMSContext.getInstance().getKorisnici().obrisi(korModel);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicija);
	    DbDMSContext.getInstance().getKorisnikTipovi().obrisi(korTip);
	    
		//fail("Not yet implemented");
	}

	@Test
	public void testDajSveGrupeFoldereKorisnika() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		
		korisnik.setKorisnikPozicijaId((int)pozicijaKorisnika.getKorisnikPozicijaId());
		korisnik.setKorisnikTipId((int)tipKorisnika.getKorisnikTipId());
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)korisnik.getKorisnikID());
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaXKorisnikDbModel veza = kreirajMiGrupuKorisnika((int)idKreiranogKorisnika, (int)idKreiraneGrupe);	
		long idKreiraneVeze = DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(veza);
		
		FolderDbModel prviFolder = kreirajMiFolder();
		
		long idPrvogFoldera = DbDMSContext.getInstance().getFolderi().sacuvaj(prviFolder);
		
		FolderXGrupaDbModel vezaGrupaPrviFolder = kreirajMiGrupuFolder((int)idKreiraneGrupe, (int)idPrvogFoldera);
		
		long idVeze = DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(vezaGrupaPrviFolder);
		
		List<FolderXGrupaDbModel> lista = folderRep.dajSveGrupeFoldereKorisnika((int)idKreiranogKorisnika);
		
		assertTrue(lista.size() > 0);
		
		DbDMSContext.getInstance().getFolderiGrupe().obrisi(vezaGrupaPrviFolder);
		DbDMSContext.getInstance().getFolderi().obrisi(prviFolder);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
	}

	@Test
	public void testDajFoldere() 
	{
		
	}

	@Test
	public void testDajPodfoldere() 
	{
		
	}

	@Test
	public void testDajFoldereGrupe() 
	{
		
	}

}
