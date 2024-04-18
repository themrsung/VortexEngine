package pegasus.number;

import java.io.Serial;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

/**
 * Immutable four-dimensional vector with {@code double} values. Supports mathematical operations.
 */
public class Vector4 extends Double4 implements MathVector<Vector4> {
    /**
     * The serial version UID of this class.
     */
    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * The zero vector.
     */
    public static final Vector4 ZERO = new Vector4(0, 0, 0, 0);

    /**
     * The positive W unit vector.
     */
    public static final Vector4 POSITIVE_W = new Vector4(1, 0, 0, 0);

    /**
     * The positive X unit vector.
     */
    public static final Vector4 POSITIVE_X = new Vector4(0, 1, 0, 0);

    /**
     * The positive Y unit vector.
     */
    public static final Vector4 POSITIVE_Y = new Vector4(0, 0, 1, 0);

    /**
     * The positive Z unit vector.
     */
    public static final Vector4 POSITIVE_Z = new Vector4(0, 0, 0, 1);

    /**
     * The negative W unit vector.
     */
    public static final Vector4 NEGATIVE_W = new Vector4(-1, 0, 0, 0);

    /**
     * The negative X unit vector.
     */
    public static final Vector4 NEGATIVE_X = new Vector4(0, -1, 0, 0);

    /**
     * The negative Y unit vector.
     */
    public static final Vector4 NEGATIVE_Y = new Vector4(0, 0, -1, 0);

    /**
     * The negative Z unit vector.
     */
    public static final Vector4 NEGATIVE_Z = new Vector4(0, 0, 0, -1);

    /**
     * Creates a new vector.
     * @param w The W value of this vector
     * @param x The X value of this vector
     * @param y The Y value of this vector
     * @param z The Z value of this vector
     */
    public Vector4(double w, double x, double y, double z) {
        super(w, x, y, z);
    }

    /**
     * Creates a new vector.
     * @param dv The vector of which to copy values from
     */
    public Vector4(DoubleVector dv) {
        super(dv);
    }

    @Override
    public boolean isZero() {
        return w == 0 && x == 0 && y == 0 && z == 0;
    }

    @Override
    public boolean isNaN() {
        return Double.isNaN(w) || Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(z);
    }

    @Override
    public boolean isFinite() {
        return Double.isFinite(w) && Double.isFinite(x) && Double.isFinite(y) && Double.isFinite(z);
    }

    @Override
    public boolean isInfinite() {
        return Double.isInfinite(w) || Double.isInfinite(x) || Double.isInfinite(y) || Double.isInfinite(z);
    }

    @Override
    public double norm() {
        return Math.sqrt(w * w + x * x + y * y + z * z);
    }

    @Override
    public double normSquared() {
        return w * w + x * x + y * y + z * z;
    }

    @Override
    public double normManhattan() {
        return Math.abs(w) + Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    @Override
    public Vector4 add(double s) {
        return new Vector4(w + s, x + s, y + s, z + s);
    }

    @Override
    public Vector4 subtract(double s) {
        return new Vector4(w - s, x - s, y - s, z - s);
    }

    @Override
    public Vector4 multiply(double s) {
        return new Vector4(w * s, x * s, y * s , z * s);
    }

    @Override
    public Vector4 divide(double s) {
        return new Vector4(w / s, x / s, y / s, z / s);
    }

    @Override
    public Vector4 add(Vector4 other) {
        return new Vector4(w + other.w, x + other.x, y + other.y, z + other.z);
    }

    @Override
    public Vector4 subtract(Vector4 other) {
        return new Vector4(w - other.w, x - other.x, y - other.y, z - other.z);
    }

    @Override
    public double dot(Vector4 other) {
        return w * other.w + x * other.x + y * other.y + z * other.z;
    }

    @Override
    public Vector4 min(Vector4 other) {
        return new Vector4(
                Math.min(w, other.w),
                Math.min(x, other.x),
                Math.min(y, other.y),
                Math.min(z, other.z)
        );
    }

    @Override
    public Vector4 max(Vector4 other) {
        return new Vector4(
                Math.max(w, other.w),
                Math.max(x, other.x),
                Math.max(y, other.y),
                Math.max(z, other.z)
        );
    }

    @Override
    public Vector4 clamp(Vector4 min, Vector4 max) {
        return new Vector4(
                Math.min(Math.max(w, min.w), max.w),
                Math.min(Math.max(x, min.x), max.x),
                Math.min(Math.max(y, min.y), max.y),
                Math.min(Math.max(z, min.z), max.z)
        );
    }

    @Override
    public Vector4 round() {
        return new Vector4(
                Math.round(w),
                Math.round(x),
                Math.round(y),
                Math.round(z)
        );
    }

    @Override
    public Vector4 floor() {
        return new Vector4(
                Math.floor(w),
                Math.floor(x),
                Math.floor(y),
                Math.floor(z)
        );
    }

    @Override
    public Vector4 ceil() {
        return new Vector4(
                Math.ceil(w),
                Math.ceil(x),
                Math.ceil(y),
                Math.ceil(z)
        );
    }

    @Override
    public Vector4 abs() {
        return new Vector4(
                Math.abs(w),
                Math.abs(x),
                Math.abs(y),
                Math.abs(z)
        );
    }

    @Override
    public Vector4 negate() {
        return new Vector4(-w, -x, -y, -z);
    }

    @Override
    public Vector4 map(DoubleUnaryOperator mapper) {
        return new Vector4(
                mapper.applyAsDouble(w),
                mapper.applyAsDouble(x),
                mapper.applyAsDouble(y),
                mapper.applyAsDouble(z)
        );
    }

    @Override
    public Vector4 merge(Vector4 other, DoubleBinaryOperator merger) {
        return new Vector4(
                merger.applyAsDouble(w, other.w),
                merger.applyAsDouble(x, other.x),
                merger.applyAsDouble(y, other.y),
                merger.applyAsDouble(z, other.z)
        );
    }

    @Override
    public Vector4 normalize() {
        var i = 1 / Math.sqrt(w * w + x * x + y * y + z * z);
        return new Vector4(w * i, x * i, y * i, z * i);
    }

    @Override
    public Vector4 normalizeZeroSafe() throws ArithmeticException {
        if (isZero()) throw new ArithmeticException("Cannot normalize a zero vector.");
        return normalize();
    }

    @Override
    public double distance(Vector4 other) {
        var dw = w - other.w;
        var dx = x - other.x;
        var dy = y - other.y;
        var dz = z - other.z;

        return Math.sqrt(dw * dw + dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceSquared(Vector4 other) {
        var dw = w - other.w;
        var dx = x - other.x;
        var dy = y - other.y;
        var dz = z - other.z;

        return dw * dw + dx * dx + dy * dy + dz * dz;
    }

    @Override
    public double distanceManhattan(Vector4 other) {
        var dw = Math.abs(w - other.w);
        var dx = Math.abs(x - other.x);
        var dy = Math.abs(y - other.y);
        var dz = Math.abs(z - other.z);

        return dw + dx + dy + dz;
    }
}
