package ies_alcores.api_repo_commit.controller;

import ies_alcores.api_repo_commit.model.Commits;
import ies_alcores.api_repo_commit.repository.CommitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commits")
public class CommitsController {

    @Autowired
    private CommitsRepository repository;

    @PostMapping("/crear_nuevo")
    public Commits guardar(@RequestBody Commits nuevoCommit) {
        return repository.save(nuevoCommit);
    }

    @GetMapping("/buscar_por_texto/{texto}")
    public List<Commits> buscarMensaje(@PathVariable String texto) {
        return repository.buscarPorMensaje(texto);
    }

    @GetMapping("/ver_del_repositorio/{nombre}")
    public List<Commits> buscarRepo(@PathVariable String nombre) {
        return repository.buscarPorNombreRepo(nombre);
    }

    @GetMapping("/estadisticas/total-en-repo/{id}")
    public Long contar(@PathVariable Long id) {
        return repository.contarCommitsPorRepo(id);
    }

    @DeleteMapping("/eliminar_por_hash/{hash}")
    public ResponseEntity<String> borrar(@PathVariable String hash) {
        repository.borrarPorHash(hash);
        return ResponseEntity.ok("Eliminado correctamente el commit con hash: " + hash);
    }
}