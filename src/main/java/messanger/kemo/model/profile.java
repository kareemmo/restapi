package messanger.kemo.model;

import java.util.Date;

public class profile {
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	
	public profile() {
		
	}
	public profile(long id,String profilename,String fName,String lName) {
		this.id=id;
		this.profileName=profilename;
		this.firstName=fName;
		this.lastName=lName;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	


}
