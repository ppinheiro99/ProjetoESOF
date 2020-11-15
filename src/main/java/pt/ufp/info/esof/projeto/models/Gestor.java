package pt.ufp.info.esof.projeto.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.Date;
@Entity
@Getter
@Setter
public class Gestor extends Funcionario {
    @OneToOne
    private Projeto projeto;
    public void definirPrazo(Date d){
        this.getProjeto().setDuracao(d);
    }
    public void adicionarTarefa(){ //

    }

}
