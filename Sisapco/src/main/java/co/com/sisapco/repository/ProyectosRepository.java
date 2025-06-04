package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.Proyectos;

@Repository
public interface ProyectosRepository extends CrudRepository<Proyectos, Integer>{
	
	@Query("SELECT u FROM Proyectos u WHERE u.copNit = ?1")
	public Iterable<Proyectos> findByProyectosNit(int copNit);

}
