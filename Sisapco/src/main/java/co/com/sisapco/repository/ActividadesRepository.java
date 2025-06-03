<<<<<<< HEAD
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actividades;

@Repository
public interface ActividadesRepository extends CrudRepository<Actividades, Long>{

	/*@Query(value ="SELECT u.actId, u.copNit,u.actFechaInicio,u.actFechaFinal,u.actNombreActividad,"
			+ "(SELECT e.estValorEstado FROM Estados e WHERE u.actEstado=e.estIdCodigo) as actEstado,u.actDescripcion,u.actCosto,u.actResponsable,u.actDesviacion,u.actFechaEntregaReal,u.actActividades,"
			+ "u.actNumeroActividades,u.actPorcentajeEjecucion,u.actObservaciones,u.actLog FROM Actividades u WHERE u.copNit = ?1 ORDER BY u.actId DESC", nativeQuery = true)
	public Iterable<Actividades> findByActividadesNit(int codNit); */
	
	
	@Query(value ="SELECT u.act_id, u.cop_nit,u.act_fecha_inicio,u.act_fecha_final,u.act_nombre_actividad,"
			+ "(SELECT e.est_valor_estado FROM estados e WHERE u.act_estado=e.est_id_codigo) as act_estado,"
			+ "u.act_descripcion,u.act_costo,u.act_responsable,u.act_desviacion,u.act_fecha_entrega_real,u.act_actividades,"
			+ "u.act_numero_actividades,u.act_porcentaje_ejecucion,u.act_observaciones,u.act_observaciones_administrador,u.act_log FROM actividades u WHERE u.cop_nit = ?1 ORDER BY u.act_id DESC", nativeQuery = true)
	public Iterable<Actividades> findByActividadesNit(int codNit);
	
	@Query("SELECT u FROM Actividades u WHERE u.actId = ?1 AND u.actEstado = 1")
	public Iterable<Actividades> findByActividadesId(int actId);
	
	@Query("SELECT u FROM Actividades u WHERE u.actId = ?1")
	public Actividades findByActividadesIdForm(int actId);
	
	
	
}
=======
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actividades;

@Repository
public interface ActividadesRepository extends CrudRepository<Actividades, Long>{

	/*@Query(value ="SELECT u.actId, u.copNit,u.actFechaInicio,u.actFechaFinal,u.actNombreActividad,"
			+ "(SELECT e.estValorEstado FROM Estados e WHERE u.actEstado=e.estIdCodigo) as actEstado,u.actDescripcion,u.actCosto,u.actResponsable,u.actDesviacion,u.actFechaEntregaReal,u.actActividades,"
			+ "u.actNumeroActividades,u.actPorcentajeEjecucion,u.actObservaciones,u.actLog FROM Actividades u WHERE u.copNit = ?1 ORDER BY u.actId DESC", nativeQuery = true)
	public Iterable<Actividades> findByActividadesNit(int codNit); */
	
	
	@Query(value ="SELECT u.act_id, u.cop_nit,u.act_fecha_inicio,u.act_fecha_final,u.act_nombre_actividad,"
			+ "(SELECT e.est_valor_estado FROM estados e WHERE u.act_estado=e.est_id_codigo) as act_estado,"
			+ "u.act_descripcion,u.act_costo,u.act_responsable,u.act_desviacion,u.act_fecha_entrega_real,u.act_actividades,"
			+ "u.act_numero_actividades,u.act_porcentaje_ejecucion,u.act_observaciones,u.act_observaciones_administrador,u.act_log FROM actividades u WHERE u.cop_nit = ?1 ORDER BY u.act_id DESC", nativeQuery = true)
	public Iterable<Actividades> findByActividadesNit(int codNit);
	
	@Query("SELECT u FROM Actividades u WHERE u.actId = ?1 AND u.actEstado = 1")
	public Iterable<Actividades> findByActividadesId(int actId);
	
	@Query("SELECT u FROM Actividades u WHERE u.actId = ?1")
	public Actividades findByActividadesIdForm(int actId);
	
	
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
