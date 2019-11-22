package com.cn.nba.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.text.Collator;
import java.util.Comparator;
import java.util.Date;

public class Team {


    private int id;

    @NotNull(message = "name不可以为空")
    private String name;

    private int area;

    private int east;

    private String city;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static Comparator<Team> sortHotelName = new Comparator<Team>() {
        Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
        @Override
        public int compare(Team o1, Team o2) {
            return cmp.compare(o1.getName()==null?"":o1.getName(), o2.getName()==null?"":o2.getName());
        }
    };


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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String toString() {
        return "area=" + area + "," + "city=" + city;

    }

}
