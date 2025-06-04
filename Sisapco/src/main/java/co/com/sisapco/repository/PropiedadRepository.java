package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Propiedad;

@Repository
public interface PropiedadRepository extends CrudRepository<Propiedad, Integer>{
	
	@Query("SELECT u FROM Propiedad u WHERE u.proId = ?1")
	public Propiedad findByPropiedadId(int proId);
	
	@Query("SELECT u FROM Propiedad u WHERE u.proNumeroResidencia = ?1")
	public Propiedad findByPropiedadNumeroResidencia(int proNumeroResidencia);

	@Query(value = "SELECT * FROM Propiedad u WHERE u.cop_nit = ?1 ORDER BY u.pro_id DESC LIMIT 1", nativeQuery = true)
	public Propiedad findByPropiedadNit(int copNit);

}
