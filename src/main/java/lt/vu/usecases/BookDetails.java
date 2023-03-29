package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Book;
import lt.vu.persistence.BookDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class BookDetails implements Serializable
{
    private Book book;

    @Inject
    private BookDAO bookDAO;

    @PostConstruct
    private void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer bookId = Integer.parseInt(requestParameters.get("bookId"));
        this.book = bookDAO.findOne(bookId);
    }
}