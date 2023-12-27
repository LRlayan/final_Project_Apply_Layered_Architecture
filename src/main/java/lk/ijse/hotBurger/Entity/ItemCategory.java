package lk.ijse.hotBurger.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ItemCategory {
    private int id;
    private String name;
    private String description;
}
