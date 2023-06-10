import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import project01.Vector3D;

import javax.naming.NameNotFoundException;


public class Vector3DTest {
    private Vector3D vector1;
    private Vector3D vector2;
    private Vector3D vector3;
    private Vector3D vector4;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.vector1 = new Vector3D(1, 2, 3);
        this.vector2 = new Vector3D(0, 0, 1);
        this.vector3 = new Vector3D(0, 0, 0);
        this.vector4 = new Vector3D(2, 3, 4);
    }
    @Test
    public void getX() {
        assertEquals(1, vector1.getX());
    }

    @Test
    public void getY() {
        assertEquals(2, vector1.getY());
    }

    @Test
    public void getZ() {
        assertEquals(3, vector1.getZ());
    }
    @Test
    public void toStringTest() {
        String expected;
        expected = "(1.00,2.00,3.00)";
        assertEquals(expected, this.vector1.toString());
    }
    @Test
    public void getMagnitudeTest() {
        assertEquals(3.74, this.vector1.getMagnitude(), 0.01);
        assertEquals(1.00, this.vector2.getMagnitude(), 0.01);
        assertEquals(0, this.vector3.getMagnitude(), 0.01);
    }
    @Test
    public void normalizeTest() {
        assertThrows(IllegalStateException.class,() -> vector3.normalize());
        assertEquals(new Vector3D(0.27,0.53,0.80).toString(), vector1.normalize().toString());
        assertEquals(new Vector3D(0,0,1).toString(), vector2.normalize().toString());
    }

    @Test
    public void addTest() {
        assertEquals(new Vector3D(3,5,7).toString(), vector1.add(vector4).toString());
        assertEquals(new Vector3D(2,3,5).toString(), vector2.add(vector4).toString());
        assertEquals(new Vector3D(2,3,4).toString(), vector3.add(vector4).toString());
    }
    @Test
    public void multiply() {
        assertEquals(new Vector3D(5,10,15).toString(), vector1.multiply(5).toString());
        assertEquals(new Vector3D(0,0,5).toString(), vector2.multiply(5).toString());
        assertEquals(new Vector3D(0,0,0).toString(), vector3.multiply(5).toString());
    }
    @Test
    public void dotProductTest() {
        assertEquals(20.00, vector1.dotProduct(vector4), 0.01);
        assertEquals(3.00, vector1.dotProduct(vector2), 0.01);
        assertEquals(0.00, vector1.dotProduct(vector3), 0.01);
    }
    @Test
    public void angleBetweenTest() {
        assertThrows(IllegalStateException.class,() -> vector1.angleBetween(vector3));
        assertEquals(6.98, vector1.angleBetween(vector4), 0.01);
        assertEquals(36.70, vector1.angleBetween(vector2), 0.01);

    }
    @Test
    public void crossProductTest() {
        assertEquals(new Vector3D(-1,2,-1).toString(), vector1.crossProduct(vector4).toString());
        assertEquals(new Vector3D(-3,2,0).toString(), vector2.crossProduct(vector4).toString());
        assertEquals(new Vector3D(0,0,0).toString(), vector3.crossProduct(vector4).toString());
    }
}