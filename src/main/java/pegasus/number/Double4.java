package pegasus.number;

import java.io.Serial;
import java.util.Objects;
import java.util.stream.DoubleStream;

/**
 * An immutable four-dimensional {@code double} vector.
 */
public class Double4 implements DoubleVector {
    /**
     * The serial version UID of this class.
     */
    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * The zero vector.
     */
    public static final Double4 ZERO = new Double4(0, 0, 0, 0);

    /**
     * The X value of this vector.
     */
    public final double w;

    /**
     * The X value of this vector.
     */
    public final double x;

    /**
     * The Y value of this vector.
     */
    public final double y;

    /**
     * The Z value of this vector.
     */
    public final double z;

    /**
     * Creates a new vector.
     * @param w The W value of this vector
     * @param x The X value of this vector
     * @param y The Y value of this vector
     * @param z The Z value of this vector
     */
    public Double4(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates a new vector.
     * @param dv The vector from which to copy component values from
     */
    public Double4(DoubleVector dv) {
        if (dv.dimensions() != 4) {
            throw new IllegalArgumentException("The provided vector is not four-dimensional.");
        }

        var values = dv.toArray();

        this.w = values[0];
        this.x = values[1];
        this.y = values[2];
        this.z = values[3];
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public int dimensions() {
        return 4;
    }

    @Override
    public DoubleStream stream() {
        return DoubleStream.of(w, x, y, z);
    }

    @Override
    public double[] toArray() {
        return new double[] {w, x, y, z};
    }

    @Override
    public int hashCode() {
        return Objects.hash(w, x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Double4 v)) return false;
        return w == v.w && x == v.x && y == v.y && z == v.z;
    }

    @Override
    public String toString() {
        return "[" + w + ", " + x + ", " + y + ", " + z + "]";
    }
}
