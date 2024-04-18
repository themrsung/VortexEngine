package pegasus.number;

import java.io.Serial;
import java.util.Objects;
import java.util.stream.DoubleStream;

/**
 * Am immutable three-dimensional {@code double} vector.
 */
public class Double3 implements DoubleVector {
    /**
     * The serial version UID of this class.
     */
    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * The zero vector.
     */
    public static final Double3 ZERO = new Double3(0, 0, 0);

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
     * @param x The X value of this vector
     * @param y The Y value of this vector
     * @param z The Z value of this vector
     */
    public Double3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Creates a new vector.
     * @param dv The vector from which to copy component values from
     */
    public Double3(DoubleVector dv) {
        if (dv.dimensions() != 3) {
            throw new IllegalArgumentException("The provided vector is not three-dimensional.");
        }

        var values = dv.toArray();

        this.x = values[0];
        this.y = values[1];
        this.z = values[2];
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public boolean isMutable() {
        return false;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int dimensions() {
        return 3;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public DoubleStream stream() {
        return DoubleStream.of(x, y, z);
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public double[] toArray() {
        return new double[] {x, y, z};
    }

    /**
     * Returns the hash code of this vector.
     * @return The hash code of this vector
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    /**
     * {@inheritDoc}
     * @param obj The object to compare
     * @return {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Double3 v)) return false;
        return x == v.x && y == v.y && z == v.z;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public String toString() {
        return "[" + x + ", " + y + ", " + z + "]";
    }
}
