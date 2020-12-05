package pt.ufp.info.esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.ufp.info.esof.projeto.models.Projeto;

public interface TempoEfetivoRepository extends CrudRepository<Projeto,Long> {
    Projeto findById(long id);
}
