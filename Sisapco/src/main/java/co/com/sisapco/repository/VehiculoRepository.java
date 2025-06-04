package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Propiedad;
import co.com.sisapco.entity.Vehiculo;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer>{
	
	@Query("SELECT u FROM Vehiculo u WHERE u.vehiculoId = ?1")
	public Vehiculo findByVehiculoId(int vehiculoId);
	

	@Query(value = "SELECT * FROM vehiculo u WHERE u.cop_nit = ?1 ORDER BY u.vehiculo_id DESC LIMIT 1", nativeQuery = true)
	public Vehiculo findByVehiculoNit(int copNit);

}
