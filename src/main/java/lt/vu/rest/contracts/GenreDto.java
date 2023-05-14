package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Genre;

@Getter @Setter
public class GenreDto
{
    private Integer id;
    private String name;

    public GenreDto(){}

    public GenreDto(Genre genre)
    {
        this.id = genre.getId();
        this.name = genre.getName();
    }
}
