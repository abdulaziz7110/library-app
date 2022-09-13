package uz.pdp.libraryapp.record;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import uz.pdp.libraryapp.book.BookDto2;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RecordDao {

    private final JdbcTemplate jdbcTemplate;


    public List<RecordDto> getAllRecords() {

        String sql = "select u.id,u.full_name, u.phone_number,\n" +
                "       r.\"dateTime\",r.id as record_id, r.is_returned,\n" +
                "       json_agg(json_build_object(\n" +
                "            'id',b.id," +
                "             'title',b.title\n" +
                "           )) as book_list\n" +
                "from  users u\n" +
                "join records r on u.id = r.user_id\n" +
                "join records_books rb on r.id = rb.record_id\n" +
                "join books b on b.id = rb.book_id\n" +
                "group by u.id,u.full_name, u.id, u.phone_number, r.\"dateTime\", r.id, r.is_returned;\n";


        return jdbcTemplate.query(sql, (rs, row) -> {

                    Array array = rs.getArray(7);
                    Type type = new TypeToken<List<BookDto2>>() {
                    }.getType();
                    List<BookDto2> book = new Gson().fromJson(array.toString(), type);


                    return RecordDto.builder()
                            .userId(rs.getInt(1))
                            .userFullname(rs.getString(2))
                            .phoneNumber(rs.getString(3))
                            .dateTime(String.valueOf(rs.getString(4)))
                            .recordId(rs.getInt(5))
                            .isReturned(rs.getBoolean(6))
                            .bookList(book)
                            .build();
                }
        );

    }

    public void saveRecord(Record record) {

        record.setId(lastId()+1);
        System.out.println(record.getId());

        String sql = "insert into records(user_id) values (?)";

        jdbcTemplate.update(sql,
                record.getUserId()
        );

//        Integer lastSavedRecordId = jdbcTemplate.query("select currval(records_id_seq);",
//                rs -> {
//                    rs.next();
//                    return rs.getInt(1);
//                });
//        System.out.println(lastSavedRecordId);



        for (Integer bookId : record.getBookIds()) {

            String sql2 = "insert into records_books(record_id, book_id) values (?,?)";

                jdbcTemplate.update(sql2,
                        record.getId(),
                        bookId);
        }

    }

    private Integer lastId(){

        String sql = "select max (id) from records";

        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);

        return integer;
    }

    public void deleteRecord(int id) {

        deleteRecordBooks(id);

        String sql = "delete from records where id = '"+ id +"'";

        jdbcTemplate.update(sql);
    }
    private void deleteRecordBooks(int id){

        String sql = "delete from records_books where record_id = '"+ id +"'";
        jdbcTemplate.update(sql);

    }
}
