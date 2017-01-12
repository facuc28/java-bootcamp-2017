package Package;

import java.sql.Date;
import java.sql.ResultSet;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class Extended extends Weather {

    //Attributes
    private String weekDay;
    private double maximum;
    private double minimum;

    //Auxiliary
    DataBase DB = new DataBase();
    //Constructors
    public Extended(){}
    public Extended(String weekDay, double maximum, double minimum) {
        this.weekDay = weekDay;
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public Extended(String date, String description, String weekDay, double maximum, double minimum) {
        super(date, description);
        this.weekDay = weekDay;
        this.maximum = maximum;
        this.minimum = minimum;
    }

    //Getters and Setters methods
    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Double getMaximum() {
        return maximum;
    }

    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }
    public String getDate()
    {
        return  super.getDate();
    }
    public void setDate(String date)
    {
        super.setDate(date);
    }
    public String getDescription()
    {
        return super.getDescription();
    }
    public void setDescription(String description)
    {
        super.setDescription(description);
    }

    public Extended[] getExtended(int weatherID)
    {
        //Auxiliary
        ResultSet resultSet;
        Extended [] extendedArray = new Extended[10];
        Extended extended;
        int i=0;
        String sql="SELECT * FROM extended WHERE id_weather="+weatherID;
        resultSet = DB.DBRequest(sql);
        int primerId=0;
        boolean flag = false;
        try {
            while (resultSet.next())
            {
                if (flag==false)
                {
                    primerId = resultSet.getInt("idextended");
                    flag = true;
                }
                if (resultSet.getInt("id_weather") == weatherID && resultSet.getInt("idextended")<(primerId+10))
                {
                    extended = new Extended(resultSet.getDate("date").toString(), resultSet.getString("description"), resultSet.getString("weekDay"), resultSet.getDouble("maximum"), resultSet.getDouble("minimum"));
                    extendedArray[i] = extended;
                    i++;
                }

            }

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return extendedArray;
    }

    //ToString method
    public String toString() {
        return "{" +
                "Week Day= '" + weekDay + '\'' +
                ", maximum= " + maximum +
                ", minimum= " + minimum +
                ", description= '"+super.getDescription()+"'"
                +", date= "+super.getDate()+
                +'}';
    }
}
