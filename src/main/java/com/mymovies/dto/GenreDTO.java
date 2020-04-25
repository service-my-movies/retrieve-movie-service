package com.mymovies.dto;

public class GenreDTO {

    // Attributs

    private int id;

    private String name;

    // Override toString

    @Override
    public String toString() {
        return "GenreDTO [id=" + id + ", name=" + name + "]";
    }

    // Constructor From SuperClass

    public GenreDTO() {
        super();
    }

    // Constructor Using Fields

    public GenreDTO(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}