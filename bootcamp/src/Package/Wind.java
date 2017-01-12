package Package;

/**
 * Created by facundo crusta on 10/01/2017.
 */
public class Wind {

    //Attributes
    private int speed;
    private int direction;

    //Constructors
    public Wind(){}
    public Wind(int velocidad, int direction) {
        this.speed = velocidad;
        this.direction = direction;
    }

    //Getters and Setters methods
    public int getVelocidad() {
        return speed;
    }

    public void setVelocidad(int velocidad) {
        this.speed = velocidad;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    //ToString method
    public String toString() {
        return " {" +
                "Speed= " + speed +
                ", Direction= " + direction +
                '}';
    }
}
