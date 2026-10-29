package br.com.ordensservico.aberturaordenservico.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordensservico.aberturaordenservico.Service.SetorService;
import br.com.ordensservico.aberturaordenservico.model.Setor;

@RestController
@RequestMapping("/setores")
public class SetorController {

    private final SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @PostMapping
    public ResponseEntity<Setor> cadastrar(@RequestBody Setor setor) {
        Setor novoSetor = setorService.cadastrar(setor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoSetor);
    }

    @GetMapping
    public List<Setor> listar() {
        return setorService.listar();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Setor> atualizar(@PathVariable Integer id, @RequestBody Setor novosDados) {
        return setorService.atualizar(id, novosDados)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (setorService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}