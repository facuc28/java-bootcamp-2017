package Package;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class Main {

    public static void main(String args[])
    {

        DataBase DB = new DataBase();
        if (DB.connect())
            System.out.println("\n"+"Connection to the database successful.");
        else
            System.out.println("Error while connecting to database.");


        //Objects
        Country C1 = new Country();
        State state0 = new State();
        City city;
        World W = new World();
        Weather weather = new Weather();
        List<City> listOfCities = new ArrayList<City>();

        //Auxiliary variables
        int optionMenu=0;
        Scanner sc = new Scanner(System.in);
        //Options Menu
        do {
            System.out.println("");
            System.out.println("------Options menu------");
            System.out.println("1- Create Country.");
            System.out.println("2- Create State.");
            System.out.println("3- Create City.");
            System.out.println("4- View Country info.");
            System.out.println("5- View State info.");
            System.out.println("6- View City info.");
            System.out.println("7- Load Weather for city");
            System.out.println("8- View Weather info for city.");
            System.out.println("9- Exit.");
            System.out.println("------------------------");

            System.out.print("Select an option: ");
            optionMenu = sc.nextInt();

        switch (optionMenu)
        {
            //Create Country
            case 1:
            {
                //Auxiliary variables
                String countryName;
                String countryCode2;
                String countryCode3;
                sc.nextLine();
                System.out.print("Input country name: ");
                countryName = sc.nextLine();
                System.out.print("Input country code 2 letters: ");
                countryCode2 = sc.nextLine();
                System.out.print("Input country code 3 letters: ");
                countryCode3 = sc.nextLine();
                C1 = new Country(countryName,countryCode2,countryCode3);
                W.addCountry(C1);
                System.out.println("-----------------------------");
                System.out.println("Country successfully added!");
                System.out.println("-----------------------------");
                optionMenu = 0;
                break;
            }
            //Create State
            case 2:
            {
                //Auxiliary variables
                String stateName;
                String abbr;
                long area;
                String country;
                String capital;
                Country C2;
                sc.nextLine();
                System.out.print("Input state name: ");
                stateName = sc.nextLine();
                System.out.print("Input state abbreviation: ");
                abbr = sc.nextLine();
                System.out.print("Input country to wich belongs: ");
                country = sc.nextLine();
                System.out.print("Input state capital: ");
                capital = sc.nextLine();
                System.out.print("Input state area: ");
                area = sc.nextLong();
                C2 = W.searchCountry(country);
                state0 = new State(stateName,C2.getCountryCode2(),C2.getCountryCode3(),abbr, area, capital, listOfCities);
                C1.addState(state0);
                System.out.println("-----------------------------");
                System.out.println("State successfully added!");
                System.out.println("-----------------------------");
                optionMenu = 0;
                break;
            }
            //Create City
            case 3:
            {
                //Auxiliary variables
                String cityName;
                String countryCode2;
                String countryCode3;
                String state;
                State S;
                sc.nextLine();
                System.out.print("Input city name: ");
                cityName = sc.nextLine();
                System.out.print("Input state to wich belongs: ");
                state = sc.nextLine();
                S = C1.getState(state);
                city = new City(cityName,S.getCountryCode2(),S.getCountryCode3(), weather);
                state0.addCity(city);
                System.out.println("-----------------------------");
                System.out.println("City successfully added!");
                System.out.println("-----------------------------");
                optionMenu = 0;
                break;
            }
            //View Country info
            case 4:
            {
                //Auxiliary variables
                String country = "";
                sc.nextLine();
                System.out.print("Input country name to view: ");
                country = sc.nextLine();
                System.out.println(W.searchCountry(country).toString());
                optionMenu = 0;
                break;
            }
            //View state info
            case 5:
            {
                //Auxiliary variables
                String stateName;
                sc.nextLine();
                System.out.println("Input state name to view: ");
                stateName = sc.nextLine();
                System.out.println(C1.getState(stateName).toString());
                optionMenu = 0;
                break;
            }
            //View City info
            case 6:
            {
                //Auxiliary variables
                String cityName;
                sc.nextLine();
                System.out.println("Input city name to view: ");
                cityName = sc.nextLine();
                System.out.println(state0.getCity(cityName).toString());
                optionMenu = 0;
                break;
            }
            //Load city weather information
            case 7:
            {
                //Auxiliary variables
                int windSpeed, direction;
                int humidity;
                double pressure;
                int visibility;
                int rising;
                String date;
                String description;
                float temprature;
                String cityName;
                sc.nextLine();
                System.out.print("Input City name to load Weather: ");
                cityName = sc.nextLine();
                System.out.print("Input Wind speed: ");
                windSpeed = sc.nextInt();
                System.out.print("Input Windo Direction(number): ");
                direction = sc.nextInt();
                System.out.print("Input Atmosphere humidity: ");
                humidity = sc.nextInt();
                System.out.print("Input Atmosphere pressure: ");
                pressure = sc.nextDouble();
                System.out.print("Input Atmosphere visibility(number): ");
                visibility = sc.nextInt();
                System.out.print("Input Atmosphere rising(number): ");
                rising = sc.nextInt();
                System.out.print("Input temperature for actual weather: ");
                temprature = sc.nextFloat();
                sc.nextLine();
                System.out.print("Input date for actual weather: ");
                date = sc.nextLine();
                System.out.print("Input description for actual wether: ");
                description = sc.nextLine();
                Atmosphere A1 = new Atmosphere(humidity,pressure,visibility,rising);
                Wind W1 = new Wind(windSpeed,direction);
                Actual Act1 = new Actual(date,description,temprature);
                Extended extend = new Extended();
                Extended [] array = extend.getExtended(1);
                weather = new Weather(1,date,description,Act1,array,W1,A1);
                state0.getCity(cityName).setWeather(weather);
                optionMenu = 0;
                break;
            }

            //View city weather information
            case 8:
            {
                //Auxiliary variables
                String cityName;
                sc.nextLine();
                System.out.println("Input City name to view Weather information: ");
                cityName = sc.nextLine();
                System.out.println(state0.getCity(cityName).getWeather().toString());
                optionMenu = 0;
                break;
            }

            //Exit
            case 9:
            {
                optionMenu = 10;
            }
        }
        }while (optionMenu==0);


    }
}
