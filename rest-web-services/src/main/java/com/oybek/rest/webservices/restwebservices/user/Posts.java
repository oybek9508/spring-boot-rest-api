package com.oybek.rest.webservices.restwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Posts {
    @Id
    @GeneratedValue
    private  Integer id;

    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
private User user;
    protected Posts(){}
    public Posts(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
