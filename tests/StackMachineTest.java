import org.junit.Test;
import static org.junit.Assert.*;

public class StackMachineTest {
    @Test
    public void sampleTests() throws Exception {
        System.out.println("\n******** SampleTests ********");
        assertEquals(76, StackMachine.solution("13+62*7+*"));
        assertEquals(9, StackMachine.solution("99*9"));
        assertEquals(730, StackMachine.solution("99*9*1+"));
    }

    @Test
    public void wrongArgumentsTests() throws Exception {
        System.out.println("\n******** WrongArgumentsTests ********");
        assertEquals(-1, StackMachine.solution("13+62*7-*"));
        assertEquals(-1, StackMachine.solution("abc1234+"));
        assertEquals(-1, StackMachine.solution("2+2=4"));
        assertEquals(-1, StackMachine.solution(""));
    }

    @Test
    public void emptyStackTests() throws Exception {
        System.out.println("\n******** EmptyStackTests ********");
        assertEquals(-1, StackMachine.solution("13+62*7+*+"));
        assertEquals(-1, StackMachine.solution("11++"));
        assertEquals(-1, StackMachine.solution("+56+"));
        assertEquals(-1, StackMachine.solution("+*+*+*++"));
        assertEquals(-1, StackMachine.solution("+*5+6*"));
    }

    @Test
    public void overflowIntegerTest() throws Exception {
        System.out.println("\n******** OverflowIntegerTest ********");
        StringBuilder sb = new StringBuilder();
        sb.append("99*");
        for(int i = 0; i < 1500; i++)
            sb.append("9*");
        assertEquals(9, StackMachine.solution(sb.toString()));
    }

    @Test
    public void longStringTest() throws Exception {
        System.out.println("\n******** LongStringTest ********");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 33333; i++)
            sb.append("55*44+");
        sb.append("2+");
        String S = sb.toString();
        System.out.println("Length of string: " + S.length());
        assertEquals(10, StackMachine.solution(S));
    }    
}