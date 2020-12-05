package pt.ufp.info.esof.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.info.esof.projeto.models.*;
import pt.ufp.info.esof.projeto.repositories.ClienteRepository;
import pt.ufp.info.esof.projeto.repositories.EmpregadoRepository;
import pt.ufp.info.esof.projeto.repositories.ProjetoRepository;
import pt.ufp.info.esof.projeto.repositories.TarefaRepository;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpregadoRepository empregadoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private TarefaRepository tarefaRepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("\n\n\nInicializou\n\n\n");
        Empregado e1 = new Empregado();
        e1.setNome("Pedro");
        e1.setCargo(Cargo.desenvolvedorJunior);
        System.out.println("\n" + "valorHora: "+ e1.valorHora()+"\n");
    }
}
