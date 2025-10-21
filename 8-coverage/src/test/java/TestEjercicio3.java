import ejercicio3.TriTyp;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestEjercicio3 {
    @Test
    public void testConstructor(){
        TriTyp triangleType = new TriTyp();
        assertNotNull(triangleType);
    }

    @Test
    public void sideOneEqualsSideTwoAndIsTriangle() {
        int sideOne = 3;
        int sideTwo = 3;
        int sideThree = 5;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(2, result);
    }

    @Test
    public void sideOneInvalid(){
        int sideOne = -1;
        int sideTwo = 2;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }
    @Test
    public void sideTwoInvalid(){
        int sideOne = 2;
        int sideTwo = -1;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void sideThreeInvalid(){
        int sideOne = 2;
        int sideTwo = 4;
        int sideThree = -1;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void sideOneEqualsSideTwoAndNoIsTriangle(){
        int sideOne = 1;
        int sideTwo = 1;
        int sideThree = 4;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void sideOneNotEqualsSideTwoAndNotIsTriangle() {
        int sideOne = 1;
        int sideTwo = 2;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void sideOneNotEqualsSideThreeAndNotIsTriangle() {
        int sideOne = 3;
        int sideTwo = 8;
        int sideThree = 1;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void testOneAllSidesNotEqualsAndNotIsTriangle(){
        int sideOne = 1;
        int sideTwo = 2;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void testTwoAllSidesNotEqualsAndNotIsTriangle(){
        int sideOne = 5;
        int sideTwo = 2;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void testThreeAllSidesNotEqualsAndNotIsTriangle(){
        int sideOne = 5;
        int sideTwo = 8;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void sideOneEqualsSideThreeAndIsTriangle() {
        int sideOne = 3;
        int sideTwo = 5;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(2, result);
    }

    @Test
    public void sidesNotEqualsAndIsTriangle() {
        int sideOne = 3;
        int sideTwo = 4;
        int sideThree = 5;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(1, result);
    }

    @Test
    public void sidesNotEqualsAndNotIsTriangle() {
        int sideOne = 4;
        int sideTwo = 2;
        int sideThree = 2;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void allSidesEquals() {
        int sideOne = 3;
        int sideTwo = 3;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(3, result);
    }


    @Test
    public void sideTwoNotEqualsSideThreeAndIsTriangle() {
        int sideOne = 5;
        int sideTwo = 3;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(2, result);
    }

    @Test
    public void sideTwoEqualsSideThreeAndNotIsTriangle() {
        int sideOne = 6;
        int sideTwo = 3;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void sideOneEqualsSideThreeAndNotIsTriangle(){
        int sideOne = 3;
        int sideTwo = 7;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(4, result);
    }

    @Test
    public void sideTwoEqualsSideThreeAndIsTriangle() {
        int sideOne = 5;
        int sideTwo = 3;
        int sideThree = 3;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(2, result);
    }

    @Test
    public void sideOneEqualsZero() {
        int sideOne = 0;
        int sideTwo = 20;
        int sideThree = 32;
        int result = TriTyp.triang(sideOne, sideTwo, sideThree);
        assertEquals(result, 4);
    }
}
