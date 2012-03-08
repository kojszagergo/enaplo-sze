/**
 * 
 */
package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * @author Kojsza Gergely
 * Oszt�lynapl�k
 *
 */
public class OsztalyNaplo implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Long schoolClassId;
	@Persistent
	private Date open;
	@Persistent
	private Date biannual; //f�l�vi z�r�s. Jobbat keresni
	@Persistent
	private Date yearEnd; // �v v�gi z�r�s. Jobbat keresni
}
