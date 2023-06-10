package project01;

public class Vector3D {
  private final double x;
  private final double y;
  private final double z;

  public Vector3D(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Default coordinates are (0,0,0)
   */
  public Vector3D() {
    this(0,0,0);
  }

  /**
   * Get the x coordinate
   *
   * @return the x coordinate as a double
   */
  public double getX() {
    return x;
  }

  /**
   * Get the y coordinate
   *
   * @return the y coordinate as a double
   */
  public double getY() {
    return y;
  }

  /**
   * Get the z coordinate
   *
   * @return the z coordinate as a double
   */
  public double getZ() {
    return z;
  }

  /**
   * Returns a string representation of this vector
   *
   * @return a formatted string
   */

  public String toString() {
    return "(" + String.format("%.2f", x) +
            ", "  + String.format("%.2f", y) +
            ", "+ String.format("%.2f", z) + ")";
  }

  /**
   * Returns the magnitude of this vector
   * @return the magnitude as a double
   */
  public double getMagnitude() {
    return Math.sqrt(
            Math.pow(x, 2) +
                    Math.pow(y, 2) +
                    Math.pow(z, 2));
  }

  /**
   * Returns the normalized vector of this vector
   * @return the normalized vector as a Vector3D
   */
  public Vector3D normalize() throws IllegalStateException {
    if (getMagnitude() <= 0) {
      throw new IllegalStateException("Magnitude must be positive");}
    return new Vector3D (x / getMagnitude(),
            y / getMagnitude(),
             z / getMagnitude());
  }

  /**
   * Returns the result of adding this vector to another vector
   * @return the result as a Vector3D
   */

  public Vector3D add(Vector3D other) {
    return new Vector3D(x + other.x,
            y + other.y,
            z + other.z);
  }

  /**
   * Returns the result of multiplying this vector by a constant
   * @return the result as a Vector3D
   */
  public Vector3D multiply(float c) {
    return new Vector3D(x * c,
            y * c,
            z * c);
  }

  /**
   * Returns the dot product of this vector and another vector
   * @return the result as a double
   */
  public double dotProduct(Vector3D other) {

    return  x * other.x + y * other.y + z * other.z;
  }

  /**
   * Returns the angle between two vectors in degrees
   * @return the result as a double
   */
  public double angleBetween(Vector3D other) {
    if ((getMagnitude() * other.getMagnitude()) == 0) {
      throw new IllegalStateException("Denominator must not be zero");}
    return Math.toDegrees(Math.acos((x * other.x + y * other.y + z * other.z) /
            (getMagnitude() * other.getMagnitude())));
  }

  /**
   * Returns the cross product of this vector and another vector
   * @return the result as a Vector3D
   */
  public Vector3D crossProduct(Vector3D other) {
    return new Vector3D(y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x);
  }
}








