/**
 * 
 */
package hu.diplomatervezes.shared;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Kojsza Gergely
 * �vfolyamokat t�rol� oszt�ly
 *
 */
public class Grade implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private short number;
	@Persistent
	private char sign;
	@Persistent
	private String appellation; //megnevez�s 
}
