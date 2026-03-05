package ies_alcores.api_repo_commit.controller;


import ies_alcores.api_repo_commit.model.Repositorios;
import ies_alcores.api_repo_commit.service.RepositoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/repos")
public class RepositoriosController {

    @Autowired
    private RepositoriosService service;

    @GetMapping
    public ResponseEntity<List<Repositorios>> listar() {
        return ResponseEntity.ok(this.service.findAll());
    }
}
