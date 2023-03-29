package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Genre;
import lt.vu.persistence.GenreDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class GenreBooks implements Serializable
{
    @Inject
    private GenreDAO genreDAO;

    @Getter @Setter
    private Genre genre;

    @PostConstruct
    public void init()
    {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer genreId = Integer.parseInt(requestParameters.get("genreId"));
        this.genre = genreDAO.findOne(genreId);
    }
}
