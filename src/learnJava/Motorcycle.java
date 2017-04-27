package learnJava;

/**
 * Created by Dominick Martelly on 3/9/2016 at 6:12 PM.
 *
 * Creates a motorcycle object
 */
public class Motorcycle extends Vehicle implements Comparable<Motorcycle> {


    Motorcycle(String material, int enginePower, long weight, String color, int headlights) {
        super(material, enginePower, weight, color, headlights, 2, 100);
    }

    @Override
    public int compareTo(Motorcycle o) {
        return 0;
    }
}
