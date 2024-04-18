package pegasus.number;

import java.io.Serial;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/**
 * Immutable three-dimensional vector with {@code double} values. Supports mathematical operations.
 */
public class Vector3 extends Double3 implements MathVector<Vector3> {
    /**
     * The serial version UID of this class.
     */
    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * The zero vector.
     */
    public static final Vector3 ZERO = new Vector3(0, 0, 0);

    /**
     * The positive X unit vector.
     */
    public static final Vector3 POSITIVE_X = new Vector3(1, 0, 0);

    /**
     * The positive Y unit vector.
     */
    public static final Vector3 POSITIVE_Y = new Vector3(0, 1, 0);

    /**
     * The positive Z unit vector.
     */
    public static final Vector3 POSITIVE_Z = new Vector3(0, 0, 1);

    /**
     * The negative X unit vector.
     */
    public static final Vector3 NEGATIVE_X = new Vector3(-1, 0, 0);

    /**
     * The negative Y unit vector.
     */
    public static final Vector3 NEGATIVE_Y = new Vector3(0, -1, 0);

    /**
     * The negative Z unit vector.
     */
    public static final Vector3 NEGATIVE_Z = new Vector3(0, 0, -1);

    /**
     * Creates a new vector.
     * @param x The X value of this vector
     * @param y The Y value of this vector
     * @param z The Z value of this vector
     */
    public Vector3(double x, double y, double z) {
        super(x, y, z);
    }

    /**
     * Creates a new vector.
     * @param dv The vector of which to copy component values from
     */
    public Vector3(DoubleVector dv) {
        super(dv);
    }

    @Override
    public boolean isZero() {
        return x == 0 && y == 0 && z == 0;
    }

    @Override
    public boolean isNaN() {
        return Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z);
    }

    @Override
    public boolean isFinite() {
        return Double.isFinite(x) && Double.isFinite(y) && Double.isFinite(z);
    }

    @Override
    public boolean isInfinite() {
        return Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z);
    }

    @Override
    public double norm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double normSquared() {
        return x * x + y * y + z * z;
    }

    @Override
    public double normManhattan() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    @Override
    public Vector3 add(double s) {
        return new Vector3(x + s, y + s, z + s);
    }

    @Override
    public Vector3 subtract(double s) {
        return new Vector3(x - s, y - s, z - s);
    }

    @Override
    public Vector3 multiply(double s) {
        return new Vector3(x * s, y * s, z * s);
    }

    @Override
    public Vector3 divide(double s) {
        return new Vector3(x / s, y / s, z / s);
    }

    @Override
    public Vector3 add(Vector3 other) {
        return new Vector3(x + other.x, y + other.y, z + other.z);
    }

    @Override
    public Vector3 subtract(Vector3 other) {
        return new Vector3(x - other.x, y - other.y, z - other.z);
    }

    /**
     * Calculates the cross product of this vector with another vector.
     * @param other The vector to compute the cross product with
     * @return The resulting vector, which is perpendicular to both input vectors
     */
    public Vector3 cross(Vector3 other) {
        var newX = y * other.z - z * other.y;
        var newY = z * other.x - x * other.z;
        var newZ = x * other.y - y * other.x;

        return new Vector3(newX, newY, newZ);
    }

    @Override
    public double dot(Vector3 other) {
        return x * other.x + y * other.y + z * other.z;
    }

    @Override
    public Vector3 min(Vector3 other) {
        return new Vector3(
                Math.min(x, other.x),
                Math.min(y, other.y),
                Math.min(z, other.z)
        );
    }

    @Override
    public Vector3 max(Vector3 other) {
        return new Vector3(
                Math.max(x, other.x),
                Math.max(y, other.y),
                Math.max(z, other.z)
        );
    }

    @Override
    public Vector3 clamp(Vector3 min, Vector3 max) {
        return new Vector3(
                Math.min(Math.max(x, min.x), max.x),
                Math.min(Math.max(y, min.y), max.y),
                Math.min(Math.max(z, min.z), max.z)
        );
    }

    @Override
    public Vector3 round() {
        return new Vector3(
                Math.round(x),
                Math.round(y),
                Math.round(z)
        );
    }

    @Override
    public Vector3 floor() {
        return new Vector3(
                Math.floor(x),
                Math.floor(y),
                Math.floor(z)
        );
    }

    @Override
    public Vector3 ceil() {
        return new Vector3(
                Math.ceil(x),
                Math.ceil(y),
                Math.ceil(z)
        );
    }

    @Override
    public Vector3 abs() {
        return new Vector3(
                Math.abs(x),
                Math.abs(y),
                Math.abs(z)
        );
    }

    @Override
    public Vector3 negate() {
        return new Vector3(-x, -y, -z);
    }

    @Override
    public Vector3 map(DoubleUnaryOperator mapper) {
        return new Vector3(
                mapper.applyAsDouble(x),
                mapper.applyAsDouble(y),
                mapper.applyAsDouble(z)
        );
    }

    @Override
    public Vector3 merge(Vector3 other, DoubleBinaryOperator merger) {
        return new Vector3(
                merger.applyAsDouble(x, other.x),
                merger.applyAsDouble(y, other.y),
                merger.applyAsDouble(z, other.z)
        );
    }

    @Override
    public Vector3 normalize() {
        var i = 1 / Math.sqrt(x * x + y * y + z * z);
        return new Vector3(x * i, y * i, z * i);
    }

    @Override
    public Vector3 normalizeZeroSafe() throws ArithmeticException {
        if (isZero()) throw new ArithmeticException("Cannot normalize a zero vector.");
        return normalize();
    }

    @Override
    public double distance(Vector3 other) {
        var dx = x - other.x;
        var dy = y - other.y;
        var dz = z - other.z;

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceSquared(Vector3 other) {
        var dx = x - other.x;
        var dy = y - other.y;
        var dz = z - other.z;

        return dx * dx + dy * dy + dz * dz;
    }

    @Override
    public double distanceManhattan(Vector3 other) {
        var dx = Math.abs(x - other.x);
        var dy = Math.abs(y - other.y);
        var dz = Math.abs(z - other.z);

        return dx + dy + dz;
    }

    /**
     * Returns a quaternion where the scalar value is zero and the vector parts are assigned from this vector.
     * @return The created quaternion
     */
    public Quaternion quaternion() {
        return new Quaternion(0, this);
    }
}
