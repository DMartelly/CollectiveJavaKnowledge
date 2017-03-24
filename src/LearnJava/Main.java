package LearnJava;

/**
 * Created by Dominick Martelly on 3/9/2016 at 5:47 PM.
 * <p>
 * A car object
 */
public class Main {

    public static void main(String[] args) {
        //make a Blue Honda Civic
        Car c = new Car("Honda", "Civic", 174, 2758, "Blue", 85);
        System.out.println(c);

        //My car
        Vehicle myCar = new Car("Volkswagen", "Jetta", 100, 2500, "Navy Blue", 85);
        System.out.println(myCar);
        myCar.removeATire();
        myCar.sprayPaint("White");
        myCar.setWeight(2600);
        System.out.println(myCar);

        // A motorcycle
        Vehicle Bertha = new Motorcycle("Wood", 95, 600, "Black", 1);
        System.out.println(Bertha);
        Bertha = new Car("Toyota", "Camry", 140, 2700, "Grey", 88);
        System.out.println(Bertha);
    }

}
