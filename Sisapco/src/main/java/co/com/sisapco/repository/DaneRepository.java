package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Dane;

@Repository
public interface DaneRepository extends CrudRepository<Dane, Integer>{

	@Query("SELECT DISTINCT u.nombreDepartamento, u.codigoDepartamento FROM Dane u")
	public Iterable<Dane> findByDaneDepartamentos();

	@Query(value = "SELECT * FROM dane u WHERE u.codigo_departamento = ?1 ORDER BY u.nombre_municipio ASC", nativeQuery = true)
	public Iterable<Dane> findByMunicipioCodigoDepartamento(String codigoDepartamento);
	
}
