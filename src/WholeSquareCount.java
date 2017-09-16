public class WholeSquareCount {
    public static int solution(int A, int B) {
        if(A > B) {
            System.out.println("Input error. A must be <= B");
            return -1;
        }
        if(B < 0) {
            System.out.println("Input error. B must be >= 0");
            return 0;
        }
        if(A < 0) {
            System.out.println("A -> 0. Decrease the number of iterations");
            A = 0;
        }

        int count = 0;
        for(int i = A; i <= B; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt % 1 == 0) {        //Root of the first found square
                while(Math.pow(sqrt++, 2) <= B)
                    count++;
                break;
            }
        }
        return count;
    }
}