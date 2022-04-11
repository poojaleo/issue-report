package com.pooja.spring.issues.repositories;

import com.pooja.spring.issues.entities.IssueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IssueRepository extends JpaRepository<IssueReport, Long> {

    @Query(value = "SELECT i FROM IssueReport i WHERE markedAsPrivate = false")
    List<IssueReport> findAllButPrivate();


    List<IssueReport> findAllByEmail(String email);
}
