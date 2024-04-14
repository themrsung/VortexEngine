package pegasus.number;

import java.io.Serial;
import java.io.Serializable;

/**
 * An immutable vector with two integer values.
 */
public class Int2 implements Serializable {
    /**
     * The serial version UID of this class.
     */
    @Serial
    private static final long serialVersionUID = 0;

    /**
     * The zero vector.
     */
    public static final Int2 ZERO = new Int2(0, 0);

    /**
     * The X value of this vector.
     */
    public final int x;

    /**
     * The Y value of this vector.
     */
    public final int y;

    /**
     * Creates a new vector.
     * @param x The X value
     * @param y The Y value
     */
    public Int2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor.
     * @param i The {@link Int2} to copy
     */
    public Int2(Int2 i) {
        this.x = i.x;
        this.y = i.y;
    }

    /**
     * Adds a scalar to both axes of this vector.
     * @param i The scalar to add
     * @return The resulting vector
     */
    public Int2 add(int i) {
        return new Int2(x + i, y + i);
    }

    /**
     * Adds the corresponding values to the axes of this vector.
     * @param dx The scalar to add to the X axis
     * @param dy The scalar to add to the Y axis
     * @return The resulting vector
     */
    public Int2 add(int dx, int dy) {
        return new Int2(x + dx, y + dy);
    }

    /**
     * Adds another vector to this vector.
     * @param i The vector to add
     * @return The resulting vector
     */
    public Int2 add(Int2 i) {
        return new Int2(x + i.x, y + i.y);
    }

    /**
     * Subtracts a scalar from both axes of this vector.
     * @param i The scalar to subtract
     * @return The resulting vector
     */
    public Int2 subtract(int i) {
        return new Int2(x - i, y - i);
    }

    /**
     * Subtracts the corresponding values from the axes of this vector.
     * @param dx The value to subtract from the X axis
     * @param dy The value to subtract from the Y axis
     * @return The resulting vector
     */
    public Int2 subtract(int dx, int dy) {
        return new Int2(x - dx, y - dy);
    }

    /**
     * Subtracts another vector from this vector.
     * @param i The vector to subtract from this vector
     * @return The resulting vector
     */
    public Int2 subtract(Int2 i) {
        return new Int2(x - i.x, y - i.y);
    }

    /**
     * Checks for equality.
     * @param obj The object to compare
     * @return {@code true} if the provided object is an {@link Int2} and the values are equal
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Int2 i)) return false;
        return x == i.x && y == i.y;
    }

    /**
     * Serializes this vector into a string.
     * @return The string representation of this vector
     */
    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
