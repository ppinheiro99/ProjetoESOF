package pt.ufp.info.esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.projeto.models.TempoPrevisto;
@Repository
public interface TempoPrevistoRepository extends CrudRepository<TempoPrevisto,Long> {
    TempoPrevisto findById(long id);
}
