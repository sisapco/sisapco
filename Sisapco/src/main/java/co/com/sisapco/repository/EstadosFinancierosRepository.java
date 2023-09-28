package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.EstadosFinancieros;

@Repository
public interface EstadosFinancierosRepository extends CrudRepository<EstadosFinancieros, Long>{

	@Query("SELECT u FROM EstadosFinancieros u WHERE u.copNit = ?1 ORDER BY u.copNit DESC")
	public Iterable<EstadosFinancieros> findByEstadosFinancierosNit(int copNit);
	
}
