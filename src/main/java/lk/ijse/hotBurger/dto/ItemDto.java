package lk.ijse.hotBurger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemDto {
    private int id;
    private String itemCode;
    private String name;
    private double unitPrice;
    private double unitCost;
    private String  categoryId;
    private String image;

    public ItemDto(int id,String itemCode,String itemName,double unitPrice,double unitCost,String  categoryId ) {
        this.id = id;
        this.itemCode = itemCode;
        this.name = itemName;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
        this.categoryId = categoryId;
    }
}
