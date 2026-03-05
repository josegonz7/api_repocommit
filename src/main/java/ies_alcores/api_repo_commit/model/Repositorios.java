package ies_alcores.api_repo_commit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Collection;

@Data
@Entity

public class Repositorios {
    @Id
    private long id_repo;
    private String nombre;
    private String lenguaje;
    private String url;

    @OneToMany(mappedBy = "repositorios")
    private Collection<Commits> commits;
}