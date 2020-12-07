package pt.ufp.info.esof.projeto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.ufp.info.esof.projeto.models.Tarefa;
@Repository
public interface TarefaRepository extends CrudRepository<Tarefa,Long> {
    Tarefa findById(long id);
}
