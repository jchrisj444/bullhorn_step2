package com.jchrisj444.bullhorn_step2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Messagepost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(max = 280)
    private String content;

    @NotNull
    @Size(min = 10, max = 10)
    private String posteddate;

    @NotNull
    @Size(min = 2, max = 255)
    private String sentby;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPosteddate() {
        return posteddate;
    }

    public void setPosteddate(String posteddate) {
        this.posteddate = posteddate;
    }

    public String getSentby() {
        return sentby;
    }

    public void setSentby(String sentby) {
        this.sentby = sentby;
    }
}
