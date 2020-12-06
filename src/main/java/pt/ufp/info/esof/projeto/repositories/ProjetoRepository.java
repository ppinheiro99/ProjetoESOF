package pt.ufp.info.esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.projeto.models.Projeto;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto,Long> {
    Projeto findById(long id);
}
