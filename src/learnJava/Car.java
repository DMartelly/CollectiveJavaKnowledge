package learnJava;

/**
 * Created by Dominick Martelly on 3/9/2016 at 5:47 PM.
 * <p>
 * A car object
 */
public class Car extends Vehicle implements Comparable<Car> {

    private final String make;
    private final String model;
    private final String year;

    /**
     * @param make        The car's make
     * @param model       The car's model
     * @param power       The amount of horse power
     * @param weight      The weight
     * @param color       The car's color
     * @param tireWeights the weight of each tire
     */
    Car(String make, String model, int power, long weight, String color, int tireWeights) {
        super("Metal", power, weight, color, 2, 4, tireWeights);
        this.make = make;
        this.model = model;
        this.year = "Unknown";
    }

    Car(String make, String model, String year, int power, long weight, String color, int tireWeights) {
        super("Metal", power, weight, color, 2, 4, tireWeights);
        this.make = make;
        this.model = model;
        this.year = year;
    }

    String getMake() {
        return make;
    }

    String getModel() {
        return model;
    }

    String getYear() {
        return year;
    }

    @Override
    public String toString() {

        //Can use getMake() or variable make

        return "A " + year + " " + make + " " + model + "\n" +
                "Horse Power: " + getEnginePower() + " HP" + "\n" +
                "Number of Tires: " + getNumOfTires() + "\n" +
                super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!Car.class.isAssignableFrom(object.getClass())) {
            return false;
        }
        final Car otherCar = (Car) object;

        return (otherCar.getMake().equals(this.make) &&
                otherCar.getModel().equals(this.model) &&
                otherCar.getYear().equals(this.year));
    }

    @Override
    public int compareTo(Car otherCar) {
        if (this.equals(otherCar))
            return 0;
        int makeCompare = this.make.compareTo(otherCar.getMake());
        if (makeCompare == 0)
            return this.model.compareTo(otherCar.model);
        return makeCompare;
    }
}
