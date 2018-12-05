package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "loans")
public class Loan {
    private long id;
    private User user;
    private Volume volume;
    private Date pickUp;
    private Date dropOff;

    public Loan(User user, Volume volume) {
        this.user = user;
        this.volume = volume;
        this.pickUp = new Date();
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

    @Column(name = "pick_up_date")
    public Date getPickUp() {
        return this.pickUp;
    }

    @Column(name = "drop_off_date")
    public Date getDropOff() {
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

    public void setPickUp(Date pickUp) {
        this.pickUp = pickUp;
    }

    public void setDropOff(Date dropOff) {
        this.dropOff = dropOff;
    }
}
