package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
@Getter
@Setter
public class Tarefa {
  @Id
  private long id;
  private String nome;
  private int duracao;
  @ManyToOne
  private Funcionario funcionario;
  @ManyToOne
  private Projeto projeto;

}