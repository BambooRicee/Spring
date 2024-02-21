package stores;
import lombok.Data;
import java.util.Date;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Services {
@Id
private Long id; 
private Date createdAt = new Date(); 
@NotNull
@Size(min=5, message="Имя должно содержать не менее 5 символов")
private String name;

}







