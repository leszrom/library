package com.crud.library.domain;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Entity(name = "loans")
public class Loan {
    private long id;
    private User user;
    private Volume volume;
    private LocalDate pickUp;
    private LocalDate dropOff;

    public Loan(User user, Volume volume) {
        this.user = user;
        this.volume = volume;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return this.user;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "volume_id")
    public Volume getVolume() {
        return this.volume;
    }


    @CreatedDate
    @Column(name = "pick_up_date")
    public LocalDate getPickUp() {
        return this.pickUp;
    }

    @LastModifiedDate
    @Column(name = "drop_off_date")
    public LocalDate getDropOff() {
        return this.dropOff;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public void setPickUp(LocalDate pickUp) {
        this.pickUp = pickUp;
    }

    public void setDropOff(LocalDate dropOff) {
        this.dropOff = dropOff;
    }
}
