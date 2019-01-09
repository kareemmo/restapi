package messanger.kemo.exceptions;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import messanger.kemo.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		// TODO Auto-generated method stub
		ErrorMessage errmessage=new ErrorMessage(500,"internal server error ","http://www.google.com ");
		return Response.status(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR)
				.entity(errmessage)
				.build();
	}

}
