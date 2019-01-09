package messanger.kemo.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import messanger.kemo.beans.messagefilterbean;
import messanger.kemo.model.comment;
import messanger.kemo.model.message;
import messanger.kemo.services.commentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class commentResource {
	
	commentService commentService=new commentService();
	
	
    @GET
	public List<comment> getcomments(@PathParam("messageId") long messageId) {
	
		return commentService.getAllComments(messageId);
	}
	
	@POST

	public comment addcomment(@PathParam("messageId") long messageId, comment comment) {
		return commentService.addComment(messageId, comment);
	}
	@PUT
	@Path("/{commentid}")
	public comment updatecomment(@PathParam("messageId") long messageId,@PathParam("commentid") long id,comment comment) {
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}
	@DELETE
	@Path("/{commentid}")

	public comment removecomment(@PathParam("messageId") long messageId,@PathParam("commentid") long id) {
		return commentService.removeComment(messageId,id);
	}
	@GET
	@Path("/{commentid}")
	public comment getcomment(@PathParam("messageId") long messageId,@PathParam("id") long id) {
		return commentService.getComment(messageId,id);
	}
	
	

}
