package com.earthquake.demo.Enity;

import java.util.List;

/**
 * @author PA
 * @version 2021.2.1
 */

public class Observatory {
    private int id_o;//观测台编号
    private String name;//观测台名字
    private String country;//所在国家
    private String year;//开始观测时间

    public int getId() {
        return id_o;
    }

    public void setId(int id_o) {
        this.id_o = id_o;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Observatory{" +
                "id_o=" + id_o +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
