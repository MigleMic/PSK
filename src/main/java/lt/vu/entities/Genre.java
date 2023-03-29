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
        name = "Genre.getAll", query = "select g from Genre as g")})
@Table(name = "GENRE")
@Getter @Setter
public class Genre implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Book> books = new ArrayList<>();

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
