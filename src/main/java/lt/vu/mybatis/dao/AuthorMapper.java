package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Author;
import org.mybatis.cdi.Mapper;

import java.util.List;
@Mapper
public interface AuthorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    int insert(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    Author selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    List<Author> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Wed Mar 08 12:59:08 EET 2023
     */
    int updateByPrimaryKey(Author record);
}