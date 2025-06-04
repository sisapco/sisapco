package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Comunicados;
import co.com.sisapco.entity.Pqrs;

@Repository
public interface PqrsRepository extends CrudRepository<Pqrs, Integer>{
	
	/*@Query("SELECT u FROM Pqrs u WHERE u.copNit = ?1 ORDER BY u.idPqrs DESC")
	public Iterable<Pqrs> findByPqrsNit(int copNit); */
	
	@Query("SELECT u FROM Pqrs u WHERE u.idPqrs = ?1")
	public Pqrs findByPqrsIdForm(int idPqrs);
	
	@Query(value = "SELECT * FROM pqrs u WHERE u.cop_nit = ?1 ORDER BY u.id_pqrs DESC LIMIT 1", nativeQuery = true)
	public Pqrs findByPqrsNitConsecutivo(int copNit);
	
	
	@Query(value ="SELECT u.id_pqrs,u.cop_nit,u.pro_cc,u.pro_nombres,u.pro_apellidos,u.pro_numero_residencia,u.pqrs_email,u.pqrs_telefono, u.pqrs_direccion_correspondecia, u.pqrs_descripcion_pqrs, "
			+ "(SELECT e.est_valor_estado FROM estados e WHERE u.pqrs_estado=e.est_id_codigo) as pqrs_estado,"
			+ "u.pqrs_adjunto,u.pqrs_fecha_creacion,u.pqrs_fecha_respuesta,u.pqrs_logs,u.pqrs_visualizacion,u.pqrs_respuesta_pqrs, u.pqrs_adjunto_respuesta FROM pqrs u WHERE u.cop_nit = ?1 ORDER BY u.id_pqrs DESC", nativeQuery = true)
	public Iterable<Pqrs> findByPqrsNit(int copNit);
		
}
