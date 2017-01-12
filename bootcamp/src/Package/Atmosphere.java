package Package;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class Atmosphere {

    //Attributes
    private int humidity;
    private double pressure;
    private int visibility;
    private int rising;

    //Constructors
    public Atmosphere(){}
    public Atmosphere(int humidity, double pressure, int visibility, int rising) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.rising = rising;
    }

    // Getters and Setters methods
    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getRising() {
        return rising;
    }

    public void setRising(int rising) {
        this.rising = rising;
    }

   //ToString method
    public String toString() {
        return "{ "+
                "humidity=" + humidity +
                ", pressure=" + pressure +
                ", visibility=" + visibility +
                ", rising=" + rising +
                '}';
    }
}
