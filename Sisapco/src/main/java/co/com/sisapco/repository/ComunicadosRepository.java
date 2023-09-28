package co.com.sisapco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Comunicados;

@Repository
public interface ComunicadosRepository extends CrudRepository<Comunicados, Long>{
	
	@Query("SELECT u FROM Comunicados u WHERE u.copNit = ?1 ORDER BY u.copNit DESC")
	public Iterable<Comunicados> findByComunicadosNit(int copNit);
	
	
}