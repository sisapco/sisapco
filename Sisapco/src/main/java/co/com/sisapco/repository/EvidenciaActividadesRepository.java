package co.com.sisapco.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.EvidenciaActividades;


@Repository
public interface EvidenciaActividadesRepository extends CrudRepository<EvidenciaActividades, Integer>{
	
	@Query("SELECT u FROM EvidenciaActividades u WHERE u.actId = ?1 AND u.eviEstadoImagen = 1")
	public Iterable<EvidenciaActividades> findByEvidenciaActividadesActId(int actId);

}

