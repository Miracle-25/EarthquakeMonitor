package com.earthquake.demo.Enity;

import java.util.Date;

/**
 * @author PA
 * @version 2021.2.1
 */

public class Earthquake {
    private int id;//地震编号
    private double magnitude;//震级
    private double latitude;//经度
    private double longitude;//纬度
    private String year;//时间
    private String ob_earth;//所在观测台

    public Earthquake(int id, double magnitude, double latitude, double longitude, String year, String ob_earth) {
        this.id = id;
        this.magnitude = magnitude;
        this.latitude = latitude;
        this.longitude = longitude;
        this.year = year;
        this.ob_earth = ob_earth;
    }

    public Earthquake(){
        System.out.println("<----------------------Earthqueke Successful running !---------------------->");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOb_earth() {
        return ob_earth;
    }

    public void setOb_earth(String ob_earth) {
        this.ob_earth = ob_earth;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "id=" + id +
                ", magnitude=" + magnitude +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", year='" + year + '\'' +
                ", ob_earth='" + ob_earth + '\'' +
                '}';
    }
}
