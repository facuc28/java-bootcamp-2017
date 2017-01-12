package Package;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class State extends Country {
    private String abbr;
    private long area;
    private String capital;
    private List<City> listOfCities;
    //Constructor
    public State ()
    {

    }
    //Constructor with parameters

    public State(String abbr, long area, String capital, List<City> listOfCities) {
        this.abbr = abbr;
        this.area = area;
        this.capital = capital;
        this.listOfCities = listOfCities;
    }

    public State(String name, String countryCode2, String countryCode3, String abbr, long area, String capital, List<City> listOfCities) {
        super(name, countryCode2, countryCode3);
        this.abbr = abbr;
        this.area = area;
        this.capital = capital;
        this.listOfCities = listOfCities;
    }

    public String getName() {
        return super.getName();
    }

    public String getAbbr() {
        return abbr;
    }

    public long getArea() {
        return area;
    }

    public String getCapital() {
        return capital;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }


   public void setCapital(String capital) {
        this.capital = capital;
    }

    //Methods
    public boolean addCity(City C)
    {
        listOfCities.add(C);
        return true;

    }
    public City getCity(String name)
    {
        for (City C : listOfCities)
        {
            if (C.getName().equalsIgnoreCase(name))
                return C;

        }
        return null;
    }

    public String toString() {
        String city="";
        for(City C : listOfCities)
        {
            city +="\n"+C.getName();
        }
        return "State { Name= " + super.getName() +", "+
                " Abbreviation ='" + abbr + '\'' +
                ", Area=" + area +
                ", Capital='" + capital + '\''+"}" +"\n"+
                "Ciudades: "+city;

    }
}
