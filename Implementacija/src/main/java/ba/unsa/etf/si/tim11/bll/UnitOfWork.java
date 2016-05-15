package ba.unsa.etf.si.tim11.bll;

import java.io.Serializable;

public class UnitOfWork implements Serializable{
	private KorisnikRepository korisnikRepository;
	private FolderRepository folderRepository;
	private DokumentRepository dokumentRepository;
	private ZahtjevRepository zahtjevRepository;
	private KomentarRepository komentarRepository;
	private GrupaRepository grupaRepository;

	/**
	 * 
	 * @param sesija
	 */
	public UnitOfWork() {
		korisnikRepository = new KorisnikRepository();
		folderRepository = new FolderRepository();
		dokumentRepository = new DokumentRepository();
		zahtjevRepository = new ZahtjevRepository();
		komentarRepository = new KomentarRepository();
		grupaRepository = new GrupaRepository();
	}

	public KorisnikRepository getKorisnikRepository() {
		return korisnikRepository;
	}

	public FolderRepository getFolderRepository() {
		return folderRepository;
	}

	public DokumentRepository getDokumentRepository() {
		return dokumentRepository;
	}

	public ZahtjevRepository getZahtjevRepository() {
		return zahtjevRepository;
	}

	public KomentarRepository getKomentarRepository() {
		return komentarRepository;
	}

	public GrupaRepository getGrupaRepository() {
		return grupaRepository;
	}

}