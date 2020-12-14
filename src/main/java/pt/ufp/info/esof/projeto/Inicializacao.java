package pt.ufp.info.esof.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pt.ufp.info.esof.projeto.models.*;
import pt.ufp.info.esof.projeto.repositories.*;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    private final ClienteRepository clienteRepository;
    private final EmpregadoRepository empregadoRepository;
    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;
    private final TempoEfetivoRepository tempoEfetivoRepository;
    private final TempoPrevistoRepository tempoPrevistoRepository;

    @Autowired
    public Inicializacao(ClienteRepository clienteRepository, EmpregadoRepository empregadoRepository, ProjetoRepository projetoRepository, TarefaRepository tarefaRepository, TempoEfetivoRepository tempoEfetivoRepository, TempoPrevistoRepository tempoPrevistoRepository) {
        this.clienteRepository = clienteRepository;
        this.empregadoRepository = empregadoRepository;
        this.projetoRepository = projetoRepository;
        this.tarefaRepository = tarefaRepository;
        this.tempoEfetivoRepository = tempoEfetivoRepository;
        this.tempoPrevistoRepository = tempoPrevistoRepository;
    }

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

        TempoPrevisto tprevisto = new TempoPrevisto(); // esta classe nao está a fazer nada (discutir se vamos ou nao tirá-la)
        tprevisto.setTempoPrevistoHoras(8);
        tprevisto.setTarefa(t1);
        //tempoPrevistoRepository.save(tprevisto);

        TempoEfetivo tefetivo = new TempoEfetivo();
        tefetivo.setTempoEfetivoHoras(3);
        tefetivo.setTarefa(t1);
        //tempoEfetivoRepository.save(tefetivo);

        t1.setTempoEfetivo(tefetivo);
        t1.setTempoPrevisto(tprevisto);

        p1.setCliente(c1); // associa projeto ao cliente
        c1.getProjetos().add(p1); // associa cliente ao projeto
        p1.adicionarTarefas(t1); // associa o projeto à tarefa e vice-versa
        //this.projetoRepository.save(p1);

        t1.setEmpregado(e1); // associa tarefa ao empregado
        e1.getTarefas().add(t1); // associa empregado à tarefa
        //this.tarefaRepository.save(t1);

        System.out.println("\n" + "valorHora: "+ e1.valorHora()+"\n");
        /*
            Projeto p = new Projeto();
            Tarefa t = new Tarefa();
            t.setNome("tarefa1");
            p.getTarefas().add(t);
            System.out.println( p.estadoDoProjeto());

            System.out.println(p);
       */

        c1.getProjetos().get(0).mostrarProgresso();
    }
}
