package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({@NamedQuery(
        name = "Author.getAll", query = "select a from Author as a")})
@Table(name = "AUTHOR")
@Getter @Setter
public class Author implements Serializable
{
    /*Long and genre*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
