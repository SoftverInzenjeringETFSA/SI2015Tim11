package ba.unsa.etf.si.tim11.dbmodels.izvjestajmodels;/**
 * Created by ensar on 5/15/16.
 */

import java.util.Date;
import java.util.logging.Logger;

public class Dokument {
    private static final Logger logger =
            Logger.getLogger(Dokument.class.getName());

    private String datum;
    private String naziv;
    private Integer broj;
    private String status;

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getBroj() {
        return broj;
    }

    public void setBroj(Integer broj) {
        this.broj = broj;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
