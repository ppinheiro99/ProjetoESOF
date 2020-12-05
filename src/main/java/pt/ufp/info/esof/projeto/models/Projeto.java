package pt.ufp.info.esof.projeto.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class,scope = Projeto.class)
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private enum estadosProjeto{ // Nao sei se é bem isto ( provavelmente nao )
        Concluido,
        NaoConluido,
    }
    @OneToMany(mappedBy = "projeto",cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();
    @ManyToOne
    private Cliente cliente;

    public estadosProjeto estadoDoProjeto(){ // vai ser um enum
        for (Tarefa t:this.tarefas) {
            if(!t.registaConclusaoTarefa()){
                return estadosProjeto.NaoConluido;
            }
        }
        return estadosProjeto.Concluido;
    }

    public float custoPrevistoProjeto(){
        float custo = 0;
        for (Tarefa t:this.tarefas) {
            custo = custo + t.custoPrevistoTarefa();
        }
        return custo;
    }
    public float custoEfetivoProjeto(){
        float custo = 0;
        for (Tarefa t:this.tarefas) {
            custo = custo + t.custoEfetivoTarefa();
        }
        return custo;
    }

    public  float duracaoPrevistaHoras(){
        float duracao = 0;
        for (Tarefa t:this.tarefas) {
            duracao = duracao + t.getTempoPrevisto().getTempoPrevistoHoras();
        }
        return duracao;
    }

    public  float duracaoEfetivaHoras(){
        float duracao = 0;
        for (Tarefa t:this.tarefas) {
            duracao = duracao + t.getTempoEfetivo().getTempoEfetivoHoras();
        }
        return duracao;
    }
}