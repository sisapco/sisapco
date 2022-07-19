package co.com.sisapco.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Modulo;

@Repository
public interface ModuloRepository extends CrudRepository<Modulo, Long> {
	
	 @Query("SELECT u FROM Modulo u WHERE u.perId = ?1 AND u.modEstado = 1 ORDER BY u.modOrdenamiento ASC")	
	 public Iterable<Modulo> findByModulosId(int perfilId);
	 
	 @Query("SELECT u FROM Modulo u WHERE u.modEstado = 1")	
	 public Iterable<Modulo> findByModulos();

}
