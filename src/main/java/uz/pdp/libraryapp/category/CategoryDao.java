package uz.pdp.libraryapp.category;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryapp.language.Language;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public List<CategoryDto> getAllCategory() {

            String sql = "select c.id, c.name\n" +
                    "from categories c ;";
            return jdbcTemplate.query(sql, (rs, row) ->
                     CategoryDto.builder()
                            .categoryId(rs.getInt(1))
                            .categoryName(rs.getString(2))
                            .build()
            );
    }

    public void saveCategory(Category category) {

            String sql = "insert into categories(name, description) VALUES ('"+ category.getName() +"','"+ category.getDescription() +"')";

            jdbcTemplate.execute(sql);
    }

    public void deleteCategory(int id) {

        String sql = "delete from categories where id = '"+ id +"'";

        jdbcTemplate.update(sql);
    }

    public void editCategory(Category category) {

        jdbcTemplate.update("update categories set name = '"+ category.getName() +"', description = '"+ category.getDescription() +"'  where id = '"+ category.getId() +"'");
    }
}
