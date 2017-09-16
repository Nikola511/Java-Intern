import org.junit.Test;
import static org.junit.Assert.*;

public class WholeSquareCountTest {
    @Test
    public void sampleTests() throws Exception {
        System.out.println("\n******** SampleTests ********");
        assertEquals(3, WholeSquareCount.solution(4, 17));
        assertEquals(2, WholeSquareCount.solution(10, 25));
        assertEquals(21, WholeSquareCount.solution(100, 900));
        assertEquals(1, WholeSquareCount.solution(-10, 0));
    }

    @Test
    public void wrongArgumentsTest() throws Exception {
        System.out.println("\n******** WrongArgumentsTests ********");
        assertEquals(-1, WholeSquareCount.solution(82, 15));
    }

    @Test
    public void negativeTest() throws Exception {
        System.out.println("\n******** NegativeTest ********");
        assertEquals(0, WholeSquareCount.solution(-20, -2));
    }

    @Test
    public void maxNumbersTest() throws Exception {
        System.out.println("\n******** MaxNumbersTest ********");
        assertEquals(101, WholeSquareCount.solution(-10000, 10000));
    }

}