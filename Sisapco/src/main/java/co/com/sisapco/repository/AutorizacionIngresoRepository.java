package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actas;
import co.com.sisapco.entity.AutorizacionIngreso;

@Repository
public interface AutorizacionIngresoRepository extends CrudRepository<AutorizacionIngreso, Integer>{

	@Query("SELECT u FROM Actas u WHERE u.copNit = ?1 ORDER BY u.actId DESC")
	public Iterable<AutorizacionIngreso> findByActasNit(int codNit);
	
	@Query("SELECT u FROM Actas u WHERE u.actId = ?1")
	public AutorizacionIngreso findByActaIdForm(int actId);
	
	@Query(value = "SELECT * FROM actas u WHERE u.cop_nit = ?1 ORDER BY u.act_id DESC LIMIT 1", nativeQuery = true)
	public AutorizacionIngreso findByActasNitConsecutivo(int copNit);
}
