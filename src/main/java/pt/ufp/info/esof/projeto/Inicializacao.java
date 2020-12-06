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

        Projeto p1 = new Projeto();
        p1.setNome("ESOF");

        Cliente c1 = new Cliente();
        c1.setNome("Armando");
        this.clienteRepository.save(c1);

        Empregado e1 = new Empregado();
        e1.setNome("Pedro");
        e1.setCargo(Cargo.desenvolvedorSenior);
        this.empregadoRepository.save(e1);

        Tarefa t1 = new Tarefa();
        t1.setNome("Tarefa1");

//        TempoPrevisto tprevisto = new TempoPrevisto(); // esta classe nao está a fazer nada (discutir se vamos ou nao tirá-la)
//        tprevisto.setTempoPrevistoHoras(8);
//        tprevisto.setTarefa(t1);
//
//        TempoEfetivo tefetivo = new TempoEfetivo();
//        tefetivo.setTempoEfetivoHoras(3);
//        tefetivo.setTarefa(t1);
//
//        t1.setTempoEfetivo(tefetivo);
//        t1.setTempoPrevisto(tprevisto);

        p1.setCliente(c1); // associa projeto ao cliente
        c1.getProjetos().add(p1); // associa cliente ao projeto
        this.projetoRepository.save(p1);

        p1.adicionarTarefas(t1); // associa o projeto à tarefa e vice-versa
        t1.setEmpregado(e1); // associa tarefa ao empregado
        e1.getTarefas().add(t1); // associa empregado à tarefa
        this.tarefaRepository.save(t1);

        System.out.println("\n" + "valorHora: "+ e1.valorHora()+"\n");
    }
}
