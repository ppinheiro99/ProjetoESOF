package pt.ufp.info.esof.projeto.models;

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

