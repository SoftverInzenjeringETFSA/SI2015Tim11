package ba.unsa.etf.si.tim11.bll;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;

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
		
		List<FolderXGrupaDbModel> folGru = DbDMSContext.getInstance().getFolderiGrupe().ucitajSve();
		
		List<FolderDbModel> listaFoldera = new ArrayList<FolderDbModel>();;
		
		for(GrupaDbModel grupa : listaGrupa)
			for(FolderXGrupaDbModel fg : folGru)
				if(grupa.getGrupaId() == fg.getGrupa().getGrupaId())
			     	listaFoldera.add(fg.getFolder());	
		
		return listaFoldera;
	}
	
	public List<FolderXGrupaDbModel> dajSveGrupeFoldereKorisnika(Integer idKorisnika)
	{
		KorisnikRepository kor = new KorisnikRepository();
		GrupaRepository gru = new GrupaRepository();
		
		List<GrupaDbModel> listaGrupa = gru.dajGrupeZaKorisnika(idKorisnika);
		
		List<FolderXGrupaDbModel> folGru = DbDMSContext.getInstance().getFolderiGrupe().ucitajSve();
		
		List<FolderXGrupaDbModel> novaLista = new ArrayList<FolderXGrupaDbModel>();
		
		for(FolderXGrupaDbModel fg : folGru)
			for(GrupaDbModel g : listaGrupa)
				if(fg.getGrupa().getGrupaId() == g.getGrupaId())
					novaLista.add(fg);
		
		return novaLista;
		
	}

}