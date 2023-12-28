package lk.ijse.hotBurger.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto {
    private int id;
    private double subTotal = 0;
    private double deliveryCharge;
    private double discount;
    private double total;
    private String date;
    private int customerId;
    private String type;
    DeliveryDto deliveryDetails;
    List<OrderDetailsDto> orderItem;

    public OrderDto(int id, double subTotal, double deliveryCharge, double discount, String date, double total, int customerId , String type) {
        this.id = id;
        this.subTotal = subTotal;
        this.deliveryCharge = deliveryCharge;
        this.discount = discount;
        this.date = date;
        this.total = total;
        this.customerId = customerId;
        this.type = type;
    }

    public OrderDto(double total) {
        this.total = total;
    }
}
