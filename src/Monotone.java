public class Monotone {
    static int solution(int[] A) {
        if(A.length == 0 || A.length > 150000) {
            System.out.println("Array length must be in the range [1..150,000];");
            return -1;
        }
        if(A.length < 3) return 0;

        int maxSize = 1;            int currentSize = 1;
        int startOfMaxAscSlice = 0; int startOfCurrentSlice = 0;

        //Loop with step = maxSize (increase), check of the left and right areas
        for (int i = 1; i < A.length; i += maxSize) {
            if(A[i] > A[i-1]) {
                currentSize++;
                for (int j = 0; j < maxSize; j++) {         //search to left from i
                    int k = i - j;
                    if (k <= 1) {                           //check for left bound of Array
                        maxSize = currentSize;
                        startOfMaxAscSlice = startOfCurrentSlice;
                        break;
                    }
                    if (A[k-1] > A[k-2]) {
                        currentSize++;
                        startOfCurrentSlice = k - 2;
                    } else break;
                }
                if (startOfCurrentSlice < i - 1)
                    for (int j = 0; ; j++) {                 //search to right from i
                        int k = i + j;
                        if (k + 1 >= A.length) {             //check for right bound of Array
                            if (currentSize > maxSize)
                                return startOfCurrentSlice;
                            break;
                        }
                        if (A[k + 1] > A[k]) currentSize++;
                        else {
                            i += j + 1;
                            break;
                        }
                    }
                if (currentSize > maxSize) {
                    maxSize = currentSize;
                    startOfMaxAscSlice = startOfCurrentSlice;
                }
            }
            currentSize = 1;
            startOfCurrentSlice = i;
        }
        return startOfMaxAscSlice;
    }
}
