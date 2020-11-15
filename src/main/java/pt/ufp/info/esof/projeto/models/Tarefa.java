package pt.ufp.info.esof.projeto.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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