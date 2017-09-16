public class Extreme {
    public static int solution(int[] A) {
        if(A.length == 0 || A.length > 100000) return -1;

        int maxValue = A[0], maxIndex = 0;
        int minValue = A[0], minIndex = 0;
        int sum = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i] > maxValue) {
                maxValue = A[i];
                maxIndex = i;
            }
            else if(A[i] < minValue) {
                minValue = A[i];
                minIndex = i;
            }
            sum += A[i];
        }
        double average = sum * 1.0 / A.length;

        return Math.abs(minValue - average) > Math.abs(maxValue - average) ? minIndex : maxIndex;
    }
}
