package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Book;
import lt.vu.persistence.BookDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class Books implements Serializable
{
    @Inject
    private BookDAO bookDAO;

    @Getter
    private List<Book> allBooks;

    @PostConstruct
    public void init()
    {
        loadAllAuthors();
    }


    private void loadAllAuthors()
    {
        this.allBooks = bookDAO.getAll();
    }
}
