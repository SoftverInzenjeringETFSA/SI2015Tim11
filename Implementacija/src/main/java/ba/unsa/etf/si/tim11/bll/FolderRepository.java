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
		try {
			KorisnikRepository kor = new KorisnikRepository();
			folder.setRoditeljFolderId(roditeljFolderId);
			folder.setKreiraoKorisnikId(kor.dajIdKorisnikaPoUsername(Sesija.getUsername()));
			
			DbDMSContext.getInstance().getFolderi().sacuvaj(folder);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	/**
	 * 
	 * @param folderId
	 */
	public Boolean obrisiFolder(Integer folderId) {
		FolderDbModel folder = DbDMSContext.getInstance().getFolderi().ucitaj((long)(int)folderId);
		if(folder != null){
			folder.setAktivan(false);
			try {
				DbDMSContext.getInstance().getFolderi().sacuvajIliAzuriraj(folder);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return false;
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
			ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
			kriterijum.add(Restrictions.eq("aktivan", true));
			
			listaFoldera = DbDMSContext.getInstance().getFolderi().ucitajSveSaKriterujumom(kriterijum);
			return listaFoldera;
		}	
		
		List<GrupaDbModel> listaGrupa = gru.dajGrupeZaKorisnika(idKorisnika);
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<FolderXGrupaDbModel> folGru = DbDMSContext.getInstance().getFolderiGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		for(GrupaDbModel grupa : listaGrupa)
			for(FolderXGrupaDbModel fg : folGru)
				if(grupa.getGrupaId() == fg.getGrupa().getGrupaId() && fg.getFolder().getAktivan())
			     	listaFoldera.add(fg.getFolder());	
		
		return listaFoldera;
	}
	
	public List<FolderXGrupaDbModel> dajSveGrupeFoldereKorisnika(Integer idKorisnika)
	{
		KorisnikRepository kor = new KorisnikRepository();
		GrupaRepository gru = new GrupaRepository();
		
		List<GrupaDbModel> listaGrupa = gru.dajGrupeZaKorisnika(idKorisnika);
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<FolderXGrupaDbModel> folGru = DbDMSContext.getInstance().getFolderiGrupe().ucitajSveSaKriterujumom(kriterijum);
		
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
		
		//jos dodavanje vlastitih foldera
		ArrayList<Criterion> kriterijumVlastititFolderi = new ArrayList<Criterion>();
		kriterijumVlastititFolderi.add(Restrictions.eq("aktivan", true));
		kriterijumVlastititFolderi.add(Restrictions.isNull("roditeljFolderId"));
		kriterijumVlastititFolderi.add(Restrictions.eq("kreiraoKorisnikId", korisnikRepo.dajIdKorisnikaPoUsername(Sesija.getUsername())));
		
		List<FolderDbModel> listaVlastitiFolderi = DbDMSContext.getInstance()
				.getFolderi()
				.ucitajSveSaKriterujumom(kriterijumVlastititFolderi);
		System.out.println("UKUPNO MOJI FOLDERI: "+listaVlastitiFolderi.size());
		for (FolderDbModel folderDbModel : listaVlastitiFolderi) {
			if(!this.listaSadrziFolder(listaFoldera, folderDbModel.getFolderId())){
				listaFoldera.add(folderDbModel);
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
		kriterijum.add(Restrictions.eq("roditeljFolderId", folderId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		
		List<FolderDbModel> listaFoldera = DbDMSContext.getInstance()
				.getFolderi()
				.ucitajSveSaKriterujumom(kriterijum);
		return listaFoldera;
	}

	public List<FolderDbModel> dajFoldereGrupe(int grupaId) {
		
		ArrayList<Criterion> kriterijum = new ArrayList<Criterion>();
		kriterijum.add(Restrictions.eq("grupaId", grupaId));
		kriterijum.add(Restrictions.eq("aktivan", true));
		List<FolderXGrupaDbModel> grupeFolderi = DbDMSContext.getInstance().getFolderiGrupe().ucitajSveSaKriterujumom(kriterijum);
		
		List<FolderDbModel> folderi = new ArrayList<FolderDbModel>();
		
		for(FolderXGrupaDbModel gf : grupeFolderi)
			folderi.add(gf.getFolder());
		
		return folderi;
	}
}