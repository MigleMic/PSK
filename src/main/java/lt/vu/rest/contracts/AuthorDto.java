package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Author;

@Getter @Setter
public class AuthorDto
{
    private Integer id;
    private  String name;

    public AuthorDto(){}

    public AuthorDto(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public AuthorDto(Author author)
    {
        this.id = author.getId();
        this.name = author.getName();
    }
}
