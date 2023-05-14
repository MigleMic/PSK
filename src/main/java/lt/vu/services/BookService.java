package lt.vu.services;

import lt.vu.entities.Author;
import lt.vu.entities.Book;
import lt.vu.entities.Genre;
import lt.vu.persistence.AuthorDAO;
import lt.vu.persistence.BookDAO;
import lt.vu.persistence.GenreDAO;
import lt.vu.rest.contracts.BookDto;
import lt.vu.rest.contracts.GenreDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class BookService
{
    @Inject
    BookDAO bookDAO;

    @Inject
    AuthorDAO authorDAO;

    @Inject
    GenreDAO genreDAO;

    @Inject
    private EntityManager em;

    public List<Book> getAll()
    {
        return bookDAO.getAll();
    }

    public Book get(int id) throws NotFoundException
    {
        Book book = bookDAO.findOne(id);
        if(book == null)
        {
            throw new NotFoundException("Book with Id" + id + "was not found");
        }
        return book;
    }

    public Book createForm(BookDto bookDto)
    {
        validate(bookDto);
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setAuthor(getAuthorFrom(bookDto));
        book.setGenres(getGenresFrom(bookDto));
        bookDAO.persist(book);
        return book;
    }

    public Book updateForm(BookDto bookDto, int id)
    {
        validate(bookDto);
        Book book = get(id);
        book.setName(bookDto.getName());
        book.setAuthor(getAuthorFrom(bookDto));
        book.setGenres(getGenresFrom(bookDto));
        bookDAO.update(book);
        return book;
    }

    public Book updateFromOptimistic(BookDto bookDto, int id) throws InterruptedException
    {
        validate(bookDto);
        Book book = get(id);
        Thread.sleep(7000);
        book.setName(bookDto.getName());
        book.setAuthor(getAuthorFrom(bookDto));
        book.setGenres(getGenresFrom(bookDto));
        em.flush();
        return book;
    }

    public Book delete(int id)
    {
        Book book = get(id);
        bookDAO.delete(book);
        return book;
    }

    private void validate(BookDto bookDto)
    {
        if(bookDto.getName() == null)
            throw new BadRequestException("Book must have a name");
        if(bookDto.getAuthor() == null)
            throw new BadRequestException("Book must have an author");
    }

    private Author getAuthorFrom(BookDto bookDto)
    {
        Author author = authorDAO.findOne(bookDto.getAuthor().getId());
        if(author == null)
            throw new NotFoundException("Author with id " + bookDto.getId() + " was not found");
        return author;
    }

    private List<Genre> getGenresFrom(BookDto bookDto)
    {
        List<Genre> genres = new ArrayList<>();
        for(GenreDto genreDto : bookDto.getGenres())
        {
            Genre genre = genreDAO.findOne(genreDto.getId());
            if(genre == null)
                throw new NotFoundException("Genre with id " + genreDto.getId() + " was not found");
            genres.add(genre);
        }
        return genres;
    }
}
