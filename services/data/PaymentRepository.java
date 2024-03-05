package stores.data;

import org.springframework.data.repository.CrudRepository;
import stores.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
