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
 * Iskolai oszt�lyokat reprezent�l� oszt�ly
 *
 */
public class SchoolClass implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Long schoolYearId;
	@Persistent
	private Long gradeId;
	@Persistent
	private Long formMasterId; //oszt�lyf�n�k id
}
