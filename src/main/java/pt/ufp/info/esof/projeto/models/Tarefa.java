package pt.ufp.info.esof.projeto.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class,scope = Projeto.class)
public class Tarefa {
  @Id
  private long id;

  private String nome;
  private int duracao;

  @ManyToOne
  private Funcionario funcionario;
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