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
    private boolean isRented;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }
    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return this.book;
    }

    @Column(name = "status")
    public boolean isRented() {
        return this.isRented;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setRented(boolean isRented) {
        this.isRented = isRented;
    }
}
