package co.com.sisapco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Comunicados;
import co.com.sisapco.entity.ManualConvivencia;
import co.com.sisapco.entity.Pqrs;

@Repository
public interface ComunicadosRepository extends CrudRepository<Comunicados, Long>{
	
	/*@Query("SELECT u FROM Comunicados u WHERE u.copNit = ?1 ORDER BY u.comuId DESC")
	public Iterable<Comunicados> findByComunicadosNit(int copNit); */
	
	@Query("SELECT u FROM Comunicados u WHERE u.comuId = ?1")
	public Comunicados findByComunicadosIdForm(int comuId);
	
	@Query(value ="SELECT u.comu_id, u.cop_nit,u.comu_nombre,u.comu_fecha,"
			+ "(SELECT e.est_valor_estado FROM estados e WHERE u.comu_estado=e.est_id_codigo) as comu_estado,"
			+ "u.comu_descripcion,u.comu_archivo,u.comu_log,u.comu_visualizacion FROM comunicados u WHERE u.cop_nit = ?1 ORDER BY u.comu_id DESC", nativeQuery = true)
	public Iterable<Comunicados> findByComunicadosNit(int codNit);
	
}