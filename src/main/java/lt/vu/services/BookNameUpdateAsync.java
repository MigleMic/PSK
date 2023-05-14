package lt.vu.services;

import lt.vu.entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class BookNameUpdateAsync
{
    @PersistenceContext
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String update(Integer id, String name, int preWait, int postWait)
    {
        try
        {
            Thread.sleep(preWait);
            Book book = em.find(Book.class, id);
            Thread.sleep(postWait);
            book.setName(name);
            em.flush();
        }
        catch (OptimisticLockException e)
        {
            System.out.println("OptimisticLockException");
            return "OptimisticLockException";
        }
        catch (InterruptedException ignored)
        {
            System.out.println("INTERRUPTED");
        }
        return "Updated";
    }
}
