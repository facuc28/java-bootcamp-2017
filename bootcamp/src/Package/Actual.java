package Package;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class Actual extends Weather {

    //Attributes
    private double temprature;

    //Constructors
    public Actual(){}
    public Actual (double temperature){
        this.temprature = temperature;
    }

    public Actual(String date, String description, float temprature) {
        super(date, description);
        this.temprature = temprature;
    }

    //Getters and Setters methods
    public double getTemprature() {
        return temprature;
    }
    public String getDate(){
        return super.getDate();
    }
    public String getDescription()
    {
        return super.getDescription();
    }

    public void setTemprature(double temprature) {
        this.temprature = temprature;
    }
    public void setDate(String date)
    {
        super.setDate(date);
    }
    public void setDescription(String description)
    {
        super.setDescription(description);
    }

    //ToString method
    public String toString() {
        return  "Weather for today "+ super.getDate()+"\n" +
                "Temperature= " + temprature + "\n" +
                "Description= " + super.getDescription().toString();
    }
}
