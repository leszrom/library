package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "loans")
public class Loan {
    private long id;
    private User user;
    private Volume volume;
    private LocalDate pickUp;
    private LocalDate dropOff;

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "volume_id")
    public Volume getVolume() {
        return this.volume;
    }

    @Column(name = "pick_up_date")
    public LocalDate getPickUp() {
        return this.pickUp;
    }

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
