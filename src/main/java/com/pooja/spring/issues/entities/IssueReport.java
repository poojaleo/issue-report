package com.pooja.spring.issues.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "issues")
public class IssueReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String url;
    private String description;
    private boolean markedAsPrivate;
    private boolean updates;
    private boolean done;
    private Date created;
    private Date updated;

    public IssueReport() {
    }
}
