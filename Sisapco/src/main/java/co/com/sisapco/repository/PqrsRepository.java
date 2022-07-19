package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Pqrs;

@Repository
public interface PqrsRepository extends CrudRepository<Pqrs, Long>{
	
	@Query("SELECT u FROM Pqrs u WHERE u.copNit = ?1")
	public Iterable<Pqrs> findByPqrsNit(int copNit);

}
