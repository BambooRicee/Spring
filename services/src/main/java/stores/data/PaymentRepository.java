package stores.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import stores.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
