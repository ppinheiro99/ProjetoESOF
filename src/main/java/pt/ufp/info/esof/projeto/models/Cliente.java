package pt.ufp.info.esof.projeto.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Cliente {
  @Id
  private long id;
  private String nome;

  @OneToMany
  private List<Projeto> projetos = new ArrayList<>();

}