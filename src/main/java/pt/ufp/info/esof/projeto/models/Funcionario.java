package pt.ufp.info.esof.projeto.models;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Funcionario extends Pessoa {
    @Id
    private long id;

    @ManyToOne
    private Cargo cargo;

    @OneToMany
    private List<Tarefa> tarefas = new ArrayList<>();



}