package lt.vu.persistence;

import lt.vu.entities.Author;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@Specializes
@ApplicationScoped
public class AuthorDAOType extends AuthorDAO
{
    @PostConstruct
    private void LogBookAuthor(Author author)
    {
        System.out.println("Author " + author.getName());
    }

    @Override
    public Author findOne(Integer id)
    {
        Author author = super.findOne(id);
        LogBookAuthor(author);
        return author;
    }
}

