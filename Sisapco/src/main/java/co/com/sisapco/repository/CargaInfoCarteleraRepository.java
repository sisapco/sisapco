package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.com.sisapco.entity.Cartelera;

@Repository
public interface CargaInfoCarteleraRepository extends CrudRepository<Cartelera, Integer>{	
	
	@Query(value ="SELECT u.cartelera_id,u.cop_nit,u.pro_numero_residencia,u.cartelera_nombre_publicacion,"
			
			+ "u.cartelera_descripcion,u.cartelera_fecha_inicio,u.cartelera_fecha_fin,"
			+ "u.cartelera_documento_adjunto,"
			+"(SELECT e.est_valor_estado FROM estados e WHERE u.cartelera_estado=e.est_id_codigo) as cartelera_estado,"
			+"u.cartelera_log"
			+ " FROM cartelera u WHERE u.cop_nit = ?1 ORDER BY u.cartelera_id DESC", nativeQuery = true)
	public Iterable<Cartelera> findByCarteleraNit(int copNit);
	
}
