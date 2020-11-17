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
  private int duracaoHoras;
  @ManyToOne
  private Funcionario funcionario;
  @ManyToOne
  private Projeto projeto;

}