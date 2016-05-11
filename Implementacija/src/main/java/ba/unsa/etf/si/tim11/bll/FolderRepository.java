package ba.unsa.etf.si.tim11.bll;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;

import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.DokumentDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderDbModel;
import ba.unsa.etf.si.tim11.dbmodels.FolderXGrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaDbModel;
import ba.unsa.etf.si.tim11.dbmodels.GrupaXKorisnikDbModel;
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
		List<FolderDbModel> listaFoldera = new ArrayList<FolderDbModel>();
		
		Integer idKorisnika = kor.dajIdKorisnikaPoUsername(userNameKorisnika);
		
		KorisnikDbModel korisnik = kor.dajKorisnika(idKorisnika);
		
		if(korisnik.getKorisnikTip().getKorisnikTipNaziv().equals("Administrator"))
		{
			listaFoldera = DbDMSContext.getInstance().getFolderi().ucitajSve();
			return listaFoldera;
		}	
		
		List<GrupaDbModel> listaGrupa = gru.dajGrupeZaKorisnika(idKorisnika);
		
		List<FolderXGrupaDbModel> folGru = DbDMSContext.getInstance().getFolderiGrupe().ucitajSve();
		
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
	/*
	 * Metoda daje foldere trenutno logovanog korisnika
	 */
	public List<FolderDbModel> dajFoldere() throws Exception {
		KorisnikRepository korisnikRepo = new KorisnikRepository();
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("aktivan", true));
		kriterijum.add(Restrictions.eq("korisnikId", korisnikRepo.dajIdKorisnikaPoUsername(Sesija.getUsername())));
		
		List<GrupaXKorisnikDbModel> listaGrupaXKorisnik = DbDMSContext.getInstance()
				.getGrupeKorisnici()
				.ucitajSveSaKriterujumom(kriterijum);
		System.out.println("prosao1: "+listaGrupaXKorisnik.size());
		
		List<Integer> listaGrupaID = new ArrayList<Integer>();
		for (GrupaXKorisnikDbModel grupaXKorisnikDbModel : listaGrupaXKorisnik) {
			if(grupaXKorisnikDbModel.getGrupa() != null)
				listaGrupaID.add((Integer)(int)grupaXKorisnikDbModel.getGrupa().getGrupaId());
		}
		System.out.println("prosao2: "+listaGrupaID.size());
		
		ArrayList<Criterion> kriterijumFolderi = new ArrayList<Criterion>();
		kriterijumFolderi.add(Restrictions.eq("aktivan", true));
		kriterijumFolderi.add(Restrictions.eq("pravoSkidanja", true));
		
		if(listaGrupaID.size() > 0)
			kriterijumFolderi.add(Restrictions.in("grupaId", listaGrupaID));
		
		List<FolderXGrupaDbModel> listaFolderXGrupa = DbDMSContext.getInstance()
				.getFolderiGrupe()
				.ucitajSveSaKriterujumom(kriterijumFolderi);
		System.out.println("prosao3: "+listaFolderXGrupa.size());
		
		List<FolderDbModel> listaFoldera = new ArrayList<FolderDbModel>();
		for (FolderXGrupaDbModel folderXGrupaDbModel : listaFolderXGrupa) {
			if(folderXGrupaDbModel.getFolder() != null){
				if(!this.listaSadrziFolder(listaFoldera, folderXGrupaDbModel.getFolderId())){
					listaFoldera.add(folderXGrupaDbModel.getFolder());
				}
			}else{
				System.out.println("Null folderid: "+folderXGrupaDbModel.getFolderId());
			}
		}
		System.out.println("prosao4: "+listaFoldera.size());
		return listaFoldera;
	}
	private Boolean listaSadrziFolder(List<FolderDbModel> listaFoldera, long folderId){
		for (FolderDbModel folderDbModel : listaFoldera) {
			if(folderDbModel.getFolderId() == folderId)
				return true;
		}
		return false;
	}
	public List<FolderDbModel> dajPodfoldere(Integer folderId){
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("folderId", folderId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<FolderDbModel> listaFoldera = DbDMSContext.getInstance()
				.getFolderi()
				.ucitajSveSaKriterujumom(kriterijum);
		return listaFoldera;
	}
}