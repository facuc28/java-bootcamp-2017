package com.bootcamp.java.Domain;

import com.bootcamp.java.Builder.WindBuilder;
import com.bootcamp.java.Configuration.DataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.*;
import java.sql.ResultSet;

/**
 * Created by facun on 16/01/2017.
 */
@Entity
@Table(name = "wind")
public class Wind {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_wind;
    private int speed;
    private int direction;

    public Wind(){}

    public Wind(int speed, int direction) {

        this.id_wind = id_wind;
        this.speed = speed;
        this.direction = direction;
    }

    public Wind(WindBuilder builder)
    {
        this.speed = builder.speed;
        this.direction = builder.direction;
    }
    public int getId_wind() {
        return id_wind;
    }

    public void setId_wind(int id_wind) {
        this.id_wind = id_wind;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
    /*
    private int getLastID()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataBase DB = applicationContext.getBean("dataBase", DataBase.class);
        String sql = "SELECT id_wind FROM bootcamp2.wind";
        ResultSet result = DB.DBRequest(sql);
        boolean flag;
        int mayor=0;
        try {
            while(result.next())
            {
                if (flag=false)
                {
                    mayor = result.getInt("id_wind");
                    flag = true;
                }
                if (result.getInt("id_wind")>mayor)
                {
                    mayor = result.getInt("id_wind");
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
        return "Wind{" +
                "id_wind=" + id_wind +
                ", speed=" + speed +
                ", direction=" + direction +
                '}';
    }
}
