package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class Cargo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nome;
  private int valor;
  @OneToMany(mappedBy ="cargo",cascade = CascadeType.ALL) // persistência irá propagar (em cascata) todas as EntityManageroperações ( PERSIST, REMOVE, REFRESH, MERGE, DETACH) garante que as alteracoes que ocorrem no pai, sejam passados para o filho
  private List<Funcionario> funcionarios = new ArrayList<>();

}