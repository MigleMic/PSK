package lt.vu.mybatis.model;

public class Book {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.ISBN
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    private String isbn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.NAME
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.BOOK.AUTHOR_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    private Integer authorId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK.ID
     *
     * @return the value of PUBLIC.BOOK.ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK.ID
     *
     * @param id the value for PUBLIC.BOOK.ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK.ISBN
     *
     * @return the value of PUBLIC.BOOK.ISBN
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public String getIsbn()
    {
        return isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK.ISBN
     *
     * @param isbn the value for PUBLIC.BOOK.ISBN
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK.NAME
     *
     * @return the value of PUBLIC.BOOK.NAME
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK.NAME
     *
     * @param name the value for PUBLIC.BOOK.NAME
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.BOOK.AUTHOR_ID
     *
     * @return the value of PUBLIC.BOOK.AUTHOR_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public Integer getAuthorId()
    {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.BOOK.AUTHOR_ID
     *
     * @param authorId the value for PUBLIC.BOOK.AUTHOR_ID
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    public void setAuthorId(Integer authorId)
    {
        this.authorId = authorId;
    }
}