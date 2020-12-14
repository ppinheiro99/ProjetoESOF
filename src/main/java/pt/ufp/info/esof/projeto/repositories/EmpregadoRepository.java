package pt.ufp.info.esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.projeto.models.Empregado;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpregadoRepository extends CrudRepository<Empregado, Long> {
}
