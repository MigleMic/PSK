package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.decorators.BookDeleter;
import lt.vu.entities.Book;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.BookDAO;
import lt.vu.rest.contracts.BookDto;
import lt.vu.services.BookService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/books")
public class BookController
{
    @Inject
    @Getter @Setter
    private BookService bookService;

    @Inject
    private EntityManager em;

    @Inject
    private BookDAO bookDAO;

    @Inject
    private BookDeleter bookDeleter;

    @LoggedInvocation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get()
    {
        List<BookDto> bookDto = new ArrayList<>();
        for(Book book : bookService.getAll())
        {
            bookDto.add(new BookDto(book));
        }
        return Response.ok(bookDto).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") final Integer id)
    {
        return Response.ok(new BookDto(bookService.get(id))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(BookDto bookDto)
    {
        return Response.ok(new BookDto(bookService.createForm(bookDto))).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer id, BookDto bookDto)
    {
        return Response.ok(new BookDto(bookService.updateForm(bookDto, id))).build();
    }

    @Path("/{id}/optimistic")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Response updateOptimistic(@PathParam("id") final Integer id, BookDto bookDto) throws InterruptedException
    {
        return Response.ok(new BookDto(bookService.updateFromOptimistic(bookDto, id))).build();
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") final Integer id)
    {
        return Response.ok(new BookDto(bookDeleter.deleteById(id))).build();
    }
}