package hu.diplomatervezes.shared;

import hu.diplomatervezes.shared.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Tanar implements Serializable {


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
	private List<Tantargy> TanatargySets;
	@Persistent
	private Date dateCreated;
	@Persistent
	private int version;
	

	
	public Tanar() { }
	
	public Tanar(String vezetekNev, String keresztNev, String nem, Date szuletesiDatum) 
	{
		this.vezetekNev = vezetekNev;
		this.keresztNev = keresztNev;
		this.nem = nem;
		this.szuletesiDatum = szuletesiDatum;
		setDateCreated();
		incrementVersion();
		
	}
	
	public String getVezetekNev() {return vezetekNev;}
	public void setVezetekNev(String vezetekNev) {this.vezetekNev = vezetekNev;}
	
	public String getKeresztNev() {	return keresztNev;}
	public void setKeresztNev(String keresztNev) {this.keresztNev = keresztNev;}
	
	public String getNem() {return nem;}
	public void setNem(String nem) {this.nem = nem;}
	
	public Date getSzuletesiDatum() {return szuletesiDatum;}
	public void setSzuletesiDatum(Date szuletesiDatum) {this.szuletesiDatum = szuletesiDatum;}
	
	public void setVersion(int version) {this.version = version;}
//  objekum verzio beallitasa
	public int getVersion(){
		if (version == 0) {
			version = 1;
		}
		return version;
	}
	
//	verzio novelese	
	private void incrementVersion() {
		if (version == 0){
			version = 1;
		} else {version++;}
	}
	
	public List<Tantargy> getTanatargySets() {return TanatargySets;}
	public void setTanatargySets(List<Tantargy> tanatargySets) {TanatargySets = tanatargySets;}
	
	public Long getId() {return id;}
	
//	letrehozas datum beallitasa
	public void setDateCreated() {
		if (dateCreated == null) {
			dateCreated = new Date();
		}
	}
	
	public Date getDateCreated(){return dateCreated;}
}
