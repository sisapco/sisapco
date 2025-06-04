package co.com.sisapco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer> {
	
	 @Query("SELECT u FROM Perfil u WHERE u.perId = ?1 AND u.perEstado = 1")	
	 public Optional<Perfil> findByPerfilId(int perfilId);

}
