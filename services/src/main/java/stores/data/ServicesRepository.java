package stores.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stores.Services;

@Repository
public interface ServicesRepository extends CrudRepository<Services, Long> {

	Optional<Services> findById(String id);
}
