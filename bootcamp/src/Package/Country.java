package Package;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class Country {
    //Attributes
    private String name;
    private String countryCode2;
    private String countryCode3;
    private List<State> listOfStates;

    //Constructors
    public Country ()
    {}
    public Country(String name, String countryCode2, String countryCode3)
    {
        this.name = name;
        this.countryCode2 = countryCode2;
        this.countryCode3 = countryCode3;
        listOfStates = new ArrayList<State>();
    }
    // Getters and Setters methods
    public String getName()
    {
        return this.name;
    }
    public String getCountryCode2()
    {
        return this.countryCode2;
    }
    public String getCountryCode3()
    {
        return countryCode3;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setCountryCode2(String countryCode2)
    {
        this.countryCode2 = countryCode2;
    }
    public void setCountryCode3(String countryCode3)
    {
        this.countryCode3 = countryCode3;
    }

    public List<State> getListOfStates() {
        return listOfStates;
    }

    //Methods
    public boolean addState(State s)
    {
        listOfStates.add(s);
        return true;

    }
    public State getState(String name)
    {
        for (State S : listOfStates)
        {
            if (S.getName().equalsIgnoreCase(name))
                return  S;

        }
        return null;
    }

    public String toString() {
        String states = "";
        for (State S : listOfStates)
        {
            states +=S.getName()+"\n";
        }
        return "Country information: { " +
                "name='" + name + '\'' +
                ", countryCode2='" + countryCode2 + '\'' +
                ", countryCode3='" + countryCode3 + '\'' +
                '}'+"\n"+
                "\nlist Of States: \n" + states;
    }
}
