package lt.vu.persistence;

import lt.vu.entities.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GenreDAO
{
    @Inject
    private EntityManager entityManager;

    public List<Genre> getAll()
    {
        return entityManager.createNamedQuery("Genre.getAll", Genre.class).getResultList();
    }

    public void persist(Genre genre)
    {
        this.entityManager.persist(genre);
    }

    public Genre findOne(Integer id)
    {
        return entityManager.find(Genre.class, id);
    }

    public Genre update(Genre genre)
    {
        return entityManager.merge(genre);
    }
}
