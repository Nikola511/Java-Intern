import java.util.*;

class StackMachine {
    public static int solution(String S) {
        if(!S.matches("^([0-9\\+\\*])+$")) {
            System.out.println("Input string consists only of the: '[0-9]', '+' and/or '*'");
            return -1;
        }

        Stack stack = new Stack();
        long top = 0;   //Long type using to check the Integer.MAX_VALUE overflow
        int result = -1;

        String[] stringArray = S.split("");
        for(String str : stringArray) {
            try {
                if (str.matches("[0-9]")) {
                    stack.push(Integer.parseInt(str));
                } else {
                    top = ((Number) stack.pop()).longValue();
                    long next = ((Number) stack.pop()).longValue();
                    long newValue = str.equals("+") ? top + next : top * next;
                    if(newValue > Integer.MAX_VALUE) {
                        throw new StackOverflowError();
                    }
                    stack.push((int)newValue);
                }
                result = (int)stack.peek();
            }
            catch(EmptyStackException e) {
                System.out.println("Stack is emplty! Operation cancelling.");
                return -1;
            }
            catch(StackOverflowError e) {
                System.out.println("The new value is greater than the max possible!");
                return (int)top;
            }
        }
        return result;
    }
}
