package Package;

/**
 * Created by facun on 10/01/2017.
 */
public class City extends Country {

    private Weather weather;

    public City(Weather weather) {
        this.weather = weather;
    }

    public City(String name, String countryCode2, String countryCode3, Weather weather) {
        super(name, countryCode2, countryCode3);
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getName()
    {
        return super.getName();
    }


    public String toString() {
        return "City{ " + super.getName() +
                ", Weather Date=" + weather +
                '}';
    }
}
