package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Terceros;

@Repository
public interface TercerosRepository extends CrudRepository<Terceros, Integer>{

	@Query("SELECT u FROM Terceros u WHERE u.terceId = ?1")
	public Terceros findByInquilinoId(int inquilinoId);
	
	@Query(value = "SELECT * FROM Terceros u WHERE u.cop_nit = ?1 ORDER BY u.terce_id DESC LIMIT 1", nativeQuery = true)
	public Terceros findByTercerosNit(int copNit);
}