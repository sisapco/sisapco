package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.EstadosFinancieros;
import co.com.sisapco.entity.Pqrs;

@Repository
public interface EstadosFinancierosRepository extends CrudRepository<EstadosFinancieros, Long>{

	/*@Query("SELECT u FROM EstadosFinancieros u WHERE u.copNit = ?1 ORDER BY u.copNit DESC")
	public Iterable<EstadosFinancieros> findByEstadosFinancierosNit(int copNit);*/
	
	@Query("SELECT u FROM EstadosFinancieros u WHERE u.estId = ?1")
	public EstadosFinancieros findByEstIdForm(int estId);
	
	
	@Query(value ="SELECT u.est_id, u.cop_nit,u.est_nombre_estado,u.est_descripcion,u.est_mes,u.est_ano,u.est_archivo,"
			+ "(SELECT e.est_valor_estado FROM estados e WHERE u.est_estado=e.est_id_codigo) as est_estado,"
			+ "u.est_log,u.est_visualizacion FROM estados_financieros u WHERE u.cop_nit = ?1 ORDER BY u.est_id DESC", nativeQuery = true)
	public Iterable<EstadosFinancieros> findByEstadosFinancierosNit(int codNit);
	
}
