package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Author;
import lt.vu.entities.Book;
import lt.vu.persistence.AuthorDAO;
import lt.vu.persistence.BookDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class AuthorBooks implements Serializable
{
    @Inject
    private AuthorDAO authorDAO;

    @Inject
    private BookDAO bookDAO;

    @Getter @Setter
    private Author author;

    @Getter @Setter
    private Book bookToCreate = new Book();

    @PostConstruct
    public void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer authorId = Integer.parseInt(requestParameters.get("authorId"));
        this.author = authorDAO.findOne(authorId);
    }

    @Transactional
    public void createBook()
    {
        bookToCreate.setAuthor(this.author);
        bookDAO.persist(bookToCreate);
    }
}
