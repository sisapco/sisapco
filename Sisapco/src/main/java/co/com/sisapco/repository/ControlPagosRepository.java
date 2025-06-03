package co.com.sisapco.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.sisapco.entity.ControlPagos;

@Repository
public interface ControlPagosRepository extends CrudRepository<ControlPagos, Long>{	

	
	
}

