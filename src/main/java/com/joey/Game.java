package com.joey;

import java.math.BigDecimal;

public class Game {
    private String title, description;
    private int releaseYear, id;
    private BigDecimal price;


    //Constructor(s)
    public Game(int id, String title, String description, int releaseYear, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.price = price;
    }


    //Instance Methods
    @Override public String toString() {
        return String.format("\n===============\n   ID: %d\n   Title: \"%s\"\n   Description: \"%s\"\n   Release Year: %d\n   Price: $%.2f", this.getId(), this.getTitle(), this.getDescription(), this.getReleaseYear(), this.getPrice());
    }


    //Getter Methods
    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getReleaseYear() {
        return this.releaseYear;
    }

    public int getId() {
        return this.id;
    }

    public BigDecimal getPrice() {
        return this.price;
    }


    //Setter Methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}