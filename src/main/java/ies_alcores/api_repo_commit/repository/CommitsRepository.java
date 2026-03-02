package ies_alcores.api_repo_commit.repository;

import ies_alcores.api_repo_commit.model.Commits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitsRepository extends JpaRepository<Commits, String> {

}

