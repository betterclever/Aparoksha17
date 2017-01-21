package com.betterclever.aparoksha.model;

import java.util.List;

public class Event {

    private String date;
    private String description;
    private String image;
    private String location;
    private String name;
    //private List<Organizer> organizers = null;
    private String time;
    private String type;

    public Event(){}

    public Event(String date, String description, String image, String location, String name, String time, String type) {
        this.date = date;
        this.description = description;
        this.image = image;
        this.location = location;
        this.name = name;
        //this.organizers = organizers;
        this.time = time;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    public List<Organizer> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(List<Organizer> organizers) {
        this.organizers = organizers;
    }*/

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}