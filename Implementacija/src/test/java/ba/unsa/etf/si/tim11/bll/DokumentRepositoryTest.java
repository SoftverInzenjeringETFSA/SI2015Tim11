package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.DokumentRepository;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.DokumentVerzijaDbModel;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;

import org.junit.Assert;
//import org.junit.Assert;
import org.junit.Test;

public class DokumentRepositoryTest {

	@Test
	public void testDodajDokument() {
		
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
		byte [] nizbajta=  "sadrzaj".getBytes();
		dokVer.setSadrzaj(nizbajta);
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
