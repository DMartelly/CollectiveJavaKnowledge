package Patterns.SingletonPattern;

public class SingletonTest {

    public static void main(String[] args) {

        Car cool_car = Car.getInstance();
        System.out.print(cool_car);
    }
}

class Car {
    //The constructor (no parameters since only One instantiation of Car is allowed)
    protected Car() {
    }

    //Only ONE instantiation of Car
    private static Car myCar = null;

    //Give this ONE instantiation of Car to whoever needs it
    public static Car getInstance() {
        if (myCar == null)
            myCar = new Car();
        return myCar;
    }

    //Car's methods that can be used
    @Override
    public String toString() {
        return "Vrrooommm";
    }

}


