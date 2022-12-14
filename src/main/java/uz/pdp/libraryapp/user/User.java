package uz.pdp.libraryapp.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private Integer id;
    private String fullName;
    private String phoneNumber;
    private boolean isAdmin;
    private String password;
}
