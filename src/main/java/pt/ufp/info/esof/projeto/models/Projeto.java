package pt.ufp.info.esof.projeto.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class, scope = Projeto.class)
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    private enum EstadosProjeto {
        Concluido,
        NaoConluido,
    }

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<Tarefa> tarefas = new ArrayList<>();
    @ManyToOne
    private Cliente cliente;

    public void adicionarTarefas(Tarefa t) {
        if (!tarefas.contains(t)) {
            tarefas.add(t);
            t.setProjeto(this);
        }
    }

    private float custoPrevistoProjeto() {
        float custo = 0;
        for (Tarefa t : this.tarefas) {
            custo = custo + t.custoPrevistoTarefa();
        }
        return custo;
    }

    private float custoEfetivoProjeto() {
        float custo = 0;
        for (Tarefa t : this.tarefas) {
            custo = custo + t.custoEfetivoTarefa();
        }
        return custo;
    }

    private float duracaoPrevistaHoras() {
        float duracao = 0;
        for (Tarefa t : this.tarefas) {
            duracao = duracao + t.getTempoPrevisto().getTempoPrevistoHoras();
        }
        return duracao;
    }

    private float duracaoEfetivaHoras() {
        float duracao = 0;
        for (Tarefa t : this.tarefas) {
            duracao = duracao + t.getTempoEfetivo().getTempoEfetivoHoras();
        }
        return duracao;
    }

    public int percentagemConclusao() {
        return (int) (( this.duracaoEfetivaHoras()/this.duracaoPrevistaHoras()) * 100);
    }

    public EstadosProjeto estadoDoProjeto() {
        for (Tarefa t : this.tarefas) {
            if (!t.registaConclusaoTarefa()) {
                return EstadosProjeto.NaoConluido;
            }
        }
        return EstadosProjeto.Concluido;
    }

    public void mostrarProgresso(){
        System.out.println(this);
        System.out.println("Projeto "+this.estadoDoProjeto()+" com "+this.percentagemConclusao()+"%");

//        tarefas.stream().map(Tarefa::getNome).collect(Collectors.toList());
        for (Tarefa t:this.getTarefas()) {
            System.out.println(t);
        }
    }

}
