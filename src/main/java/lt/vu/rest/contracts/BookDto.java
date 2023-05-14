package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Book;
import lt.vu.entities.Genre;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class BookDto
{
    private Integer id;
    private String name;
    private AuthorDto author;
    private List<GenreDto> genres;

    public BookDto(){}

    public BookDto(Book book)
    {
        this.id = book.getId();
        this.name = book.getName();
        this.author = new AuthorDto(book.getAuthor());
        this.genres = new ArrayList<>();

        for(Genre genre : book.getGenres())
        {
            this.genres.add(new GenreDto(genre));
        }
    }
}
