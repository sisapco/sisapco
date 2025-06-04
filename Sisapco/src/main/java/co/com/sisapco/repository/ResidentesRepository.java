package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Residentes;

@Repository
public interface ResidentesRepository extends CrudRepository<Residentes, Integer>{
	
	@Query("SELECT u FROM Residentes u WHERE u.residenteId = ?1")
	public Residentes findByResidenteId(int residenteId);
	

	@Query(value = "SELECT * FROM Residentes u WHERE u.cop_nit = ?1 ORDER BY u.residente_id DESC LIMIT 1", nativeQuery = true)
	public Residentes findByResidenteNit(int copNit);

}
