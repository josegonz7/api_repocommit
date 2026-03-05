package ies_alcores.api_repo_commit.controller;

import ies_alcores.api_repo_commit.model.Commits;
import ies_alcores.api_repo_commit.service.CommitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/commits")
public class CommitsController {

    @Autowired
    private CommitsService commitsService;

    @GetMapping
    public List<Commits> findAll(){
        return this.commitsService.findAll();
    }
}
