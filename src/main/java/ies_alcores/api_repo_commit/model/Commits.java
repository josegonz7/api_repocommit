package ies_alcores.api_repo_commit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity

public class Commits {
    @Id
    private long id_commit;
    private String hash;
    private String mensaje;
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_repo")
    @JsonIgnoreProperties("commits")
    private Repositorios repositorios;

}