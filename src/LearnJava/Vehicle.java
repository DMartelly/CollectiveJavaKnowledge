package LearnJava;

import java.util.ArrayList;

/**
 * @author Dominick Martelly
 *         <p>
 *         A vehicle class
 */
public class Vehicle {

    /**
     * What the vehicle is made out of
     */
    private final String material;

    /**
     * The power of the engine, in horse power
     */
    private int enginePower;

    /**
     * The color of the vehicle
     */
    private String color;

    /**
     * The weight of the vehicle in pounds
     */
    private long weight;

    /**
     * The number of headlights for the vehicle. It should not ba able to change
     */
    private final int headlights;

    /**
     * The number of tires
     */
    private ArrayList<Tire> tires;

    /**
     * @param material    What the vehicle is made of
     * @param enginePower The Horse power of the engine
     * @param weight      The weight of the car in lB, without tires
     * @param color       The color of the car
     * @param headlights  The number of headlights
     * @param numOfTires  The number of tires
     * @param tireWeights The weight of tires
     */
    public Vehicle(String material, int enginePower, long weight, String color, int headlights, int numOfTires, int tireWeights) {
        this.material = material;
        this.enginePower = enginePower;
        this.weight = weight;
        this.color = color;
        this.headlights = headlights;
        this.tires = new ArrayList<Tire>();
        for (int i = 0; i < numOfTires; i++)
            tires.add(new Tire("Rubber", 16, tireWeights, false));
    }

    public void sprayPaint(String color) {
        this.color = color;
    }

    public void setWeight(long weight) {
        long totalTireWeight = 0;

        for (Tire theTires : tires)
            totalTireWeight += theTires.getWeight();
        this.weight = weight + totalTireWeight;
    }

    public String getMaterial() {
        return material;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public String getColor() {
        return color;
    }

    public long getWeight() {
        return weight;
    }

    public int getNumOfTires() {
        return tires.size();
    }


    public boolean removeATire() {
        if (tires.size() <= 0) {
            System.out.println("No Tires to Remove, This Vehicle has " + this.tires.size() + " Tires");
            return false;
        }
        tires.remove(0);
        weight -= tires.get(0).getWeight();
        return true;
    }

    @Override
    public String toString() {
        return "Material: " + getMaterial() + "\n" +
                "Color: " + getColor() + "\n" +
                "Number of Tires: " + tires.size() + "\n" +
                "Weight : " + getWeight() + " lb" + "\n";
    }
}
