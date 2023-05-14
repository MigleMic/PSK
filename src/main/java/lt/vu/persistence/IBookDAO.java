package lt.vu.persistence;

import lt.vu.entities.Book;

import java.util.List;

public interface IBookDAO
{
    void persist(Book book);
    Book findOne(Integer id);
    Book update(Book bookToCreate);
    List<Book> getAll();
}
