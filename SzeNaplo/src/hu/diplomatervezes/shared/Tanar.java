package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Tanar implements Serializable {

	

	//K�s�bb �tker�l a Person �soszt�lyba
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String vezetekNev;
	@Persistent
	private String keresztNev;
	@Persistent
	private String nem;
	@Persistent
	private Date szuletesiDatum;
	@Persistent
	private int version;
	
	//Tanar specifikus mezok
	@Persistent
	private List<Tantargy> targyak;
	
	public Tanar() { }
	//optimalizalni
	public Tanar(String vezetekNev, String keresztNev, int version,
			String nem, Date szuletesiDatum, List<Tantargy> targyak) {
		this.vezetekNev = vezetekNev;
		this.keresztNev = keresztNev;
		this.nem = nem;
		this.szuletesiDatum = szuletesiDatum;
		this.version = version;
		this.targyak = targyak;
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
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public List<Tantargy> getTargyak() {
		return targyak;
	}
	public void setTargyak(List<Tantargy> targyak) {
		this.targyak = targyak;
	}
	public Long getId() {
		return id;
	}
	public String getNem() {
		return nem;
	}
	public void setNem(String nem) {
		this.nem = nem;
	}
	public Date getSzuletesiDatum() {
		return szuletesiDatum;
	}
	public void setSzuletesiDatum(Date szuletesiDatum) {
		this.szuletesiDatum = szuletesiDatum;
	}
	
		
}
