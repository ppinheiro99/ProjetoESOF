package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class TempoPrevisto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float tempoPrevistoHoras;
    @OneToOne
    private Tarefa tarefa;
}
