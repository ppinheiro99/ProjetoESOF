package pt.ufp.info.esof.projeto.models;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {

    public Cargo cargo;
    public List<Tarefa> tarefas = new ArrayList<>();

}

