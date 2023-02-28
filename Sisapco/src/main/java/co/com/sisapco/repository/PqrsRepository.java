package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.com.sisapco.entity.Pqrs;

@Repository
public interface PqrsRepository extends CrudRepository<Pqrs, Long>{
	
	@Query("SELECT u FROM Pqrs u WHERE u.copNit = ?1 ORDER BY u.idPqrs DESC")
	public Iterable<Pqrs> findByPqrsNit(int copNit);
	
	@Query("SELECT u FROM Pqrs u WHERE u.idPqrs = ?1")
	public Pqrs findByPqrsIdForm(int idPqrs);
	
	@Query(value = "SELECT * FROM pqrs u WHERE u.cop_nit = ?1 ORDER BY u.id_pqrs DESC LIMIT 1", nativeQuery = true)
	public Pqrs findByPqrsNitConsecutivo(int copNit);
	
	
}
