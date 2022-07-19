package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actividades;

@Repository
public interface ActividadesRepository extends CrudRepository<Actividades, Long>{

	@Query("SELECT u FROM Actividades u WHERE u.copNit = ?1 AND u.actEstado = 1")
	public Iterable<Actividades> findByActividadesNit(int codNit);
	
	@Query("SELECT u FROM Actividades u WHERE u.actId = ?1 AND u.actEstado = 1")
	public Iterable<Actividades> findByActividadesId(int actId);
	
	@Query("SELECT u FROM Actividades u WHERE u.actId = ?1 AND u.actEstado = 1")
	public Actividades findByActividadesIdForm(int actId);
	
	
	
}
