package com.bootcamp.java.Domain;

        import java.util.ArrayList;
        import java.util.List;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @RequestMapping(value = "/countries", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Country2> getCountries()
    {
        List<Country2> listOfCountries = new ArrayList<Country2>();
        listOfCountries=createCountryList();
        return listOfCountries;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")
    public Country2 getCountryById(@PathVariable int id)
    {
        List<Country2> listOfCountries = new ArrayList<Country2>();
        listOfCountries=createCountryList();

        for (Country2 country2: listOfCountries) {
            if(country2.getId()==id)
                return country2;
        }

        return null;
    }

    // Utiliy method to create country list.
    public List<Country2> createCountryList()
    {
        Country2 indiaCountry=new Country2(1, "India");
        Country2 chinaCountry=new Country2(4, "China");
        Country2 nepalCountry=new Country2(3, "Nepal");
        Country2 bhutanCountry=new Country2(2, "Bhutan");

        List<Country2> listOfCountries = new ArrayList<Country2>();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(chinaCountry);
        listOfCountries.add(nepalCountry);
        listOfCountries.add(bhutanCountry);
        return listOfCountries;
    }
}
