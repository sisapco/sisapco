<<<<<<< HEAD
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actas;

@Repository
public interface ActasRepository extends CrudRepository<Actas, Long>{

	@Query("SELECT u FROM Actas u WHERE u.copNit = ?1 ORDER BY u.actId DESC")
	public Iterable<Actas> findByActasNit(int codNit);
	
	@Query("SELECT u FROM Actas u WHERE u.actId = ?1")
	public Actas findByActaIdForm(int actId);
	
	@Query(value = "SELECT * FROM actas u WHERE u.cop_nit = ?1 ORDER BY u.act_id DESC LIMIT 1", nativeQuery = true)
	public Actas findByActasNitConsecutivo(int copNit);
	
}
=======
package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actas;

@Repository
public interface ActasRepository extends CrudRepository<Actas, Long>{

	@Query("SELECT u FROM Actas u WHERE u.copNit = ?1 ORDER BY u.actId DESC")
	public Iterable<Actas> findByActasNit(int codNit);
	
	@Query("SELECT u FROM Actas u WHERE u.actId = ?1")
	public Actas findByActaIdForm(int actId);
	
	@Query(value = "SELECT * FROM actas u WHERE u.cop_nit = ?1 ORDER BY u.act_id DESC LIMIT 1", nativeQuery = true)
	public Actas findByActasNitConsecutivo(int copNit);
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
