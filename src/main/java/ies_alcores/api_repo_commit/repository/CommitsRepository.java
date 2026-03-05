package ies_alcores.api_repo_commit.repository;

import ies_alcores.api_repo_commit.model.Commits;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommitsRepository extends JpaRepository<Commits, Long> {

    // CONSULTA 1: Buscar commits por palabra clave en el mensaje
    @Query("SELECT c FROM Commits c WHERE c.mensaje LIKE %:palabra%")
    List<Commits> buscarPorMensaje(String palabra);

    // CONSULTA 2: Buscar todos los commits de un repositorio por su NOMBRE
    @Query("SELECT c FROM Commits c WHERE c.repositorios.nombre = :nombreRepo")
    List<Commits> buscarPorNombreRepo(String nombreRepo);

    // CONSULTA 3: Contar cuántos commits tiene un repositorio por su ID
    @Query("SELECT COUNT(c) FROM Commits c WHERE c.repositorios.id_repo = :idRepo")
    Long contarCommitsPorRepo(Long idRepo);

    // DELETE con @Query: Borrar un commit por su HASH
    @Transactional
    @Modifying
    @Query("DELETE FROM Commits c WHERE c.hash = :hash")
    void borrarPorHash(String hash);
}