package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.ContactoEmergencia;
import co.com.sisapco.entity.Vehiculo;

@Repository
public interface ContactoEmergenciaRepository extends CrudRepository<ContactoEmergencia, Integer>{
	
	@Query("SELECT u FROM ContactoEmergencia u WHERE u.emergenciaId = ?1")
	public Vehiculo findByContactoEmergenciaId(int vehiculoId);
	

	@Query(value = "SELECT * FROM ContactoEmergencia u WHERE u.cop_nit = ?1 ORDER BY u.emergencia_id DESC LIMIT 1", nativeQuery = true)
	public Vehiculo findByContactoEmergenciaNit(int copNit);
	
}
