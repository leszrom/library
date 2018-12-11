package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "volumes")
public class Volume {
    private long id;
    private Book book;
    private boolean rented;

    public Volume(Book book) {
        this.book = book;
    }

    @PrePersist
    private void initializeRented() {
        this.rented = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return this.book;
    }

    @Column(name = "is_rented")
    public boolean isRented() {
        return this.rented;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
