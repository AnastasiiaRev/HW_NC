package com.revutska.model;

import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Post {
    private static DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private int id;
    private Date dateOfCreation;
    private String text;

    public Post() {
    }

    public Post(int id, String dateOfCreation, String text) {
        try {
            this.dateOfCreation = format.parse(dateOfCreation);
        } catch (ParseException e) {
            this.dateOfCreation = null;
        }
        this.id = id;
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfCreation(String dateOfCreation) {
        try {
            this.dateOfCreation = format.parse(dateOfCreation);
        } catch (ParseException e) {
            this.dateOfCreation = null;
        }
    }

    public void setText(String text) {
        this.text = text;
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
