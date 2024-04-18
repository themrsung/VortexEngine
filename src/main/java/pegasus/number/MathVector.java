package pegasus.number;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/**
 * A vector which supports mathematical operations.
 * @param <V> The vector itself
 */
public interface MathVector<V extends MathVector<?>> extends DoubleVector {
    /**
     * Returns whether this vector is zero.
     * @return {@code true} if this vector is zero
     */
    boolean isZero();

    /**
     * Returns whether this vector is not a number.
     * @return {@code true} if this vector is not a number
     */
    boolean isNaN();

    /**
     * Returns whether this vector is finite.
     * @return {@code true} if this vector is finite
     */
    boolean isFinite();

    /**
     * Returns whether this vector is infinite.
     * @return {@code true} if this vector if infinite
     */
    boolean isInfinite();

    /**
     * Returns the Euclidean norm of this vector.
     * @return The Euclidean norm of this vector
     */
    double norm();

    /**
     * Returns the squared Euclidean norm of this vector.
     * @return The squared Euclidean norm of this vector
     */
    double normSquared();

    /**
     * Returns the Manhattan norm of this vector.
     * @return The Manhattan norm of this vector
     */
    double normManhattan();

    /**
     * Adds a scalar to this vector.
     * @param s The scalar to add
     * @return The resulting vector
     */
    V add(double s);

    /**
     * Subtracts a scalar from this vector.
     * @param s The scalar to subtract
     * @return The resulting vector
     */
    V subtract(double s);

    /**
     * Multiplies this vector by the provided scalar.
     * @param s The scalar to multiply by
     * @return The resulting vector
     */
    V multiply(double s);

    /**
     * Divides this vector by the provided scalar. Does not check for zero division.
     * @param s The scalar denominator
     * @return The resulting vector
     */
    V divide(double s);

    /**
     * Adds another vector to this vector.
     * @param other The vector to add to this vector
     * @return The resulting vector
     */
    V add(V other);

    /**
     * Subtracts another vector from this vector.
     * @param other The vector to subtract from this vector
     * @return The resulting vector
     */
    V subtract(V other);

    /**
     * Calculates the dot product of this vector with another vector.
     * @param other The vector to compute the dot product with
     * @return The dot product of the two vectors
     */
    double dot(V other);

    /**
     * Returns the minimum vector.
     * @param other The vector to compare to
     * @return The minimum vector
     */
    V min(V other);

    /**
     * Returns the maximum vector.
     * @param other The vector to compare to
     * @return The maximum vector
     */
    V max(V other);

    /**
     * Clamps this vector to the provided range {@code [min, max]}.
     * @param min The minimum bound
     * @param max The maximum bound
     * @return The clamped vector
     */
    V clamp(V min, V max);

    /**
     * Rounds this vector.
     * @return The rounded vector
     */
    V round();

    /**
     * Floors this vector.
     * @return The floored vector
     */
    V floor();

    /**
     * Returns the ceiling of this vector.
     * @return The ceiling of this vector
     */
    V ceil();

    /**
     * Returns the absolute of this vector.
     * @return The absolute of this vector
     */
    V abs();

    /**
     * Returns the negation of this vector.
     * @return The negation of this vector
     */
    V negate();

    /**
     * Applies the provided mapper function to each component of this vector, then returns a new vector
     * whose components are assigned from the return values of the corresponding mapper function.
     * @param mapper The mapper function to use
     * @return The mapped vector
     */
    V map(DoubleUnaryOperator mapper);

    /**
     * Applies the merger function to each corresponding pair of values between this vector and the provided
     * vector, then returns a new vector whose components are assigned from the return values of the merger function.
     * @param other The other vector to merge with
     * @param merger The merger function to handle the merging of the two vectors
     * @return The merged vector
     */
    V merge(V other, DoubleBinaryOperator merger);

    /**
     * Normalizes this vector. This method does not check if the vector is zero before normalizing.
     * @return The normalized value of this vector
     */
    V normalize();

    /**
     * Normalizes this vector. This method checks if the vector is zero before normalizing.
     * @return The normalized value of this vector
     * @throws ArithmeticException When the vector is zero
     */
    V normalizeZeroSafe() throws ArithmeticException;

    /**
     * Returns the Euclidean distance to the provided vector.
     * @param other The vector to get the Euclidean distance to
     * @return The Euclidean distance to the provided vector
     */
    double distance(V other);

    /**
     * Returns the squared Euclidean distance to the provided vector.
     * @param other The vector to get the squared Euclidean distance to
     * @return The squared Euclidean distance to the provided vector
     */
    double distanceSquared(V other);

    /**
     * Returns the Manhattan distance to the provided vector.
     * @param other The vector to get the Manhattan distance to
     * @return The Manhattan distance to the provided vector
     */
    double distanceManhattan(V other);
}
