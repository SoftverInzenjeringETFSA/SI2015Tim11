package ba.unsa.etf.si.tim11;

import ba.unsa.etf.si.tim11.bll.KorisnikRepository;
import ba.unsa.etf.si.tim11.dal.DbDMSContext;
import ba.unsa.etf.si.tim11.dbmodels.KorisnikDbModel;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void dodavanjeKorisnikaBll()
    {
    	KorisnikRepository korisnikRepo = new KorisnikRepository();
    	
    	//uzmes koliko ima trenutno korinika
    	int brojKorisnika = korisnikRepo.dajKorisnike().size();
    	
    	KorisnikDbModel korisnik = new KorisnikDbModel();
    	korisnik.setAktivan(true);//ovo je u bazi not null pa mora biti
    	//popunis ovdje ostale propertije
    	
    	korisnikRepo.dodajKorisnika(korisnik);
    	
    	//provjeravas da li sada ima u listi jedan vise
    	assertEquals(brojKorisnika + 1, korisnikRepo.dajKorisnike().size());
    }
    
    public void dajKorisnikaBllTest()
    {
    	KorisnikDbModel korisnik = new KorisnikDbModel();
    	korisnik.setAktivan(true);
    	korisnik.setIme("Dzemila");
    	
    	long id = DbDMSContext.getInstance().getKorisnici().sacuvaj(korisnik);
    	
    	KorisnikRepository korisnikRepo = new KorisnikRepository();
    	KorisnikDbModel trazeniKorisnik = korisnikRepo.dajKorisnika((Integer)(int)id);
    	
    	assertEquals(korisnik.getIme(), trazeniKorisnik.getIme());
    }
     
    public void dodavanjeKorisnikaIzuzetajBll()
    {
    	KorisnikRepository korisnikRepo = new KorisnikRepository();
    	
    	KorisnikDbModel korisnik = new KorisnikDbModel();
    	//ovdje npr ne dodas ovo i trebao bi se baciti izuzetak
    	//korisnik.setAktivan(true);

    	korisnikRepo.dodajKorisnika(korisnik); //ovo bi sad trebalo baciti neki izuzetak
    }
}
