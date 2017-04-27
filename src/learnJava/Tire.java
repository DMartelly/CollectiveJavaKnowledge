package learnJava;

/**
 * Created by Dominick Martelly on 3/9/2016 at 6:45 PM.
 * <p>
 * A tire object
 */
public class Tire {
    private final String material;

    /**
     * Diameter in inches
     */
    private int diameter;

    private boolean flat;

    Tire(String material, int diameter, boolean isFlat) {
        this.material = material;
        this.diameter = diameter;
        this.flat = isFlat;

    }

    String getMaterial() {
        return material;
    }

    boolean isFlat() {
        return flat;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "Material ='" + getMaterial() + '\'' +
                ", Diameter =" + diameter +
                ", Is Flat =" + isFlat() +
                '}';
    }
}
