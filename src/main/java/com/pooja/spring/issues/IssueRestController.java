package com.pooja.spring.issues;

import com.pooja.spring.issues.entities.IssueReport;
import com.pooja.spring.issues.repositories.IssueRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/issues")
public class IssueRestController {
    IssueRepository issueRepository;

    public IssueRestController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping
    public List<IssueReport> getIssues() {
        return this.issueRepository.findAllButPrivate();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueReport> getIssue(@PathVariable("id") long id) {
        Optional<IssueReport> optionalIssueReport = this.issueRepository.findById(id);
       if(!optionalIssueReport.isPresent()) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

       return new ResponseEntity<>(optionalIssueReport.get(), HttpStatus.OK);
    }
}
