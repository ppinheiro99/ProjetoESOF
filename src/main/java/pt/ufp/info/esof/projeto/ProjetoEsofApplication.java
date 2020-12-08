package pt.ufp.info.esof.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pt.ufp.info.esof.projeto.models.Cargo;
import pt.ufp.info.esof.projeto.models.Empregado;

@SpringBootApplication
public class ProjetoEsofApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoEsofApplication.class, args);
    }
}
