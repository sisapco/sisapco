package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.Contrato;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Long>{
	
	@Query(value ="SELECT u.contra_id,u.cop_nit,u.contra_descripcion,u.contra_documento_adjunto,"
			+"(SELECT e.est_valor_estado FROM estados e WHERE u.contra_estado=e.est_id_codigo) as contra_estado,"
			+ "u.contra_fecha_fin,u.contra_fecha_inicio,u.contra_interventor,"
			+ "u.contra_log,u.contra_nombre_contratista,u.contra_num_contrato,u.contra_observaciones,"
			+ "u.contra_plazo,u.contra_tiempo,u.contra_valor,u.contra_visualizacion,u.contra_fecha_registro"
			+ " FROM contrato u WHERE u.cop_nit = ?1 ORDER BY u.contra_id DESC", nativeQuery = true)
	public Iterable<Contrato> findByContratoNit(int copNit);	
	
}
