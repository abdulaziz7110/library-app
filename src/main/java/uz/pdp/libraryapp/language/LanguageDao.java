package uz.pdp.libraryapp.language;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LanguageDao {

    private final JdbcTemplate jdbcTemplate;

    public List<Language> getAllLanguage() {

        String sql = "select id, lang\n" +
                "from languages ;";
        return jdbcTemplate.query(sql, (rs, row) ->
                Language.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .build()
        );
    }

    public void saveLanguage(String lang) {

        String sql = "insert into languages(lang) VALUES ('"+ lang +"')";

        jdbcTemplate.execute(sql);
    }

    public void delete(int id) {

        String sql = "delete from languages where id = '"+ id +"'";

        jdbcTemplate.update(sql);
    }

    public void editLanguage(Language lang) {

        jdbcTemplate.update("update languages set lang = '"+ lang.getName() +"' where id = '"+ lang.getId() +"'");
    }
}

