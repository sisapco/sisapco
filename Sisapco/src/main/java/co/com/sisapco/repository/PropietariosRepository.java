<<<<<<< HEAD
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Propietarios;

@Repository
public interface PropietariosRepository extends CrudRepository<Propietarios, Long>{
	
	@Query("SELECT u FROM Propietarios u WHERE u.proCc = ?1")
	public Propietarios findByPropietariosCc(int proCc);

	@Query(value = "SELECT * FROM pqrs u WHERE u.cop_nit = ?1 ORDER BY u.pro_id DESC LIMIT 1", nativeQuery = true)
	public Propietarios findByPropietariosNitConsecutivo(int copNit);

}
=======
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Propietarios;

@Repository
public interface PropietariosRepository extends CrudRepository<Propietarios, Long>{
	
	@Query("SELECT u FROM Propietarios u WHERE u.proCc = ?1")
	public Propietarios findByPropietariosCc(int proCc);

	@Query(value = "SELECT * FROM pqrs u WHERE u.cop_nit = ?1 ORDER BY u.pro_id DESC LIMIT 1", nativeQuery = true)
	public Propietarios findByPropietariosNitConsecutivo(int copNit);

}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
