package lt.vu.mybatis.model;

public class BookGenre {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK_GENRE.BOOKS_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    private Integer booksId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK_GENRE.GENRES_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    private Integer genresId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK_GENRE.BOOKS_ID
     *
     * @return the value of PUBLIC.BOOK_GENRE.BOOKS_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public Integer getBooksId()
    {
        return booksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK_GENRE.BOOKS_ID
     *
     * @param booksId the value for PUBLIC.BOOK_GENRE.BOOKS_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public void setBooksId(Integer booksId)
    {
        this.booksId = booksId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK_GENRE.GENRES_ID
     *
     * @return the value of PUBLIC.BOOK_GENRE.GENRES_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public Integer getGenresId()
    {
        return genresId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK_GENRE.GENRES_ID
     *
     * @param genresId the value for PUBLIC.BOOK_GENRE.GENRES_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public void setGenresId(Integer genresId)
    {
        this.genresId = genresId;
    }
}