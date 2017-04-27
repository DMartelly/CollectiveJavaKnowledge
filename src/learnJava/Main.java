package learnJava;

import java.util.AbstractQueue;
import java.util.PriorityQueue;

/**
 * Created by Dominick Martelly on 3/9/2016 at 5:47 PM.
 * <p>
 * A car object
 */
public class Main {

    public static void main(String[] args) {
        //A Blue Honda Civic
        Car HondaCivic2017 = new Car("Honda", "Civic", 174, 2758, "Blue", 85);
        System.out.println(HondaCivic2017);

        //My car
        Vehicle VWJetta2017 = new Car("Volkswagen", "Jetta", 100, 2500, "Navy Blue", 85);
        System.out.println(VWJetta2017);
        VWJetta2017.removeOneTire();
        VWJetta2017.sprayPaint("White");
        VWJetta2017.setWeight(2600);
        System.out.println(VWJetta2017);

        // A Vehicle that is retype-defined as a car
        Vehicle Bertha = new Motorcycle("Wood", 95, 600, "Black", 1);
        System.out.println(Bertha);
        Bertha = new Car("Toyota", "Camry", 140, 2700, "Grey", 88);
        System.out.println(Bertha);

        //Just a motorcycle
        Vehicle randomMotorcycle = new Motorcycle("Aluminum", 60, 450, "Red", 1);

        //Priority Queue. Prints out the Objects in ABC order
        AbstractQueue<Vehicle> myGarage = new PriorityQueue<>();
        myGarage.add(HondaCivic2017);
        myGarage.add(VWJetta2017);
        myGarage.add(Bertha);
        //myGarage.add(randomMotorcycle); Cant compare with a motorcycle

        System.out.println("My Garage------------------------------");
        while (!myGarage.isEmpty()) {
            System.out.println(myGarage.remove());
        }
    }

}
