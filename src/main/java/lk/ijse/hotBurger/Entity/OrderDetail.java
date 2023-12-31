package lk.ijse.hotBurger.Entity;

import lk.ijse.hotBurger.dto.OrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetail {
    int id;
    String size;
    int qty;
    double total;
    int orderId;
    double unitCost;
    String itemCode;
    String name;
    double unitPrice;
}
