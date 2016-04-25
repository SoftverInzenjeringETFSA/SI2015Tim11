package ba.unsa.etf.si.tim11.dbmodels;

import java.util.Date;

public class GrupaDbModel {

	private Integer grupaId;
	private String naziv;
	private Integer odgovorniKorisnikId;
	private Date datumKreiranja;
	private Boolean aktivan;

	public Integer getGrupaId() {
		return grupaId;
	}

	public void setGrupaId(Integer grupaId) {
		this.grupaId = grupaId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Integer getOdgovorniKorisnikId() {
		return odgovorniKorisnikId;
	}

	public void setOdgovorniKorisnikId(Integer odgovorniKorisnikId) {
		this.odgovorniKorisnikId = odgovorniKorisnikId;
	}

	public Date getDatumKreiranja() {
		return datumKreiranja;
	}

	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
}