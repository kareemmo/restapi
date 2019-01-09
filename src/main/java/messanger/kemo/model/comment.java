package messanger.kemo.model;

import java.util.Date;

public class comment {
	private long id;
	private String message;
	private String author;
	private Date created;
	public comment(long id, String message,String author) {
		this.id=id;
		this.author=author;
		this.message=message;
		this.created=new Date();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

}
