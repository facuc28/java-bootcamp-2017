package Package;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by facun on 11/01/2017.
 */
public class World {

    private List<Country> countryList;

    public  World(){
        countryList = new ArrayList<Country>();
    }
    public World(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public Country searchCountry(String name)
    {
        for (Country C : countryList)
        {
            if (C.getName().equalsIgnoreCase(name))
                return C;
        }
        return null;
    }

    public boolean addCountry(Country C)
    {
        countryList.add(0,C);
        return true;
    }
}
