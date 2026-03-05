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

    // 1. POST - Ahora se llamará "/crear-nuevo"
    @PostMapping("/crear_nuevo")
    public Commits guardar(@RequestBody Commits nuevoCommit) {
        return repository.save(nuevoCommit);
    }

    // 2. CONSULTA 1 - Buscar por mensaje: "/buscar-por-texto/{texto}"
    @GetMapping("/buscar_por_texto/{texto}")
    public List<Commits> buscarMensaje(@PathVariable String texto) {
        return repository.buscarPorMensaje(texto);
    }

    // 3. CONSULTA 2 - Por nombre de repo: "/ver-del-repositorio/{nombre}"
    @GetMapping("/ver_del_repositorio/{nombre}")
    public List<Commits> buscarRepo(@PathVariable String nombre) {
        return repository.buscarPorNombreRepo(nombre);
    }

    // 4. CONSULTA 3 - Conteo: "/estadisticas/total-en-repo/{id}"
    @GetMapping("/estadisticas/total-en-repo/{id}")
    public Long contar(@PathVariable Long id) {
        return repository.contarCommitsPorRepo(id);
    }

    // 5. DELETE - Borrar: "/eliminar-por-hash/{hash}"
    @DeleteMapping("/eliminar_por_hash/{hash}")
    public ResponseEntity<String> borrar(@PathVariable String hash) {
        repository.borrarPorHash(hash);
        return ResponseEntity.ok("Eliminado correctamente el commit con hash: " + hash);
    }
}