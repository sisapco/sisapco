<<<<<<< HEAD
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Cotizaciones;

@Repository
public interface CotizacionesRepository extends CrudRepository<Cotizaciones, Long>{
	
	@Query("SELECT u FROM Cotizaciones u WHERE u.copNit = ?1 ORDER BY u.cotId DESC")
	public Iterable<Cotizaciones> findByCotizacionesNit(int copNit);
	
}
=======
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Cotizaciones;

@Repository
public interface CotizacionesRepository extends CrudRepository<Cotizaciones, Long>{
	
	@Query("SELECT u FROM Cotizaciones u WHERE u.copNit = ?1 ORDER BY u.cotId DESC")
	public Iterable<Cotizaciones> findByCotizacionesNit(int copNit);
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
