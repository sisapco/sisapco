package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.DatosGenerales;


@Repository
public interface DatosGeneralesRepository extends CrudRepository<DatosGenerales, Integer> {
	
/*
	@Query ("SELECT u FROM SancionesMulta u WHERE u.copNit = ?1 ORDER BY u.mulId DESC")
	public Iterable<SancionesMulta> findBySancionesMultaNit(int copNit);
	
	@Query("SELECT u FROM SancionesMulta u WHERE u.mulId = ?1")
	public SancionesMulta findBySancionesMultaIdForm(int actId);
	
	@Query(value = "SELECT * FROM sanciones_multa u WHERE u.cop_nit = ?1 ORDER BY u.mul_numero DESC LIMIT 1", nativeQuery = true)
	public SancionesMulta findBySancionesMultaNitConsecutivo(int copNit);
	*/
	
}