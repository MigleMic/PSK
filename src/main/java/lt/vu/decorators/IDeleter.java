package lt.vu.decorators;

import lt.vu.entities.Book;

public interface IDeleter
{
    Book deleteById(int id);
}
