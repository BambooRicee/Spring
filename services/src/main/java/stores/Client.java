package stores;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;
@Data
@Table
public class Client {
@Id
	private Long id;
private final String lastname;
private final String firstname;
private final String email;
private final String phone;
private final String status;

}








