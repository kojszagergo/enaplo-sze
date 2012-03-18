package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Diak implements Serializable {
	
	

	//K�s�bb �tker�l a Person �soszt�lyba
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String vezetekNev;
	@Persistent
	private String keresztNev;
	@Persistent
	private Date szuletesiDatum;
	@Persistent
	private String nem;
	@Persistent
	private String iranyitoSzam;
	@Persistent
	private String varos;
	@Persistent
	private String utca;
	@Persistent
	private String anyjaNeve;
	@Persistent
	private int version;

	public Diak() {	}
	//kesobb javitani, optimalizalni
	public Diak(String vezetekNev, String keresztNev,
			Date szuletesiDatum, String nem, String iranyitoSzam, String varos,
			String utca, String anyjaNeve, int version) {
		this.vezetekNev = vezetekNev;
		this.keresztNev = keresztNev;
		this.szuletesiDatum = szuletesiDatum;
		this.nem = nem;
		this.iranyitoSzam = iranyitoSzam;
		this.varos = varos;
		this.utca = utca;
		this.anyjaNeve = anyjaNeve;
		this.version = version;
	}

	public String getVezetekNev() {
		return vezetekNev;
	}

	public void setVezetekNev(String vezetekNev) {
		this.vezetekNev = vezetekNev;
	}

	public String getKeresztNev() {
		return keresztNev;
	}

	public void setKeresztNev(String keresztNev) {
		this.keresztNev = keresztNev;
	}

	public Date getSzuletesiDatum() {
		return szuletesiDatum;
	}

	public void setSzuletesiDatum(Date szuletesiDatum) {
		this.szuletesiDatum = szuletesiDatum;
	}

	public String getNem() {
		return nem;
	}

	public void setNem(String nem) {
		this.nem = nem;
	}

	public String getIranyitoSzam() {
		return iranyitoSzam;
	}

	public void setIranyitoSzam(String iranyitoSzam) {
		this.iranyitoSzam = iranyitoSzam;
	}

	public String getVaros() {
		return varos;
	}

	public void setVaros(String varos) {
		this.varos = varos;
	}

	public String getUtca() {
		return utca;
	}

	public void setUtca(String utca) {
		this.utca = utca;
	}

	public String getAnyjaNeve() {
		return anyjaNeve;
	}

	public void setAnyjaNeve(String anyjaNeve) {
		this.anyjaNeve = anyjaNeve;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

}
