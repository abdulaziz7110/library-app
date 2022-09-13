package uz.pdp.libraryapp.book;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryapp.author.AuthorDto;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookDao {
    private final JdbcTemplate jdbcTemplate;


    public List<BookDto> getAllBooksFromDb() {

        String sql = "select b.id as id,\n" +
                "       b.title,\n" +
                "       json_agg(json_build_object(\n" +
                "               'authorId', a.id,\n" +
                "               'authorFullName', a.full_name)\n" +
                "           )\n" +
                "from books b\n" +
                "         join books_authors ba on b.id = ba.book_id\n" +
                "         join authors a on a.id = ba.author_id\n" +
                "group by b.title, b.id";
        return jdbcTemplate.query(sql, (rs, row) -> {

                    Array array = rs.getArray(3);
                    Type type = new TypeToken<List<AuthorDto>>() {
                    }.getType();
                    List<AuthorDto> authorDtoList = new Gson().fromJson(array.toString(), type);


                    return BookDto.builder()
                            .id(rs.getInt(1))
                            .title(rs.getString(2))
                            .authorDtoList(authorDtoList)
                            .build();
                }
        );
    }

    public int addBoook(BookDto bookDto) {
        String sql = "insert into books(title, isbn, description, language_id) values ('"+ bookDto.getTitle() +"','"+ bookDto.getIsbn() +"','"+ bookDto.getDescription()+"','"+bookDto.getLanguageId()+"') ";

        return jdbcTemplate.update(sql);

    }

    public Integer takeId() {
        String sql = "select max (id) from books";

        Integer data = jdbcTemplate.queryForObject(sql, Integer.class);

        return data;
    }

    public void addBooksAuthorDB(Integer bookId, List<Integer> authorsIds) {

        for (Integer authorsId : authorsIds) {
            String sql = "insert into books_authors(book_id, author_id) values " +
                    "('"+ bookId +"','"+ authorsId +"')";
             jdbcTemplate.update(sql);
        }

    }

    public int addBooksCategories(Integer bookId, Integer categoryId){

        String sql = "insert into books_categories(book_id, category_id) values('"+ bookId +"','"+ categoryId +"')";

        return jdbcTemplate.update(sql);
    }

    public void deleteBooksAuthors(int id) {

        for (int i = 0; i < 7; i++) {
            String sql = "delete from books_authors where book_id = '" + id + "'";
            jdbcTemplate.update(sql);
        }
    }

    public void deleteBooksCategories(int id) {
        String sql = "delete from books_categories where book_id = '"+ id + "'";
        jdbcTemplate.update(sql);
    }


    public void deleteBooks(int id) {

        String sql = "delete from books where id = '"+ id +"'";
        jdbcTemplate.update(sql);
    }

    public BookDto selectBookById(int bookId) {

        String sql = "select b.id as id, b.title, b.isbn, b.description,\n" +
                " json_agg(json_build_object(a.id, a.full_name)),\n" +
                " b.language_id, bc.category_id\n" +
                "from books b\n" +
                "join books_authors ba on b.id = ba.book_id\n" +
                "    join authors a on a.id = ba.author_id\n" +
                "join books_categories bc on b.id = bc.book_id\n" +
                "where b.id = 2\n" +
                "group by b.id, b.title, b.language_id,bc.category_id ;\n";
       return (BookDto) jdbcTemplate.queryForList(sql,BookDto.class);
    }

    public void editBooks(BookDto bookDto) {


        jdbcTemplate.update("update books set title = '"+ bookDto.getTitle() +"', isbn = "+ bookDto.getIsbn() +", description = '"+ bookDto.getDescription() +"', language_id = "+ bookDto.getLanguageId() +" where id = "+ bookDto.getId() +"");
    }
}

