package com.crud.library.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity(name = "books")
public class Book {
    private long id;
    private String title;
    private String author;
    private int publicationYear;
    private List<Volume> volumes = new ArrayList<>();

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book(long id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }

    @Column
    public String getTitle() {
        return this.title;
    }

    @Column
    public String getAuthor() {
        return this.author;
    }

    @Column(name = "publication_year")
    public int getPublicationYear() {
        return this.publicationYear;
    }

    @OneToMany(
            targetEntity = Volume.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Volume> getVolumes() {
        return volumes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }
}
