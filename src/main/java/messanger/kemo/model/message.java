package messanger.kemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement() 
public class message {
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long,comment> comments=new HashMap<>();
	private List<link> links=new ArrayList<>();
	

	public List<link> getLinks() {
		return links;
	}
	public void setLinks(List<link> links) {
		this.links = links;
	}
	public message() {
		
	}
	public message(long id,String msg,String auth) {
		this.id=id;
		message=msg;
		created=new Date();
		author=auth;
		
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient
	public Map<Long, comment> getComments() {
		return comments;
	}
	public void setComments(Map<Long, comment> comments) {
		this.comments = comments;
	}
	public void addlink(String lin,String rel) {
		link link=new link();
		link.setLink(lin);
		link.setRel(rel);
		links.add(link);
	}
}

