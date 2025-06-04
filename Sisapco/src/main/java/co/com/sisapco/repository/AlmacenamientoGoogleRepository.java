package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actividades;
import co.com.sisapco.entity.AlmacenamientoGoogle;

@Repository
public interface AlmacenamientoGoogleRepository extends CrudRepository<AlmacenamientoGoogle, Integer>{

	@Query("SELECT u FROM AlmacenamientoGoogle u WHERE u.copNit = ?1 AND u.almaCarpeta = ?2")
	public AlmacenamientoGoogle findByAlmacenamientoGoogleNit(int codNit, String carpeta);
	
	
}
