package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Inquilino;

@Repository
public interface InquilinoRepository extends CrudRepository<Inquilino, Long>{
	
	@Query("SELECT u FROM Inquilino u WHERE u.inquilinoId = ?1")
	public Inquilino findByInquilinoId(int inquilinoId);
	
	@Query("SELECT u FROM Inquilino u WHERE u.proNumeroResidencia = ?1")
	public Inquilino findByInquilinoNumeroResidencia(int proNumeroResidencia);

	@Query(value = "SELECT * FROM Inquilino u WHERE u.cop_nit = ?1 ORDER BY u.inquilino_id DESC LIMIT 1", nativeQuery = true)
	public Inquilino findByInquilinoNit(int copNit);

}
