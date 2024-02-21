package stores.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stores.Services;

@Repository
public interface ServicesRepository extends CrudRepository<Services, Long> {
}
