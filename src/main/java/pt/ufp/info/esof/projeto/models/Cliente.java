package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
  private List<Projeto> projetos = new ArrayList<>();

  public void criaProjeto(String nome){
    Projeto p = new Projeto();
    p.setNome(nome);
    if(!projetos.contains(p)){
      projetos.add(p);
    }
  }
}