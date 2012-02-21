package hu.diplomatervezes.shared;

import java.io.Serializable;

import com.google.gwt.view.client.ProvidesKey;

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
	
	public static final ProvidesKey<_SimpleStudent> KEY_PROVIDER = new ProvidesKey<_SimpleStudent>() {
		
		@Override
		public Object getKey(_SimpleStudent item) {
			return item == null ? null : item.getId();
		}
	};
		
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
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
}
