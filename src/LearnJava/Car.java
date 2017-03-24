package LearnJava;

/**
 * Created by Dominick Martelly on 3/9/2016 at 5:47 PM.
 * <p>
 * A car object
 */
public class Car extends Vehicle {

    /**
     * The make of a car
     */
    private final String make;
    /**
     * The model of the car
     */
    private final String model;

    /**
     * @param make        The car's make
     * @param model       The car's model
     * @param power       The number of horse power
     * @param weight      The weight
     * @param color       The car's color
     * @param tireWeights the weight of each tire
     */
    public Car(String make, String model, int power, long weight, String color, int tireWeights) {
        super("Metal", power, weight, color, 2, 4, tireWeights);
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {

        //Can use getMake() or variable make

        return "A " + getMake() + " " + getModel() + "\n" +
                "Horse Power: " + getEnginePower() + " HP" + "\n" +
                "Number of Tires: " + getNumOfTires() + "\n" +
                super.toString();
    }


}
