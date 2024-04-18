package pegasus.number;

import java.io.Serial;

/**
 * A specialized four-dimensional vector used for vector rotation.
 */
public class Quaternion extends Vector4 {
    /**
     * The serial version UID of this class.
     */
    @Serial
    private static final long serialVersionUID = 0L;

    /**
     * The identity quaternion.
     */
    public static final Quaternion IDENTITY = new Quaternion(1, 0, 0, 0);

    /**
     * Creates a new quaternion.
     * @param w The scalar value of this quaternion
     * @param x The X component of this quaternion
     * @param y The Y component of this quaternion
     * @param z The Z component of this quaternion
     */
    public Quaternion(double w, double x, double y, double z) {
        super(w, x, y, z);
    }

    /**
     * Creates a new quaternion.
     * @param s The scalar value of this quaternion
     * @param v The vector value of this quaternion
     */
    public Quaternion(double s, Double3 v) {
        super(s, v.x, v.y, v.z);
    }

    /**
     * Creates a new quaternion.
     * @param dv The vector from which to copy component values from
     */
    public Quaternion(DoubleVector dv) {
        super(dv);
    }

    /**
     * Returns the vector component of this quaternion.
     * @return The vector component of this quaternion
     */
    public Vector3 vector() {
        return new Vector3(x, y, z);
    }

    @Override
    public Quaternion add(double s) {
        return new Quaternion(w + s, x, y, z);
    }

    @Override
    public Quaternion subtract(double s) {
        return new Quaternion(w - s, x, y, z);
    }

    @Override
    public Quaternion multiply(double s) {
        return new Quaternion(w * s, x * s, y * s, z * s);
    }

    @Override
    public Quaternion divide(double s) {
        return new Quaternion(w / s, x / s, y / s, z / s);
    }

    @Override
    public Quaternion add(Vector4 other) {
        return new Quaternion(w + other.w, x + other.x, y + other.y, z + other.z);
    }

    @Override
    public Quaternion subtract(Vector4 other) {
        return new Quaternion(w - other.w, x - other.x, y - other.y, z - other.z);
    }
    @Override
    public Quaternion min(Vector4 other) {
        return new Quaternion(
                Math.min(w, other.w),
                Math.min(x, other.x),
                Math.min(y, other.y),
                Math.min(z, other.z)
        );
    }

    @Override
    public Quaternion max(Vector4 other) {
        return new Quaternion(
                Math.max(w, other.w),
                Math.max(x, other.x),
                Math.max(y, other.y),
                Math.max(z, other.z)
        );
    }

    @Override
    public Quaternion clamp(Vector4 min, Vector4 max) {
        return new Quaternion(
                Math.min(Math.max(w, min.w), max.w),
                Math.min(Math.max(x, min.x), max.x),
                Math.min(Math.max(y, min.y), max.y),
                Math.min(Math.max(z, min.z), max.z)
        );
    }

    @Override
    public Quaternion negate() {
        return new Quaternion(-w, -x, -y, -z);
    }
}
