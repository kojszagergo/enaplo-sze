package hu.diplomatervezes.shared;

import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class News {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private long id;
	
	@Persistent
	private Date createDate;
	
	@Persistent
	private String headerText;
	
	@Persistent
	private String bodyText;
	
	public News() {
		this.createDate = new Date();
	}
	
	public  News(String headerText, String bodyText) {
		this();
		this.headerText = headerText;
		this.bodyText = bodyText;
	}

	public String getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String headerText) {
		this.headerText = headerText;
	}

	public String getBodyText() {
		return bodyText;
	}

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public long getId() {
		return id;
	}
}