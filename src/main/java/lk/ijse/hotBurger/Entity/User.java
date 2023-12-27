package lk.ijse.hotBurger.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    int id;
    String username;
    String password;
    String type;
    String emailAddress;
    String phone;
}
