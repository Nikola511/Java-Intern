import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class MonotoneTest {
    @Test
    public void sampleTests() throws Exception {
        System.out.println("\n******** SampleTests ********");
        assertEquals(4, Monotone.solution(new int[] { 2, 2, 2, 2, 1, 2, -1, 2, 1, 3 }));
        assertEquals(3, Monotone.solution(new int[] { 1, 0, 0, 0, 1, 0 }));
        assertEquals(0, Monotone.solution(new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }));
        assertEquals(3, Monotone.solution(new int[] { 1, 2, 0, 0, 1, 2 }));
        assertEquals(8, Monotone.solution(new int[] { 2, 0, 1, 0, 0, 1, 2, 0, 0, 1, 2, 3, 3 }));
        assertEquals(15, Monotone.solution(new int[] { 78, 41, 9, 85, 49, 49, 52, 81, 94, 85, 15, 92, 98,
                74, 42, 14, 28, 30, 40, 97, 73, 87, 24, 74, 98, 25, 84, 39 }));
    }

    @Test
    public void smallArrayTests() throws Exception {
        System.out.println("\n******** smallArrayTests ********");
        assertEquals(0, Monotone.solution(new int[] { 1024 }));
        assertEquals(0, Monotone.solution(new int[] { 0, 1 }));
    }

    @Test
    public void wrongArrayLengthTests() throws Exception {
        System.out.println("\n******** WrongArrayLengthTests ********");
        assertEquals(-1, Monotone.solution(new int[] {}));
        int[] arr = new int[150001];
        for(int i = 0; i < arr.length; i++)
            arr[i] = 0;
        assertEquals(-1, Monotone.solution(arr));
    }

    static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    @Test
    public void longArrayTest() throws Exception {
        System.out.println("\n******** LongArrayLengthTest ********");
        int[] arr = new int[150000];
        final int min = -1000, max = 1000;
        for(int i = 0; i < 100000; i++)
            arr[i] = getRandom(min, max);
        int curr = arr[100000] = min;
        for(int i = 100001; i < 100100; i++)
            arr[i] = curr += 20;
        for(int i = 100100; i < 150000; i++)
            arr[i] = getRandom(min, max);
        System.out.println("Array length: " + arr.length);
        assertEquals(100000, Monotone.solution(arr));
    }
}