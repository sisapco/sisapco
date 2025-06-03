<<<<<<< HEAD
package co.com.sisapco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Modulo;
import co.com.sisapco.entity.Usuarios;

@Repository
public interface UserRepository extends CrudRepository<Usuarios, Long>{

	
 @Query("SELECT u FROM Usuarios u WHERE u.username = ?1 AND u.usuEstado = 1")	
 public Optional<Usuarios> findByUsername(String username);
 
 @Query("SELECT u FROM Usuarios u WHERE u.username = ?1 AND u.usuEstado = 1")
 public Usuarios findByValidarUsername(String user);
 
	
}
=======
package co.com.sisapco.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Modulo;
import co.com.sisapco.entity.Usuarios;

@Repository
public interface UserRepository extends CrudRepository<Usuarios, Long>{

	
 @Query("SELECT u FROM Usuarios u WHERE u.username = ?1 AND u.usuEstado = 1")	
 public Optional<Usuarios> findByUsername(String username);
 
 @Query("SELECT u FROM Usuarios u WHERE u.username = ?1 AND u.usuEstado = 1")
 public Usuarios findByValidarUsername(String user);
 
	
}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
