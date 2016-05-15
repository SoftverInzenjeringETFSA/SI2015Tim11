package ba.unsa.etf.si.tim11.bll;
import ba.unsa.etf.si.tim11.bll.FolderRepository;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import junit.framework.Assert;
import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;

import static org.junit.Assert.*;

import org.junit.Test;

public class FolderRepositoryTest {

	@Test
	public void testDodajRootFolder() {
		
		
		//fail("Not yet implemented");
	}

	
	@Test
	public void testDodajFolder() {
		
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
		
		//fail("Not yet implemented");
	}

	@Test
	public void testObrisiFolder() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDodajPravaPristupaGrupiFolderu() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIzmijeniPravaPristupaGrupiFolderu() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDajSveFoldereNaKojeImaPravo() {
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
