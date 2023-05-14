package lt.vu.persistence;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@Alternative
@ApplicationScoped
public class BookSingleGenreDAO extends BookDAO implements IBookDAO
{
    @Override
    public List<Book> getAll()
    {
        List<Book> bookWithSingleGenre = new ArrayList<>();
        for(Book book : super.getAll())
        {
            if(book.getGenres().size() <= 1)
              bookWithSingleGenre.add(book);
        }
        return bookWithSingleGenre;
    }
}