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
 * Tan�veket t�rol� oszt�ly
 *
 */
@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Tanev implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Date kezdesDatuma;
	@Persistent
	private Date befejezesDatuma;
	@Persistent
	private String megnevezes;
	
	
	public Tanev() {}
	public Tanev(Date kezdesDatuma, Date befejezesDatuma, String megnevezes) {
		this.kezdesDatuma = kezdesDatuma;
		this.befejezesDatuma = befejezesDatuma;
		this.megnevezes = megnevezes;
	}
	
	
	public Date getKezdesDatuma() {
		return kezdesDatuma;
	}
	public void setKezdesDatuma(Date kezdesDatuma) {
		this.kezdesDatuma = kezdesDatuma;
	}
	public Date getBefejezesDatuma() {
		return befejezesDatuma;
	}
	public void setBefejezesDatuma(Date befejezesDatuma) {
		this.befejezesDatuma = befejezesDatuma;
	}
	public String getMegnevezes() {
		return megnevezes;
	}
	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}
	public Long getId() {
		return id;
	}
	
	
	
	
	
}
