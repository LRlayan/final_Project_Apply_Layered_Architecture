package lk.ijse.hotBurger.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {
    private int id;
    private String itemCode;
    private String name;
    private double unitPrice;
    private double unitCost;
    private String  categoryId;
    private String image;

}
