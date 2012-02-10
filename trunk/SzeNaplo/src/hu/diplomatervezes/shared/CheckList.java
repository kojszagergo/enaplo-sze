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
 * N�vsorokat reprezent�l� oszt�ly
 *
 */
public class CheckList implements Serializable {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Long gradBookId;
	@Persistent
	private Long studentId;
	@Persistent
	private Date from;
	@Persistent
	private Date to;
}
