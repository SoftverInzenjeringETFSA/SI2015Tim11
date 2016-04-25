package ba.unsa.etf.si.tim11.viewmodels;

import java.util.Collection;
import java.util.Date;

public class KorisnikViewModel {

	public KorisnikTipViewModel tipKorisnika;
	public KorisnikPozicijaViewModel pozicijaKorisnika;
	Collection<KorisnikGrupaPristup> korisnikGrupaPristup;
	public Integer korisnikId;
	public String Ime;
	public String Preime;
	public String Adresa;
	public Date datumRodjena;
	public String username;

}