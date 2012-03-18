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
 * Iskolai oszt�lyokat reprezent�l� oszt�ly
 *
 */
@SuppressWarnings("serial")
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Osztaly implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Tanev tanev;
	@Persistent
	private Evfolyam evfolyam;
	@Persistent
	private Tanar osztalyFonok;
	@Persistent
	private List<Diak> diak;
}
