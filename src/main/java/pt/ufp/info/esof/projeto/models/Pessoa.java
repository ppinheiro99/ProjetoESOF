package pt.ufp.info.esof.projeto.models;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Pessoa {
  @Id
  private long id;
  private String nome;

}