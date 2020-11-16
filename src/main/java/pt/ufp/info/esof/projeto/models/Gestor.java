package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Getter
@Setter
public class Gestor extends Funcionario {
    @OneToMany(mappedBy = "gestor",cascade = CascadeType.ALL)
    private List<Projeto> projetos = new ArrayList<>();

    public void definirPrazo(Projeto p,Date d){
        if(projetos.contains(p)){
            p.setDuracao(d);
        }
    }
    public void adicionarTarefa(){ //

    }
}
