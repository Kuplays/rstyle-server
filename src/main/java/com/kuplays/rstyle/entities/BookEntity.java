package com.kuplays.rstyle.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
BookEntity class to represent a table
within H2 database
 */
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String authorName;
    private int yearRead;
    private String type;

    /*
    Default constructor to initialize
    repository
     */
    public BookEntity() {}

    /*
    Sets a new object of BookEntity to perform
    operations on books repository
    @param title book title
    @param authorName name of the author
    @param yearRead year current book has been read
    @param type type of the book (audio, e-book, regular book)
     */
    public BookEntity(String title, String authorName, int yearRead, String type) {
        this.title = title;
        this.authorName = authorName;
        this.yearRead = yearRead;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearRead() {
        return yearRead;
    }

    public void setYearRead(int yearRead) {
        this.yearRead = yearRead;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", yearRead=" + yearRead +
                ", type='" + type + '\'' +
                '}';
    }
}
