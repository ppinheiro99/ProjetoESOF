package pt.ufp.info.esof.projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pt.ufp.info.esof.projeto.models.Empregado;
import pt.ufp.info.esof.projeto.repositories.EmpregadoRepository;

import java.util.Optional;

@Controller
@RequestMapping("/empregado")
public class EmpregadoController {
    private final EmpregadoRepository empregadoRepository;
    @Autowired
    public EmpregadoController(EmpregadoRepository empregadoRepository) {
        this.empregadoRepository = empregadoRepository;
    }
    // retorno uma resposta com o código 200 (responsiveEntity.ok)
    @GetMapping()
    public ResponseEntity<Iterable<Empregado>> getAllEmpregados(){
        return ResponseEntity.ok(empregadoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empregado> getEmpregadoById(@PathVariable Long id){
        Optional<Empregado> optionalEmpregado = empregadoRepository.findById(id);
        if(optionalEmpregado.isPresent()){
            Empregado empregado = optionalEmpregado.get();
            return ResponseEntity.ok(empregado);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Empregado> createEmpregado(@RequestBody Empregado empregado){
        if(empregadoRepository.findById(empregado.getId())==null){
            return ResponseEntity.ok(empregadoRepository.save(empregado));
        }
        return ResponseEntity.badRequest().build();
    }
}
