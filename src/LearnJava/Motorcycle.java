package LearnJava;

/**
 * Created by Dominick Martelly on 3/9/2016 at 6:12 PM.
 *
 * Creates a motorcycle object
 */
public class Motorcycle extends Vehicle {


    public Motorcycle(String material, int enginePower, long weight, String color, int headlights) {
        super(material, enginePower, weight, color, headlights, 2, 100);
    }
}
