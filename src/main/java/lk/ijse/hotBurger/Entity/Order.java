package lk.ijse.hotBurger.Entity;

import lk.ijse.hotBurger.dto.DeliveryDto;
import lk.ijse.hotBurger.dto.OrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private int id;
    private String type;
    private String date;
    private double subTotal = 0;
    private double discount;
    private double deliveryCharge;
    private double total;
    private int customerId;

}
