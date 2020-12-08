package pt.ufp.info.esof.projeto.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class,scope = Projeto.class)
public class Cliente {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
  private List<Projeto> projetos = new ArrayList<>();


  public void consultarCustoProjeto(){
    int i = 0;
    while (i<projetos.size()){
      System.out.println(projetos.get(i).custoPrevistoProjeto());
      i++;
    }
  }

  public void consultarPrazoProjeto(){
    int i = 0;
    while (i<projetos.size()){
      System.out.println(projetos.get(i).duracaoPrevistaHoras() + "\n");
      i++;
    }
  }

  public void consultarEstadoProjeto(){
    int i = 0;
    while (i<projetos.size()){
      System.out.println(projetos.get(i).estadoDoProjeto());
      i++;
    }
  }


}