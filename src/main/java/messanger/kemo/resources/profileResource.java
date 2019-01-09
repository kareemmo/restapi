package messanger.kemo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.model.ParamQualifier;

import messanger.kemo.model.profile;
import messanger.kemo.services.profileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class profileResource {
	profileService profservice=new profileService();
	@GET
	public List<profile> getAllProfiles(){
		return profservice.getAllprofiles();
	}
	
	@POST
	public profile addProfile(profile prof) {
		return profservice.addProfile(prof);
	}
	
	@GET
	@Path("/{name}")
	public profile getProfile(@PathParam("name") String name) {
	return profservice.getProfile(name);
	}
	@PUT
	@Path("/{name}")
	public profile updateProfile(@PathParam("name") String name,profile prof) {
	prof.setProfileName(name);
	return profservice.addProfile(prof);
	}
	@DELETE
	@Path("/{name}")
	public profile removeProfile(@PathParam("name") String name) {
		return profservice.removeProfile(name);
	}
}
