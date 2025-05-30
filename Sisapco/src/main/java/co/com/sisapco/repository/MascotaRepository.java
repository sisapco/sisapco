package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Mascota;
import co.com.sisapco.entity.Propiedad;
import co.com.sisapco.entity.Vehiculo;

@Repository
public interface MascotaRepository extends CrudRepository<Mascota, Long>{
	
	@Query("SELECT u FROM Mascota u WHERE u.mascotaId = ?1")
	public Vehiculo findByMascotaId(int mascotaId);
	

	@Query(value = "SELECT * FROM mascota u WHERE u.cop_nit = ?1 ORDER BY u.mascota_id DESC LIMIT 1", nativeQuery = true)
	public Vehiculo findByMascotaNit(int copNit);

}
