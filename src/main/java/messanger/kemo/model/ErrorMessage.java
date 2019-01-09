package messanger.kemo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errormessage;
	private String documentation;
	private int errorcode;
	
	public ErrorMessage() {
		
	}
	public ErrorMessage(int errorcode,String errmessage,String doc) {
		super();
		this.errorcode=errorcode;
		this.errormessage=errmessage;
		this.documentation=doc;
	}
	
	public String geterrorMessage() {
		return errormessage;
	}
	public void seterrorMessage(String message) {
		this.errormessage = message;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

}
