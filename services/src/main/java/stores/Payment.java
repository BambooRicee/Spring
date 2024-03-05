package stores;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import lombok.Data;
@Data
@Table
public class Payment implements Serializable {
private static final long serialVersionUID = 1L;
@Id
private Long id; 
private Long typeId;

@NotBlank(message = "Имя клиента не может быть пустым.")
private String clientName;

@NotNull(message = "Количество покупок не может быть пустым.")
@Max(value = 100, message = "Максимальное значение для количества покупок - 100")
private Integer paymentQuantity;
 
@NotNull(message = "Цена покупки не может быть пустой.")
@DecimalMin(value = "0.0", inclusive = false, message = "Цена покупки должна быть больше 0")
private Double  paymentAmount;
}







