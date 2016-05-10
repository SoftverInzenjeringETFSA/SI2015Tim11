package ba.unsa.etf.si.tim11.bll;

public class Sesija {
	
	private static String username = "";
	private static Boolean certifikatAktivan = false;
	
	/*
	 * Metoda vraca username logovanog korisnika
	 */
	public static String getUsername() throws Exception {
		if(!certifikatAktivan)
			throw new Exception("Korisnik nije logovan.");
		return username;
	}
	public static void setUsername(String username) {
		Sesija.username = username;
	}
	public static void setCertifikatAktivan(Boolean certifikatAktivan) {
		Sesija.certifikatAktivan = certifikatAktivan;
	}
}