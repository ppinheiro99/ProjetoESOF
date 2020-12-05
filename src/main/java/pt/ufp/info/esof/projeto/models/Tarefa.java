package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

  public boolean registaConclusaoTarefa(){
    if(tempoEfetivo.getTempoEfetivoHoras() == tempoPrevisto.getTempoPrevistoHoras()){
      return true;
    }
    return false;
  }
  public float custoPrevistoTarefa(){
    return empregado.valorHora()*tempoPrevisto.getTempoPrevistoHoras();
  }
  public float custoEfetivoTarefa(){
    return tempoPrevisto.getTempoPrevistoHoras() * empregado.valorHora();
  }
}