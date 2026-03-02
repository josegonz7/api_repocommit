package ies_alcores.api_repo_commit.service;


import ies_alcores.api_repo_commit.model.Commits;
import ies_alcores.api_repo_commit.repository.CommitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitsService {

    @Autowired
    private CommitsRepository commitRepository;

    public List<Commits> findAll(){
        return this.commitRepository.findAll();
    }
}