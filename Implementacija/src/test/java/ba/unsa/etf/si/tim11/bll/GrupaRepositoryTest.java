package ba.unsa.etf.si.tim11.bll;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikPozicijaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikTipDbModel;

public class GrupaRepositoryTest {

	private GrupaRepository grupaRep = new GrupaRepository();
	
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
	public void testDajGrupu() {
		
	}

	@Test
	public void testDajGrupe() {
		
	}

	@Test
	public void testIzmijeniGrupu() {
		
	}

	@Test
	public void testObrisiGrupu() 
	{
		
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		
		korisnik.setKorisnikPozicijaId((int)pozicijaKorisnika.getKorisnikPozicijaId());
		korisnik.setKorisnikTipId((int)tipKorisnika.getKorisnikTipId());
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)korisnik.getKorisnikID());
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		grupaRep.obrisiGrupu(grupa);
		
		GrupaDbModel obrisanaGrupa = DbDMSContext.getInstance().getGrupe().ucitaj(idKreiraneGrupe);
		
		assertTrue(!obrisanaGrupa.getAktivan());
		
		DbDMSContext.getInstance().getGrupe().obrisi(obrisanaGrupa);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		
	}

	@Test
	public void testUkloniSveKorisnikeIzGrupe() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaXKorisnikDbModel veza = kreirajMiGrupuKorisnika((int)idKreiranogKorisnika, (int)idKreiraneGrupe);
		
		long idKreiraneVeze = DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(veza);
		
		grupaRep.ukloniSveKorisnikeIzGrupe((int)idKreiraneGrupe);
		
		GrupaXKorisnikDbModel obrisanaVeza = DbDMSContext.getInstance().getGrupeKorisnici().ucitaj(idKreiraneVeze);
		
		assertTrue(!obrisanaVeza.getAktivan());
		
		DbDMSContext.getInstance().getGrupeKorisnici().obrisi(veza);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
		
	}

	@Test
	public void testUkloniSvaPravaPristupaGrupe() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		FolderDbModel prviFolder = kreirajMiFolder();
		FolderDbModel drugiFolder = kreirajMiFolder();
		
		long idPrvogFoldera = DbDMSContext.getInstance().getFolderi().sacuvaj(prviFolder);
		long idDrugogFoldera = DbDMSContext.getInstance().getFolderi().sacuvaj(drugiFolder);
		
		FolderXGrupaDbModel vezaGrupaPrviFolder = kreirajMiGrupuFolder((int)idKreiraneGrupe, (int)idPrvogFoldera);
		FolderXGrupaDbModel vezaGrupaDrugiFolder = kreirajMiGrupuFolder((int)idKreiraneGrupe, (int)idDrugogFoldera);
		
		long idPrveVeze = DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(vezaGrupaPrviFolder);
		long idDrugeVeze = DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(vezaGrupaDrugiFolder);
		
		grupaRep.ukloniSvaPravaPristupaGrupe((int)idKreiraneGrupe);
		
		FolderXGrupaDbModel prvaVeza = DbDMSContext.getInstance().getFolderiGrupe().ucitaj(idPrveVeze);
		FolderXGrupaDbModel drugaVeza = DbDMSContext.getInstance().getFolderiGrupe().ucitaj(idDrugeVeze);
		
		assertTrue(!prvaVeza.getAktivan());
		assertTrue(!drugaVeza.getAktivan());
		
		DbDMSContext.getInstance().getFolderiGrupe().obrisi(prvaVeza);
		DbDMSContext.getInstance().getFolderiGrupe().obrisi(drugaVeza);
		DbDMSContext.getInstance().getFolderi().obrisi(prviFolder);
		DbDMSContext.getInstance().getFolderi().obrisi(drugiFolder);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
		
	}

	@Test
	public void testOduzmiPravaPristupaGrupeNaFolder() 
	{
		
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		FolderDbModel prviFolder = kreirajMiFolder();
		FolderDbModel drugiFolder = kreirajMiFolder();
		
		long idPrvogFoldera = DbDMSContext.getInstance().getFolderi().sacuvaj(prviFolder);
		long idDrugogFoldera = DbDMSContext.getInstance().getFolderi().sacuvaj(drugiFolder);
		
		FolderXGrupaDbModel vezaGrupaPrviFolder = kreirajMiGrupuFolder((int)idKreiraneGrupe, (int)idPrvogFoldera);
		FolderXGrupaDbModel vezaGrupaDrugiFolder = kreirajMiGrupuFolder((int)idKreiraneGrupe, (int)idDrugogFoldera);
		
		long idPrveVeze = DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(vezaGrupaPrviFolder);
		long idDrugeVeze = DbDMSContext.getInstance().getFolderiGrupe().sacuvaj(vezaGrupaDrugiFolder);
		
		grupaRep.oduzmiPravaPristupaGrupeNaFolder((int)idPrvogFoldera, (int)idKreiraneGrupe);
		grupaRep.oduzmiPravaPristupaGrupeNaFolder((int)idDrugogFoldera, (int)idKreiraneGrupe);
		
		FolderXGrupaDbModel prvaVeza = DbDMSContext.getInstance().getFolderiGrupe().ucitaj(idPrveVeze);
		FolderXGrupaDbModel drugaVeza = DbDMSContext.getInstance().getFolderiGrupe().ucitaj(idDrugeVeze);
		
		assertTrue(!prvaVeza.getAktivan());
		assertTrue(!drugaVeza.getAktivan());
		
		DbDMSContext.getInstance().getFolderiGrupe().obrisi(prvaVeza);
		DbDMSContext.getInstance().getFolderiGrupe().obrisi(drugaVeza);
		DbDMSContext.getInstance().getFolderi().obrisi(prviFolder);
		DbDMSContext.getInstance().getFolderi().obrisi(drugiFolder);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
	}

	@Test
	public void testDodajGrupu() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		
		grupaRep.dodajGrupu(grupa);
		
		List<GrupaDbModel> listaGrupa = DbDMSContext.getInstance().getGrupe().ucitajSve();
		boolean postoji = false;
		
		for(GrupaDbModel gr : listaGrupa)
			if(gr.getGrupaNaziv().equals(grupa.getGrupaNaziv()))
				postoji = true;
		
		assertTrue(postoji);
		
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
		
	}

	@Test
	public void testDodajKorisnikaUGrupu() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaXKorisnikDbModel veza = kreirajMiGrupuKorisnika((int)idKreiranogKorisnika, (int)idKreiraneGrupe);
		
		grupaRep.dodajKorisnikaUGrupu(veza);
		
		List<GrupaXKorisnikDbModel> listaGK = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSve();
		boolean postoji = false;
		
		for(GrupaXKorisnikDbModel gk : listaGK)
			if(gk.getGrupaId() == idKreiraneGrupe && gk.getKorisnikId() == idKreiranogKorisnika && gk.getAktivan())
				postoji = true;
		
		assertTrue(postoji);
		
		DbDMSContext.getInstance().getGrupeKorisnici().obrisi(veza);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
	}

	@Test
	public void testOdbrisiKorisnikaIzGrupe() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaXKorisnikDbModel veza = kreirajMiGrupuKorisnika((int)idKreiranogKorisnika, (int)idKreiraneGrupe);
		
		long idKreiraneVeze = DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(veza);
		
		grupaRep.odbrisiKorisnikaIzGrupe((int)idKreiranogKorisnika, (int)idKreiraneGrupe);
		
		GrupaXKorisnikDbModel obrisanaVeza = DbDMSContext.getInstance().getGrupeKorisnici().ucitaj(idKreiraneVeze);
		
		assertTrue(!obrisanaVeza.getAktivan());
		
		DbDMSContext.getInstance().getGrupeKorisnici().obrisi(veza);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
	}

	@Test
	public void testDajGrupeVlasnika() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranePozicije);
		korisnik.setKorisnikTipId((int)idKreiranogTipa);
	
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		List<GrupaDbModel> grupeVlasnika = grupaRep.dajGrupeVlasnika((int)idKreiranogKorisnika);
		
		assertTrue(grupeVlasnika.size() == 1);
		
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
		
	}
	
	@Test
	public void testDajGrupeVlasnikaAdministrator() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		tipKorisnika.setKorisnikTipNaziv("Administrator");
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranePozicije);
		korisnik.setKorisnikTipId((int)idKreiranogTipa);
	
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaDbModel grupa2 = kreirajMiGrupu(null);
		long idKreiraneGrupe2 = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa2);
		
		List<GrupaDbModel> grupeVlasnika = grupaRep.dajGrupeVlasnika((int)idKreiranogKorisnika);
		
		assertTrue(grupeVlasnika.size() > 1);
		
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
	}

	@Test
	public void testDajGrupeZaKorisnika() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)korisnik.getKorisnikID());
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaXKorisnikDbModel veza = kreirajMiGrupuKorisnika((int)idKreiranogKorisnika, (int)idKreiraneGrupe);
		
		long idKreiraneVeze = DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(veza);
		
		List<GrupaDbModel> grupeVlasnika = grupaRep.dajGrupeZaKorisnika((int)idKreiranogKorisnika);
		
		assertTrue(grupeVlasnika.size() == 1);
		
		DbDMSContext.getInstance().getGrupeKorisnici().obrisi(veza);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		
	}

	@Test
	public void testDajGrupuPoNazivu() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)korisnik.getKorisnikID());
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaDbModel vracenaGrupa = grupaRep.dajGrupuPoNazivu(grupa.getGrupaNaziv());
		
		assertTrue(vracenaGrupa.getGrupaNaziv().equals(grupa.getGrupaNaziv()));
		
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
	}

	@Test
	public void testDodajFolderXGrupaDbModele() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		FolderDbModel prviFolder = kreirajMiFolder();
		
		long idPrvogFoldera = DbDMSContext.getInstance().getFolderi().sacuvaj(prviFolder);
		
		FolderXGrupaDbModel vezaGrupaPrviFolder = kreirajMiGrupuFolder((int)idKreiraneGrupe, (int)idPrvogFoldera);
		
		List<FolderXGrupaDbModel> listaDefinisanihPravaPristupa = new ArrayList<FolderXGrupaDbModel>();
		listaDefinisanihPravaPristupa.add(vezaGrupaPrviFolder);
		
		grupaRep.dodajFolderXGrupaDbModele(listaDefinisanihPravaPristupa , (int)idKreiraneGrupe);
		
		boolean postoji = false;
		
		List<FolderXGrupaDbModel> lista = DbDMSContext.getInstance().getFolderiGrupe().ucitajSve();
		
		for(FolderXGrupaDbModel fg : lista)
			if(fg.getFolderId() == idPrvogFoldera && fg.getGrupaId() == idKreiraneGrupe && fg.getAktivan())
				postoji = true;
		
		assertTrue(postoji);
		
		DbDMSContext.getInstance().getFolderiGrupe().obrisi(vezaGrupaPrviFolder);
		DbDMSContext.getInstance().getFolderi().obrisi(prviFolder);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		
	}

	@Test
	public void testDodajGrupaXKorisnikDbModele() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
				
		List<KorisnikDbModel> listaDodanihKorisnika = new ArrayList<KorisnikDbModel>();
		listaDodanihKorisnika.add(korisnik);
		
		grupaRep.dodajGrupaXKorisnikDbModele(listaDodanihKorisnika, (int)idKreiraneGrupe);
		
		List<GrupaXKorisnikDbModel> listaGK = DbDMSContext.getInstance().getGrupeKorisnici().ucitajSve();
		boolean postoji = false;
		
		for(GrupaXKorisnikDbModel gk : listaGK)
			if(gk.getGrupaId() == idKreiraneGrupe && gk.getKorisnikId() == idKreiranogKorisnika && gk.getAktivan())
				postoji = true;
		
		assertTrue(postoji);
		
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
	}

	@Test
	public void testAzurirajGrupu() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		grupa.setGrupaNaziv("novi naziv grupe");
		
		grupaRep.azurirajGrupu(grupa);
		
		GrupaDbModel vracenaGrupa = DbDMSContext.getInstance().getGrupe().ucitaj(idKreiraneGrupe);
		
		assertTrue(grupa.getGrupaNaziv().equals(vracenaGrupa.getGrupaNaziv()));
		
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
	}

	@Test
	public void testDaLiPostojiKorisnikUGrupi() 
	{
		KorisnikDbModel korisnik = kreirajMiKorisnika();
		KorisnikTipDbModel tipKorisnika = kreirajMiTipKorisnika();
		KorisnikPozicijaDbModel pozicijaKorisnika = kreirajMiPozicijuKorisnika();
		long idKreiranogTipa = DbDMSContext.getInstance().getKorisnikTipovi().sacuvaj(tipKorisnika);
		long idKreiranePozicije = DbDMSContext.getInstance().getKorisnikPozicije().sacuvaj(pozicijaKorisnika);
		
		korisnik.setKorisnikPozicijaId((int)idKreiranogTipa);
		korisnik.setKorisnikTipId((int)idKreiranePozicije);
		
		long idKreiranogKorisnika = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
		GrupaDbModel grupa = kreirajMiGrupu((int)idKreiranogKorisnika);
		long idKreiraneGrupe = DbDMSContext.getInstance().getGrupe().sacuvaj(grupa);
		
		GrupaXKorisnikDbModel veza = kreirajMiGrupuKorisnika((int)idKreiranogKorisnika, (int)idKreiraneGrupe);	
		long idKreiraneVeze = DbDMSContext.getInstance().getGrupeKorisnici().sacuvaj(veza);
		
		assertTrue(grupaRep.daLiPostojiKorisnikUGrupi((int)idKreiranogKorisnika, (int)idKreiraneGrupe));
		
		DbDMSContext.getInstance().getGrupeKorisnici().obrisi(veza);
		DbDMSContext.getInstance().getGrupe().obrisi(grupa);
		DbDMSContext.getInstance().getKorisnici().obrisi(korisnik);
		DbDMSContext.getInstance().getKorisnikPozicije().obrisi(pozicijaKorisnika);
		DbDMSContext.getInstance().getKorisnikTipovi().obrisi(tipKorisnika);
		
	}

}
