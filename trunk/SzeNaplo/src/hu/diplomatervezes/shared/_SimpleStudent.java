package hu.diplomatervezes.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class _SimpleStudent implements Serializable{
	
	private String id;
	private String firstName;
	private String lastName;
	
	public _SimpleStudent() {
	}
	
	public _SimpleStudent(String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//Be�ll�t�, kiolvas� met�dusok
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
