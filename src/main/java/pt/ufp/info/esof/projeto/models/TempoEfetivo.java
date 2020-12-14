package pt.ufp.info.esof.projeto.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class,scope = Projeto.class)
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
