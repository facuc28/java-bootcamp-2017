package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.StateBuilder;

import javax.persistence.*;


/**
 * Created by facun on 16/01/2017.
 */
@Entity
@Table(name = "state")
public class State {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
        private int id_state;
       @ManyToOne
       @JoinColumn(name = "id_country")
        private Country country;
        private String name;
        private long area;
        private String countryCode3;
        private String capital;
        @Column(length = 2)
        private String abbrev;

        public State(){}

    public State(Country country, String name, long area, String capital, String abbrev, String countryCode3) {
       this.country = country;
       this.countryCode3 = countryCode3;
        this.name = name;
        this.area = area;
        this.capital = capital;
        this.abbrev = abbrev;
    }

    public State(StateBuilder builder)
    {
        this.country = builder.country;
        this.name = builder.name;
        this.area = builder.area;
        this.capital =builder.capital;
        this.abbrev = builder.abbrev;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public int getId_state() {
        return id_state;
    }

    public void setId_state(int id_state) {
        this.id_state = id_state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev;
    }
/*

    private int getLastID()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataBase DB = applicationContext.getBean("dataBase", DataBase.class);
        String sql = "SELECT id_state FROM bootcamp2.state";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_state");
                    flag = true;
                }
                if (result.getInt("id_state")>mayor)
                {
                    mayor = result.getInt("id_state");
                }
            }
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return mayor;
    }
    */
    @Override
    public String toString() {
        return "State{" +
                "id_state=" + id_state +
                ", country_id=" + country +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", capital='" + capital + '\'' +
                ", abbrev='" + abbrev + '\'' +
                '}';
    }
}
