package stores.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stores.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
