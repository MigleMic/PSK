package lt.vu.usecases;

import lt.vu.services.BookNameUpdateAsync;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class UpdateBookName implements Serializable
{
    private Integer bookId;
    private String name;

    @Inject
    private BookNameUpdateAsync nameUpdate;

    private CompletableFuture<String> update1;

    private CompletableFuture<String> update2;

    @PostConstruct
    public void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        bookId = Integer.parseInt(requestParameters.get("bookId"));

    }

    public String updateAsync()
    {
        update1 = CompletableFuture.supplyAsync(() -> nameUpdate.update(bookId, "Update_1", 1000, 0));
        update2 = CompletableFuture.supplyAsync(() -> nameUpdate.update(bookId, "Update_2", 0, 3000));
        return "bookDetails.xhtml?bookId=" + bookId + "&faces-redirect=true";
    }

    public boolean update1Running()
    {
        return this.update1 != null && !this.update1.isDone();
    }

    public boolean update2Running()
    {
        return this.update2 != null && !this.update2.isDone();
    }

    public String getUpdate1Status() throws ExecutionException, InterruptedException
    {
        if(update1 == null)
            return null;
        else if(update1Running())
            return "Update 1 is running";
        return "Update 1 is finished. Exit status: " + update1.get();
    }

    public String getUpdate2Status() throws ExecutionException, InterruptedException
    {
        if(update2 == null)
            return null;
        else if(update2Running())
            return "Update 2 is running";
        return "Update 2 is finished. Exit status: " + update2.get();
    }
}
