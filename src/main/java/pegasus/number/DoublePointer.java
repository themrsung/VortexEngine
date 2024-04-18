package pegasus.number;

import java.io.Serial;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.DoubleStream;

/**
 * A mutable n-dimensional {@code double} vector.
 */
public final class DoublePointer implements DoubleVector {
    /**
     * The serial version UID of this class.
     */
    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * Returns a pointer to the provided array of {@code double}s.
     * @param values The values to point to
     * @return The created pointer
     */
    public static DoublePointer to(double... values) {
        return new DoublePointer(Objects.requireNonNull(values));
    }

    /**
     * Returns a new pointer with the provided values preassigned.
     * @param values The values to assign
     * @return The created pointer
     */
    public static DoublePointer valueOf(double... values) {
        var array = new double[values.length];
        var pointer = new DoublePointer(array);

        System.arraycopy(values, 0, array, 0, values.length);

        return pointer;
    }

    /**
     * Returns a new pointer with the provided values preassigned.
     * @param dv The vector containing the values to pre-assign
     * @return The created pointer
     */
    public static DoublePointer valueOf(DoubleVector dv) {
        if (dv instanceof DoublePointer dp) return valueOf(dp.values);

        var values = dv.stream().toArray();
        return new DoublePointer(values);
    }

    /**
     * The component values of this pointer.
     */
    private final double[] values;

    /**
     * Private constructor. Do not use outside of this class.
     * @param values The values to assign
     */
    private DoublePointer(double[] values) {
        this.values = values;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public boolean isMutable() {
        return true;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public int dimensions() {
        return values.length;
    }

    /**
     * Returns the {@code i}th component value of this pointer.
     * @param i The index of which to retrieve
     * @return The {@code i}th component value of this pointer
     * @throws IndexOutOfBoundsException When the index is out of bounds
     */
    public double get(int i) throws IndexOutOfBoundsException {
        return values[i];
    }

    /**
     * Sets the {@code i}th component value of this pointer.
     * @param i The index of which to set
     * @param value The value of which to set to
     * @throws IndexOutOfBoundsException When the index is out of bounds
     */
    public void set(int i, double value) throws IndexOutOfBoundsException {
        values[i] = value;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public DoubleStream stream() {
        return Arrays.stream(values);
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public double[] toArray() {
        return values;
    }
}
