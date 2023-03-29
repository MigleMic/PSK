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
        name = "Book.getAll", query = "select b from Book as b")})
@Table(name = "BOOK")
@Getter @Setter
public class Book implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ISBN", unique = true)
    private String isbn;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;
    @ManyToMany
    @JoinTable(
            name="BOOK_GENRE",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "GENRE_ID"))
    private List<Genre> genres = new ArrayList<>();

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
