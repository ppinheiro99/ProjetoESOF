package pt.ufp.info.esof.projeto.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(property = "id", generator = ObjectIdGenerators.PropertyGenerator.class,scope = Projeto.class)
public enum Cargo {
    desenvolvedorJunior(10),
    analistaJunior(20),
    desenvolvedorSenior(40),
    analistaSenior(80),
    ;
    public final int valorHora;
    Cargo(int valorHora){
        this.valorHora = valorHora;
    }
}
