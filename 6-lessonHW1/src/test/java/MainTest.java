import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    // Тесты к заданию 2
    @Test
    public void checkArrayTest1() {
    int[] inArr = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
    int[] outArr = new int[]{1, 7};

    Assertions.assertArrayEquals (outArr,Main.checkArray(inArr));// use array references
}
    @Test
    public void checkArrayTest2() {
        int[] inArr = new int[]{1, 2, 4, 4, 2, 3, 1, 7};
        int[] outArr = new int[]{2, 3, 1, 7};

        Assertions.assertArrayEquals (outArr,Main.checkArray(inArr));// use array references
    }
    @Test
    public void checkArrayTest3() {
        int[] inArr = new int[]{4, 1, 2, 1, 7};
        int[] outArr = new int[]{1,2,1,7};

        Assertions.assertArrayEquals (outArr,Main.checkArray(inArr));// use array references
    }
// Тесты к заданию 3
    @Test
    public void checkArrayOneAndFourTest1() {

        int[] inArr = new int[]{4, 1, 2, 1, 7};
        boolean answer = true;

        Assertions.assertEquals (answer, Main.checkArrayOneAndFour(inArr));
    }

    @Test
    public void checkArrayOneAndFourTest2() {

        int[] inArr = new int[]{4, 1, 2, 1, 7};
        boolean answer = true;

        Assertions.assertEquals (answer, Main.checkArrayOneAndFour(inArr));
    }
    @Test
    public void checkArrayOneAndFourTest3() {

        int[] inArr = new int[]{7, 6, 2, 7};
        boolean answer = false;

        Assertions.assertEquals (answer, Main.checkArrayOneAndFour(inArr));
    }
}