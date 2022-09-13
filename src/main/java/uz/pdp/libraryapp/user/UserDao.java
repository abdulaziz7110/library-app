package uz.pdp.libraryapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public List<UserDto> getAllUsers() {

        String sql = "select s.id, s.full_name, s.phone_number, s.password from users s";

        return jdbcTemplate.query(sql,(rs,row) ->
                UserDto.builder()
                        .id(rs.getInt(1))
                        .fullName(rs.getString(2))
                        .phoneNumber(rs.getString(3))
                        .password(rs.getString(4))
                        .build()

        );
    }

    public void addUser(User user) {
        jdbcTemplate.update("insert into users(full_name, phone_number,password) " +
                "values ('"+ user.getFullName() +"'," +
                "'"+ user.getPhoneNumber() +"','"+ user.getPassword() +"')"
     );
    }

    public void deleteUser(int id) {
         jdbcTemplate.update("delete from users where id = '"+ id +"'");
    }

    public int editUser(User user){

        return jdbcTemplate.update("update users set full_name = '" + user.getFullName() + "', phone_number = '" + user.getPhoneNumber() + "',password = '" + user.getPassword() + "'");

    }
}
