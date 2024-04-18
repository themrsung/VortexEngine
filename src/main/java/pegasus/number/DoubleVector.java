package pegasus.number;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.DoubleStream;

/**
 * A vector with {@code double} values.
 */
public interface DoubleVector extends Serializable {
    /**
     * Checks for equality between two vectors. This is a null-safe operation.
     * @param v1 The first vector
     * @param v2 The second vector
     * @return {@code true} if the two vectors have the same dimension count and their
     * component values are equal
     */
    static boolean equals(DoubleVector v1, DoubleVector v2) {
        if (Objects.equals(v1, v2)) return true;

        var a1 = v1.toArray();
        var a2 = v2.toArray();

        return Arrays.equals(a1, a2);
    }

    /**
     * Returns whether this vector is mutable.
     * @return {@code true} if this vector is mutable
     */
    boolean isMutable();

    /**
     * Returns the number of dimensions (the number of scalar components) this vector has.
     * @return The number of dimensions this vector has
     */
    int dimensions();

    /**
     * Returns a stream whose source is the values of this vector.
     * @return A stream whose source is the values of this vector
     */
    DoubleStream stream();

    /**
     * Returns the array form of this vector. If this vector is {@link #isMutable() mutable},
     * changes in the return value of this method will be reflected to the vector.
     * @return The array form of this vector
     */
    double[] toArray();

    /**
     * Checks for equality between this vector and the provided object {@code obj}.
     * @param obj The object to compare
     * @return {@code true} if the provided object is a vector of the same type, and the values are equal
     */
    boolean equals(Object obj);

    /**
     * Returns the serialized form of this vector.
     * @return The serialized form of this vector
     */
    String toString();
}
