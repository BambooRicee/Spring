package stores;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
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
private Date createdAt = new Date(id);

private final String quantity;
private final String amount;
private List<Client> clients = new ArrayList<>();
public void addClient(Client client) {
this.clients.add(client);
}
private List<Services> services = new ArrayList<>();
public void addServices(Services services) {
this.services.add(services);
}
}







