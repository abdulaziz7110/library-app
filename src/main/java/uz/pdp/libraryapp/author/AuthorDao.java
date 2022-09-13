package uz.pdp.libraryapp.author;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorDao {

    private final JdbcTemplate jdbcTemplate;


    public List<AuthorDto> getAllAuthorsForSelect() {
        String sql = "select a.id, a.full_name\n" +
                "from authors a;";
        return jdbcTemplate.query(sql, (rs, row) ->
                AuthorDto.builder()
                        .authorId(rs.getInt(1))
                        .authorFullName(rs.getString(2))
                        .build()
        );
    }

    public  List<Author> getAuthorList(){
        String sql = " select * from authors";

        return jdbcTemplate.query(sql, (rs, row) ->
                Author.builder()
                        .id(rs.getInt(1))
                        .fullName(rs.getString(2))
                        .biography(rs.getString(3))
                        .age(rs.getInt(4))
                        .build()
        );
    }

    public void saveAuthor(Author author) {
        String sql = "insert into authors(full_name, biography, age) values ('"+ author.getFullName() +"','"+ author.getBiography() +"','"+ author.getAge()+"')";
        jdbcTemplate.update(sql);

    }

    public void editAuthor(Author author) {

            jdbcTemplate.update("update authors set full_name = '"+ author.getFullName() +"', biography = '"+ author.getBiography() +"', age = '"+ author.getAge() +"'  where id = '"+ author.getId() +"'");
    }

    public void deleteAuthor(int id) {

        String sql = "delete from authors where id = '"+ id +"'";

        jdbcTemplate.update(sql);
    }
}
