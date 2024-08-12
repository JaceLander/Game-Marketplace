package com.example.gamemarketplace;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String gameName;

    public int getImageID() {
        return imageID;
    }

    private String releaseDate;

    private String price;

    private List<String> tags = new ArrayList<>();

    private int imageID;

    private String description;


    public String getDescription() {
        return description;
    }

    public Game(String gameName, String releaseDate, String price, List<String> tags, int imageID) {
        this.gameName = gameName;
        this.releaseDate = releaseDate;
        this.price = price;
        this.tags = tags;
        this.imageID = imageID;
    }

    public String getGameName() {
        return gameName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPrice() {
        return price;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }


}

