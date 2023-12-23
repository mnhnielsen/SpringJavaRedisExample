package Model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item  implements Serializable{
    public int quantity;
    public double price;
    public String productId;
}
