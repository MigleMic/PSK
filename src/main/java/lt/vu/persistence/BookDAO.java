package lt.vu.persistence;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BookDAO implements IBookDAO
{
    @Inject
    private EntityManager entityManager;

    public List<Book> getAll()
    {
        return entityManager.createNamedQuery("Book.getAll", Book.class).getResultList();
    }

    public void persist(Book book)
    {
        this.entityManager.persist(book);
    }

    public Book findOne(Integer id)
    {
        return entityManager.find(Book.class, id);
    }

    public Book update(Book book)
    {
        return entityManager.merge(book);
    }

    public void delete(Book book)
    {
        this.entityManager.remove(book);
    }
}
