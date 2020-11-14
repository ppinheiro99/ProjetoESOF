package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "projeto",cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();
    @ManyToOne
    private Cliente cliente;
}