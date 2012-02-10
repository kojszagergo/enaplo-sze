package hu.diplomatervezes.shared;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Teacher implements Serializable {

	//K�s�bb �tker�l a Person �soszt�lyba
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String firstName;
	@Persistent
	private String lastName;
	@Persistent
	private String postCode;
	@Persistent
	private String city;
	@Persistent
	private String street;
	@Persistent
	private String taj; //TAJ sz�m
	@Persistent
	private int version;
	
	//Tan�r specifikus mez�k
	@Persistent
	private List<Subject> targyak;
}
