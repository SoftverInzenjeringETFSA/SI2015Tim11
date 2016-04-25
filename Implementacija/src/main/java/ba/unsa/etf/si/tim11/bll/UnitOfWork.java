package ba.unsa.etf.si.tim11.bll;

public class UnitOfWork {

	public KorisnikRepository korisnikRepository;
	public FolderRepository folderRepository;
	public DokumentRepository dokumentRepository;
	public ZahtjevRepository zahtjevRepository;
	public KomentarRepository komentarRepository;
	public GrupaRepository grupaRepository;
	private Sesija sesija;

	/**
	 * 
	 * @param sesija
	 */
	public UnitOfWork(Sesija sesija) {
		// TODO - implement UnitOfWork.UnitOfWork
		throw new UnsupportedOperationException();
	}

}