package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Funcionario extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Cargo cargo;
    @OneToMany(mappedBy = "funcionario",cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();

    public void consultarPrazoTarefa(Tarefa tarefa){

    }
}