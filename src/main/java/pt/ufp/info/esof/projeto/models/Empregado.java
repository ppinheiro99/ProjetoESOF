package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @OneToMany(mappedBy = "empregado",cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();
    private Cargo cargo;
}