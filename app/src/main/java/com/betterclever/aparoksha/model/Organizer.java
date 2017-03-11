package com.betterclever.aparoksha.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Organizer {
    
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    
    /**
     * No args constructor for use in serialization
     *
     */
    public Organizer() {
    }
    
    /**
     *
     * @param phone
     * @param name
     */
    public Organizer(String name, String phone) {
        super();
        this.name = name;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}