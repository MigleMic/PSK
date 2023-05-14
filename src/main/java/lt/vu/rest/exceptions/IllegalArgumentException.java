package lt.vu.rest.exceptions;

import javax.persistence.OptimisticLockException;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentException implements ExceptionMapper<Exception>
{
    @Override
    public Response toResponse(Exception e)
    {
        System.out.println();
        if(e instanceof NotFoundException)
            return Response.status(Response.Status.NOT_FOUND).build();
        if(e instanceof BadRequestException)
            return Response.status(Response.Status.BAD_REQUEST).build();
        if(e instanceof OptimisticLockException)
            return Response.status(Response.Status.CONFLICT).build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
