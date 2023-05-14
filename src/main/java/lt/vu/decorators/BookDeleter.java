package lt.vu.decorators;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Book;
import lt.vu.services.BookService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@RequestScoped
public class BookDeleter implements IDeleter, Serializable
{
    @Inject
    @Getter @Setter
    private BookService bookService;

    public Book deleteById(int id)
    {
        return bookService.delete(id);
    }
}
