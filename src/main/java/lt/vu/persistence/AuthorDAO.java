package lt.vu.persistence;

import lt.vu.entities.Author;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class AuthorDAO
{
    @Inject
    private EntityManager entityManager;

    public List<Author> getAll()
    {
        return entityManager.createNamedQuery("Author.getAll", Author.class).getResultList();
    }

    public void persist(Author author)
    {
        this.entityManager.persist(author);
    }

    public Author findOne(Integer id)
    {
        return entityManager.find(Author.class, id);
    }

    public Author update(Author author)
    {
        return entityManager.merge(author);
    }

}
