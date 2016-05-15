package ba.unsa.etf.si.tim11.dbmodels.izvjestajmodels;/**
 * Created by ensar on 5/15/16.
 */

import jxl.write.DateTime;

import java.util.Date;
import java.util.logging.Logger;

public class Dokument {
    private static final Logger logger =
            Logger.getLogger(Dokument.class.getName());

    private Date datum;
    private String naziv;
    private Integer brojZahtjeva;
    private String zadnjiStatus;

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBrojZahtjeva() {
        return brojZahtjeva;
    }

    public void setBrojZahtjeva(Integer brojZahtjeva) {
        this.brojZahtjeva = brojZahtjeva;
    }

    public String getZadnjiStatus() {
        return zadnjiStatus;
    }

    public void setZadnjiStatus(String zadnjiStatus) {
        this.zadnjiStatus = zadnjiStatus;
    }
}
