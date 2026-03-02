package ies_alcores.api_repo_commit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity

public class Repositorios {
    @Id
    private long id_repo;
    private String nombre;
    private String lenguaje;
    private Date url;

}