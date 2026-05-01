package br.com.fiap.toytrack.controller;

import br.com.fiap.toytrack.model.Brinquedo;
import br.com.fiap.toytrack.service.BrinquedoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    private final BrinquedoService brinquedoService;

    public BrinquedoController(BrinquedoService brinquedoService) {
        this.brinquedoService = brinquedoService;
    }

    @GetMapping
    public ResponseEntity<List<Brinquedo>> listarTodos() {
        return ResponseEntity.ok(brinquedoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> buscarPorId(
            @PathVariable Long id
    ) {
        return brinquedoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Brinquedo> criar(
            @RequestBody Brinquedo brinquedo
    ) {
        Brinquedo salvo = brinquedoService.salvar(brinquedo);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brinquedo> atualizar(
            @PathVariable Long id,
            @RequestBody Brinquedo brinquedo
    ) {
        return brinquedoService
                .atualizar(id, brinquedo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {
        if (brinquedoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
