package messanger.kemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import messanger.kemo.database.DatabaseClass;
import messanger.kemo.model.ErrorMessage;
import messanger.kemo.model.comment;
import messanger.kemo.model.message;

public class commentService {
	private Map<Long,message> messages=DatabaseClass.getMessages();
	public List<comment> getAllComments(long messageId){
		Map<Long,comment> comments=messages.get(messageId).getComments();
		return new ArrayList<comment>(comments.values());
	}
	public comment getComment(long messageid,long commentid) {
		ErrorMessage errmessage=new ErrorMessage(404,"404 not found ","http://www.google.com ");
		Response res= Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
				.entity(errmessage)
				.build();
		message mess=messages.get(messageid);
		if(mess==null) {
			throw new WebApplicationException(res);
		}
		Map<Long,comment> comments=messages.get(messageid).getComments();
		comment comment= comments.get(commentid);
		if(comment==null) {
			throw new WebApplicationException(res);
		}
		return comment;
	}
	public comment addComment(long messageid,comment comment) {
		Map<Long,comment> comments=messages.get(messageid).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	public comment updateComment(long messageid,comment comment) {
		Map<Long,comment> comments=messages.get(messageid).getComments();
        if(comment.getId()<=0) {return null;}
        comments.put(comment.getId(), comment);
		return comment;	
	}
	public comment removeComment(long messageid,long commentid) {
		Map<Long,comment> comments=messages.get(messageid).getComments();
		 return comments.remove(commentid);
	}

}
