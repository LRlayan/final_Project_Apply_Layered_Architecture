package lk.ijse.hotBurger.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DeliveryDetail {
    private int id;
    private String address;
    private String additionalMobileNo;
    private int customerId;
}
