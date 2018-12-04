package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    private long id;
    private String firstname;
    private String lastname;
    private Date created;
    private List<Loan> loans = new ArrayList<>();

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(long id, String firstname, String lastname, Date created) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.created = created;
    }

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
    public Date getCreated() {
        return created;
    }

    @OneToMany(
            targetEntity = Loan.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Loan> getLoans() {
        return loans;
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

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
