package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    public void getNumberOfVertices() {
        Box box = new Box(4, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertEquals(4, numberOfVertices);
    }

    @Test
    public void getNumberOfVerticesNegative() {
        Box box = new Box(-1, 10);
        int numberOfVertices = box.getNumberOfVertices();
        assertEquals(-1, numberOfVertices);
    }

    @Test
    public void boxDoesNotExist() {
        Box box = new Box(-1, 10);
        boolean exist = box.isExist();
        assertFalse(exist);
    }

    @Test
    public void boxExists() {
        Box box = new Box(0, 10);
        boolean result = box.isExist();
        assertTrue(result);
    }

    @Test
    public void areaIsZero() {
        Box box = new Box(2, 10);
        double area = box.getArea();
        assertEquals(0, area, 0.0001);
    }

    @Test
    public void nonZeroArea() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertNotEquals(0, area, 0.0001);
    }
}