/**
 * 
 */
package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.List;

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
	
	public Tantargy() {}
	
	public Tantargy(String tantargyNeve, String rovidNev) {
		this.tantargyNeve = tantargyNeve;
		this.rovidNev = rovidNev;
	}

	public String getTantargyNeve() {
		return tantargyNeve;
	}

	public void setTantargyNeve(String tantargyNeve) {
		this.tantargyNeve = tantargyNeve;
	}

	public String getRovidNev() {
		return rovidNev;
	}

	public void setRovidNev(String rovidNev) {
		this.rovidNev = rovidNev;
	}

	public Long getId() {
		return id;
	}
	
	
}
