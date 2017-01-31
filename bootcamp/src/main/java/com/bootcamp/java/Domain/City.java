package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CityBuilder;
import com.bootcamp.java.Configuration.DataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.*;
import java.sql.ResultSet;

/**
 * Created by facun on 16/01/2017.
 */
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_city;
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_state")
    private State state;

    public City(){}
    public City(String name, State state) {
        this.name = name;
       this.state = state;
    }

    public City(CityBuilder builder)
    {
        this.name = builder.name;
        this.state = builder.state;
    }
    public int getId_city() {
        return id_city;
    }

    public void setId_city(int id_city) {
        this.id_city = id_city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" +
                "id_city=" + id_city +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
