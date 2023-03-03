package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Contrato;

@Repository
public interface ContratoRepository extends CrudRepository<Contrato, Long>{
	
	@Query("SELECT u FROM Contrato u WHERE u.copNit = ?1 ORDER BY u.contraId DESC")
	public Iterable<Contrato> findByContratoNit(int copNit);
	
}
