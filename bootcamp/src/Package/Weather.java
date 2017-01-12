package Package;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class Weather {

    //Attributes
    private int id_weather;
    private String date;
    private String description;
    private Actual ActualWeather;
    private Extended[] extendedWeather;
    private Wind wind;
    private Atmosphere atmosphere;
    //Constructors
    public Weather(){}
    public Weather(String date, String description){
        this.date = date;
        this.description = description;
    }
    public Weather(int id_weather, String date, String description, Actual actualWeather, Extended[] extendedWeather, Wind wind, Atmosphere atmosphere) {
        this.id_weather = id_weather;
        this.date = date;
        this.description = description;
        this.ActualWeather = actualWeather;
        this.extendedWeather = extendedWeather;
        this.wind = wind;
        this.atmosphere = atmosphere;
    }

    //Getters and Setters methods
    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
    public int getId_weather()
    {
        return this.id_weather;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //ToString method
    public String toString() {

        //Auxiliary
        String extendedW="";

        for (int i = 0;i<extendedWeather.length;i++)
        {
            extendedW+="\n"+(extendedWeather[i].toString());
        }
        return "   Date: "+date + "\n" +
                "  Wind=" + wind.toString() + "\n" +
                "  Description= '" + description  +"'"+'\n' +
                "  Atmosphere= "+ atmosphere.toString() +
                "\nActual Weather= " + ActualWeather.toString() + "\n" +
                "  Extended Weather=" +extendedW +
                '}';
    }
}
