package ies_alcores.api_repo_commit.service;

import ies_alcores.api_repo_commit.model.Repositorios;
import ies_alcores.api_repo_commit.repository.RepositoriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RepositoriosService {

    @Autowired
    private RepositoriosRepository repositorioRepository;

    public List<Repositorios> findAll(){
        return this.repositorioRepository.findAll();
    }
}
