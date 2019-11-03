package com.revutska.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Comparable<Comment> {
    private static DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_of_creation")
    private Date dateOfCreation;
    @Column(name = "creator_name")
    private String creatorName;
    @Column(name = "comment_text")
    private String text;
    @Column(name = "post_id")
    private Integer postId;

    public Comment() {
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "{" +
                " id=" + id +
                "; dateOfCreation=" + dateOfCreation +
                "; creatorName=" + creatorName +
                "; text=" + text +
                "; }";
    }

    @Override
    public int compareTo(Comment comment2) {
        if (getDateOfCreation() == null || comment2.getDateOfCreation() == null)
            return -1;
        if (getDateOfCreation().before(comment2.getDateOfCreation()))
            return 1;
        if (getDateOfCreation().after(comment2.getDateOfCreation()))
            return -1;
        return 0;
    }
}
