package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class TempoEfetivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float tempoEfetivoHoras;
    @OneToOne
    private Tarefa tarefa;

    public void registaPeriodosDeTempo(float tempoHoras){ // empregado regista os tempos que dedicou à tarefa
        tempoEfetivoHoras = tempoHoras + tempoEfetivoHoras;
    }
}
