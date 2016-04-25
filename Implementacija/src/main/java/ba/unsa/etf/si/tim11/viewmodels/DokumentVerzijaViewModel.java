package ba.unsa.etf.si.tim11.viewmodels;

import java.util.Collection;
import java.util.Date;

public class DokumentVerzijaViewModel {

	public KorisnikViewModel postavioKorisnik;
	public DokumentVerzijaStatusViewModel status;
	public Collection<KomentarViewModel> komentari;
	public Date datumKreiranja;
	public String verzija;
	public Integer dokumentVerzijaId;

}