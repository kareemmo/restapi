package messanger.kemo.resources;

import java.net.URI;
import java.util.List;
import java.util.function.ToLongFunction;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;

import com.sun.research.ws.wadl.Request;

import messanger.kemo.beans.messagefilterbean;
import messanger.kemo.model.message;
import messanger.kemo.services.messageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	messageService messService=new messageService();
	
	
    @GET
	public List<message> getmessages(@BeanParam messagefilterbean filterbean) {
		int year=filterbean.getYear();
		if(year>0) {
			return messService.getAllMessagesforyear(year);
		}
		if(filterbean.getStart()>=0 && filterbean.getEnd()>=0) {
			return messService.getAllMessagespaginated(filterbean.getStart(),filterbean.getEnd());
		}
		return messService.getAllMessages();
	}
	
	@POST

	public Response addmessage(@Context UriInfo uriinfo, message mes) {
		
		message newmessage= messService.addMessage(mes);
		String newid=String.valueOf(newmessage.getId());
		URI uri=uriinfo.getAbsolutePathBuilder().path(newid).build();
		return Response.created(uri)
				.entity(newmessage)
				.build();
				
	
		
		
	}
	@PUT
	@Path("/{id}")
	public message updatemessage(@PathParam("id") long id,message mes) {
		mes.setId(id);
		return messService.updateMessage(mes);
	}
	@DELETE
	@Path("/{id}")

	public message removemessage(@PathParam("id") long id) {
		return messService.removeMessage(id);
	}
	
	@GET
	@Path("/{id}")
	public message getmessage(@PathParam("id") long id,@Context UriInfo uriinfo) {
		message message= messService.getMessage(id);
		message.addlink(geturiforself(uriinfo, message), "self");
		message.addlink(geturiforprofile(uriinfo, message), "profile");
		message.addlink(geturiforcomments(uriinfo, message), "comments");


		return message;
	}

	private String geturiforcomments(UriInfo uriinfo, message message) {
		URI url=uriinfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(MessageResource.class,"getCommentResource")
				.path(commentResource.class)
				.resolveTemplate("id", message.getId())
				.build();
				
		return url.toString();
		
	}

	private String geturiforprofile(UriInfo uriinfo, message message) {
		URI url=uriinfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(message.getAuthor())
				.build();
				
		return url.toString();
	}

	private String geturiforself(UriInfo uriinfo, message message) {
		String url=uriinfo.getBaseUriBuilder().path(MessageResource.class)
				.path(Long.toString(message.getId())).build().toString();
		return url;
	}
	
	@Path("/{id}/comments")
	public commentResource getCommentResource() {
		return new commentResource();
	}

}
