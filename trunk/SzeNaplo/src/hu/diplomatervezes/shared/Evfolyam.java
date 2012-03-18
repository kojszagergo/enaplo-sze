/**
 * 
 */
package hu.diplomatervezes.shared;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Kojsza Gergely
 * �vfolyamokat t�rol� oszt�ly
 *
 */
@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Evfolyam implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private short evfolyamSzam;
	@Persistent
	private char evfolyamJel;
	@Persistent
	private String megnevezes; //megnevez�s
	
	public Evfolyam() {}

	public Evfolyam(short evfolyamSzam, char evfolyamJel, String megnevezes) {
		this.evfolyamSzam = evfolyamSzam;
		this.evfolyamJel = evfolyamJel;
		this.megnevezes = megnevezes;
	}

	public short getEvfolyamSzam() {
		return evfolyamSzam;
	}

	public void setEvfolyamSzam(short evfoylamSzam) {
		this.evfolyamSzam = evfoylamSzam;
	}

	public char getEvfolyamJel() {
		return evfolyamJel;
	}

	public void setEvfolyamJel(char evfolyamJel) {
		this.evfolyamJel = evfolyamJel;
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
