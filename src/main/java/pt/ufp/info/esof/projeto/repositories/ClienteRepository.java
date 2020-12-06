package pt.ufp.info.esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.projeto.models.Cliente;
@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
    Cliente findById(long id);
}
