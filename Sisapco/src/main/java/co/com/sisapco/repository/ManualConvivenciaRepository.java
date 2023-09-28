package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.ManualConvivencia;

@Repository
public interface ManualConvivenciaRepository extends CrudRepository<ManualConvivencia, Long>{

	@Query("SELECT u FROM ManualConvivencia u WHERE u.copNit = ?1 ORDER BY u.copNit DESC")
	public Iterable<ManualConvivencia> findByManualConvivenciaNit(int copNit);
	
}
