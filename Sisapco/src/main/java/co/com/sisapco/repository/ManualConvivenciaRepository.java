package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.ManualConvivencia;

@Repository
public interface ManualConvivenciaRepository extends CrudRepository<ManualConvivencia, Integer>{

	/*@Query("SELECT u FROM ManualConvivencia u WHERE u.copNit = ?1 ORDER BY u.conviId DESC")
	public Iterable<ManualConvivencia> findByManualConvivenciaNit(int copNit); */
	
	@Query("SELECT u FROM ManualConvivencia u WHERE u.conviId = ?1")
	public ManualConvivencia findByConviIdForm(int conviId);
	
	@Query(value ="SELECT u.convi_id, u.cop_nit,u.convi_nombre,u.convi_archivo,u.convi_ano_publicacion,"
			+ "(SELECT e.est_valor_estado FROM estados e WHERE u.convi_estado=e.est_id_codigo) as convi_estado,"
			+ "u.convi_log,u.convi_visualizacion FROM manual_convivencia u WHERE u.cop_nit = ?1 ORDER BY u.convi_id DESC", nativeQuery = true)
	public Iterable<ManualConvivencia> findByManualConvivenciaNit(int codNit);
	
}
