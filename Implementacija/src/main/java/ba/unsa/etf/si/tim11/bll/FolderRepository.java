package ba.unsa.etf.si.tim11.bll;

import java.util.ArrayList;
import java.util.List;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;

public class FolderRepository {

	/**
	 * 
	 * @param grupaId
	 * @param folder
	 */
	public void dodajRootFolder(Integer grupaId, FolderDbModel folder) {
		// TODO - implement FolderRepository.dodajRootFolder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param roditeljFolderId
	 * @param folder
	 */
	public Boolean dodajFolder(Integer roditeljFolderId, FolderDbModel folder) {
		// TODO - implement FolderRepository.dodajFolder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param folderId
	 */
	public void obrisiFolder(Integer folderId) {
		// TODO - implement FolderRepository.obrisiFolder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param folderXGrupa
	 */
	public Boolean dodajPravaPristupaGrupiFolderu(FolderXGrupaDbModel folderXGrupa) {
		// TODO - implement FolderRepository.dodajPravaPristupaGrupiFolderu
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param folderXGrupa
	 */
	public Boolean izmijeniPravaPristupaGrupiFolderu(FolderXGrupaDbModel folderXGrupa) {
		// TODO - implement FolderRepository.izmijeniPravaPristupaGrupiFolderu
		throw new UnsupportedOperationException();
	}

	public List<FolderDbModel> dajSveFoldereNaKojeImaPravo(String userNameKorisnika) {
		
		KorisnikRepository kor = new KorisnikRepository();
		GrupaRepository gru = new GrupaRepository();
		
		Integer idKorisnika = kor.dajIdKorisnikaPoUsername(userNameKorisnika);
		
		List<GrupaDbModel> listaGrupa = gru.dajGrupeZaKorisnika(idKorisnika);
		
		//System.out.println(listaGrupa.get(0).getNaziv()+" iz glave..");
		
		List<FolderXGrupaDbModel> folGru = DbDMSContext.getInstance().getFolderiGrupe().ucitajSve();
		
		List<FolderDbModel> listaFoldera = new ArrayList<FolderDbModel>();;
		
		for(GrupaDbModel grupa : listaGrupa)
			for(FolderXGrupaDbModel fg : folGru)
				if(grupa.getGrupaId() == fg.getGrupa().getGrupaId())
			     	listaFoldera.add(fg.getFolder());
		
		return listaFoldera;
	}

}