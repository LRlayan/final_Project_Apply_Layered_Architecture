package lk.ijse.hotBurger.dto;

import lk.ijse.hotBurger.Entity.DeliveryDetail;
import lk.ijse.hotBurger.Entity.OrderDetail;
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
    DeliveryDetail deliveryDetails;
    List<OrderDetailsDto> orderItem;

//    public OrderDto(int id, double subTotal, double deliveryCharge, double discount,  double total,String date, int customerId , String type) {
//        this.id = id;
//        this.subTotal = subTotal;
//        this.deliveryCharge = deliveryCharge;
//        this.discount = discount;
//        this.total = total;
//        this.date = date;
//        this.customerId = customerId;
//        this.type = type;
//    }

    public OrderDto(int id, String type, String date, double subTotal, double discount, double deliveryCharge, double total, int customerId) {
        this.id = id;
        this.subTotal = subTotal;
        this.deliveryCharge = deliveryCharge;
        this.discount = discount;
        this.total = total;
        this.date = date;
        this.customerId = customerId;
        this.type = type;
    }

    public OrderDto(double total) {
        this.total = total;
    }
}
