package lk.ijse.hotBurger.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    private int id;
    private String fName;
    private String lName;
    private String address;
    private String mobile;
}
