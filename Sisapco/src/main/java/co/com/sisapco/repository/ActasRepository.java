package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Actas;

@Repository
public interface ActasRepository extends CrudRepository<Actas, Long>{

	@Query("SELECT u FROM Actas u WHERE u.copNit = ?1")
	public Iterable<Actas> findByActasNit(int codNit);
	
	@Query("SELECT u FROM Actas u WHERE u.actId = ?1")
	public Actas findByActaIdForm(int actId);
}
