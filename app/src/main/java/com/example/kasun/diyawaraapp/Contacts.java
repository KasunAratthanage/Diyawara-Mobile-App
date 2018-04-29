package com.example.kasun.diyawaraapp;

/**
 * Created by Kasun on 8/11/2016.
 */
public class Contacts {


    private String location,waterlevel,velocity,anyotherdata,imergency;

    public Contacts(String location,String waterlevel,String velocity,String anyotherdata,String imergency)
    {
        this.setLocation(location);
        this.setWaterlevel(waterlevel);
        this.setVelocity(velocity);
        this.setAnyotherdata(anyotherdata);
        this.setImergency(imergency);
    }

    public String getImergency() {
        return imergency;
    }

    public void setImergency(String imergency) {
        this.imergency = imergency;
    }

    public String getAnyotherdata() {
        return anyotherdata;
    }

    public void setAnyotherdata(String anyotherdata) {
        this.anyotherdata = anyotherdata;
    }

    public String getVelocity() {
        return velocity;
    }

    public void setVelocity(String velocity) {
        this.velocity = velocity;
    }

    public String getWaterlevel() {
        return waterlevel;
    }

    public void setWaterlevel(String waterlevel) {
        this.waterlevel = waterlevel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
