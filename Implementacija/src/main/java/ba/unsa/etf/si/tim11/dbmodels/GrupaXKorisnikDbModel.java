package ba.unsa.etf.si.tim11.dbmodels;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class GrupaXKorisnikDbModel extends BaseDbModel {

	private Integer grupaXKorisnikId;
	private Integer grupaId;
	private Integer korisnikId;
	private Date datumPristupa;
	private Date datumZadnjeIzmjene;
	private Boolean aktivan;

	public Integer getGrupaXKorisnikId() {
		return grupaXKorisnikId;
	}

	public void setGrupaXKorisnikId(Integer grupaXKorisnikId) {
		this.grupaXKorisnikId = grupaXKorisnikId;
	}

	public Integer getGrupaId() {
		return grupaId;
	}

	public void setGrupaId(Integer grupaId) {
		this.grupaId = grupaId;
	}

	public Integer getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Integer korisnikId) {
		this.korisnikId = korisnikId;
	}

	public Date getDatumPristupa() {
		return datumPristupa;
	}

	public void setDatumPristupa(Date datumPristupa) {
		this.datumPristupa = datumPristupa;
	}

	public Date getDatumZadnjeIzmjene() {
		return datumZadnjeIzmjene;
	}

	public void setDatumZadnjeIzmjene(Date datumZadnjeIzmjene) {
		this.datumZadnjeIzmjene = datumZadnjeIzmjene;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}