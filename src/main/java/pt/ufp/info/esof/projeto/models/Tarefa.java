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
public class Tarefa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  @ManyToOne
  private Empregado empregado;
  @ManyToOne
  private Projeto projeto;
  @OneToOne
  private TempoEfetivo tempoEfetivo;
  @OneToOne
  private TempoPrevisto tempoPrevisto;

  private boolean concluida;


  public boolean registaConclusaoTarefa(){
    return tempoEfetivo.getTempoEfetivoHoras() == tempoPrevisto.getTempoPrevistoHoras();
  }
  public float custoPrevistoTarefa(){
    return empregado.valorHora()*tempoPrevisto.getTempoPrevistoHoras();
  }
  public float custoEfetivoTarefa(){
    return tempoPrevisto.getTempoPrevistoHoras() * empregado.valorHora();
  }
  public int percentagemConclusao(){return (int)(tempoEfetivo.getTempoEfetivoHoras()/(tempoPrevisto.getTempoPrevistoHoras())*100);}


  public void conluir_tarefa(){this.concluida=true;}








}