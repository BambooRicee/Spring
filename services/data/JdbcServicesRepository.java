package stores.data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stores.Services;
@Repository
public class JdbcServicesRepository implements ServicesRepository{
 private JdbcTemplate jdbcTemplate;
 public JdbcServicesRepository(JdbcTemplate jdbcTemplate) {
 this.jdbcTemplate = jdbcTemplate;
 }
// ...
@Override
public Iterable<Services> findAll() {
// TODO Auto-generated method stub
return null;
}
@Override
public Optional<Services> findById(String id) {
// TODO Auto-generated method stub
return Optional.empty();
}
@Override
public Services save(Services services) {
// TODO Auto-generated method stub
return null;
}
@Override
public <S extends Services> Iterable<S> saveAll(Iterable<S> entities) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Optional<Services> findById(Long id) {
	// TODO Auto-generated method stub
	return Optional.empty();
}
@Override
public boolean existsById(Long id) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public Iterable<Services> findAllById(Iterable<Long> ids) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public long count() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public void deleteById(Long id) {
	// TODO Auto-generated method stub
	
}
@Override
public void delete(Services entity) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteAllById(Iterable<? extends Long> ids) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteAll(Iterable<? extends Services> entities) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteAll() {
	// TODO Auto-generated method stub
	
}
}