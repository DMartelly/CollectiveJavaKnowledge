package LearnJava;

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

    /**
     * The weight of the tire
     */
    private long weight;
    private boolean flat;

    public Tire(String material, int diameter, int weight, boolean isFlat) {
        this.material = material;
        this.diameter = diameter;
        this.weight = weight;
        this.flat = isFlat;

    }

    public String getMaterial() {
        return material;
    }

    public long getWeight() {
        return weight;
    }

    public boolean isFlat() {
        return flat;
    }

    @Override
    public String toString() {
        return "Tire{" +
                "Material ='" + getMaterial() + '\'' +
                ", Diameter =" + diameter +
                ", Weight =" + weight +
                ", Is Flat =" + isFlat() +
                '}';
    }
}
