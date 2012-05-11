/**
 * 
 */
package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


/**
 * @author Kojsza Gergely
 *
 */
@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Tantargy implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent
	private String tantargyNeve;
	
	@Persistent
	private String rovidNev;
//	letrehozasa datuma
	@Persistent
	private Date dateCreated;
//	objketum verzio tarolasa
	@Persistent
	private Long version;
	
	public Tantargy() {}
	
	public Tantargy(String tantargyNeve, String rovidNev) {
		this.tantargyNeve = tantargyNeve;
		this.rovidNev = rovidNev;
		setDateCreated();
		incrementVersion();
	}

	public String getTantargyNeve() {return tantargyNeve;}
	public void setTantargyNeve(String tantargyNeve) {this.tantargyNeve = tantargyNeve;}

	public String getRovidNev() {return rovidNev;}
	public void setRovidNev(String rovidNev) {this.rovidNev = rovidNev;}

	public Long getId() {return id;}
//  itt eseteleg meghivhato az incrementVersion metodus	
	public void setVersion(Long version){this.version = version;}
//  objekum verzio beallitasa
	public Long getVersion(){
		if (version == null) {
			version = (long) 01;
		}
		return version;
	}
	
//	verzio novelese	
	private void incrementVersion() {
		if (version == null){
			version = (long) 01;
		} else {version++;}
	}
//	letrehozas datum beallitasa
	public void setDateCreated() {
		if (dateCreated == null) {
			dateCreated = new Date();
		}
	}
	
	public Date getDateCreated(){return dateCreated;}
	
}
