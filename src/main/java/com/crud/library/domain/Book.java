package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "books")
public class Book {
    private long id;
    private String title;
    private String author;
    private LocalDate published;
    private List<Volume> volumes = new ArrayList<>();

    public Book(String title, String author, LocalDate published) {
        this.title = title;
        this.author = author;
        this.published = published;
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

    @Column(name = "publication_date")
    public LocalDate getPublished() {
        return this.published;
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

    public void setPublished(LocalDate published) {
        this.published = published;
    }

    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }
}
