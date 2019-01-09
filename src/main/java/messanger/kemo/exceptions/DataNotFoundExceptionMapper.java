package messanger.kemo.exceptions;

import java.io.ObjectInputFilter.Status;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import messanger.kemo.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		ErrorMessage errmessage=new ErrorMessage(404,"data not found  ","http://www.google.com ");
		return Response.status(javax.ws.rs.core.Response.Status.NOT_FOUND)
				.entity(errmessage)
				.build();
	}

}
