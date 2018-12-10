package com.crud.library.domain;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    private long id;
    private String firstname;
    private String lastname;
    private LocalDateTime created;
    private List<Loan> loans = new ArrayList<>();

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
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

    @CreatedDate
    @Column(name = "created_date")
    public LocalDateTime getCreated() {
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
