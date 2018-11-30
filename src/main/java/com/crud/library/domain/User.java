package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDate created;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "first_name")
    public String getFirstname() {
        return firstname;
    }

    @Column(name = "last_name")
    public String getLastname() {
        return lastname;
    }

    @Column(name = "creation_date")
    public LocalDate getCreated() {
        return created;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
