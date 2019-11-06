package com.revutska.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_of_creation")
    private Date dateOfCreation;
    @Column(name = "creator_name")
    private String creatorName;
    @Column(name = "post_text")
    private String text;

    public Post() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public String getText() {
        return text;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Override
    public String toString() {
        return "{" +
                " id=" + id +
                "; dateOfCreation=" + dateOfCreation +
                "; text=" + text +
                "; }";
    }
}
