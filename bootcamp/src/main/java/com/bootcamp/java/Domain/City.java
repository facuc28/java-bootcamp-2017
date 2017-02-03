package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.CityBuilder;

import javax.persistence.*;

/**
 * Created by facun on 16/01/2017.
 */
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCity;
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
        this.idCity = builder.id_city;
        this.name = builder.name;
        this.state = builder.state;
    }
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
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
                "idCity=" + idCity +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}
