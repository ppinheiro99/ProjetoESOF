package pt.ufp.info.esof.projeto.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Projeto {
    @Id
    private long id;

    @OneToMany
    private List<Tarefa> tarefas = new ArrayList<>();
    @ManyToOne
    private Cliente cliente;

}