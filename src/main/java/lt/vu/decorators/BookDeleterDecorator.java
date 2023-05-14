package lt.vu.decorators;

import lt.vu.entities.Book;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class BookDeleterDecorator implements IDeleter
{
    @Inject
    @Delegate
    @Any
    IDeleter bookDeleter;

    public Book deleteById(int id)
    {
        Book book = bookDeleter.deleteById(id);
        if (book != null)
        {
            System.out.println("Deleted a book from a database.\nID:" + book.getId() +
                    "\nName:" + book.getName() + "\nGenres" + book.getGenres() +
                    "\nAuthor:" + book.getAuthor().getName());
        }
        return book;
    }
}