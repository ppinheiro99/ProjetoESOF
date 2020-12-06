package pt.ufp.info.esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.projeto.models.TempoEfetivo;
@Repository
public interface TempoEfetivoRepository extends CrudRepository<TempoEfetivo,Long> {
    TempoEfetivo findById(long id);
}
