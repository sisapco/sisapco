<<<<<<< HEAD
package co.com.sisapco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Copropiedad;


@Repository
public interface CopropiedadRepository extends CrudRepository<Copropiedad, Long>{
	
	@Query("SELECT u FROM UsuariosCopropiedad a, Copropiedad u WHERE a.usuId = ?1 AND a.copNit = u.copNit AND u.copEstado = 1")
	public Iterable<Copropiedad> findByCopropiedadUsuario(int usuId);
	
	@Query("SELECT u FROM Copropiedad u WHERE u.copId = ?1 AND u.copEstado = 1")
	public Optional<Copropiedad> findByCopropiedadId(int id);
	
	@Query("SELECT u FROM Copropiedad u WHERE u.copNit = ?1 AND u.copEstado = 1")
	public Iterable<Copropiedad> findByCopropiedadNit(int nit);
	
}
=======
package co.com.sisapco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Copropiedad;


@Repository
public interface CopropiedadRepository extends CrudRepository<Copropiedad, Long>{
	
	@Query("SELECT u FROM UsuariosCopropiedad a, Copropiedad u WHERE a.usuId = ?1 AND a.copNit = u.copNit AND u.copEstado = 1")
	public Iterable<Copropiedad> findByCopropiedadUsuario(int usuId);
	
	@Query("SELECT u FROM Copropiedad u WHERE u.copId = ?1 AND u.copEstado = 1")
	public Optional<Copropiedad> findByCopropiedadId(int id);
	
	@Query("SELECT u FROM Copropiedad u WHERE u.copNit = ?1 AND u.copEstado = 1")
	public Iterable<Copropiedad> findByCopropiedadNit(int nit);
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
