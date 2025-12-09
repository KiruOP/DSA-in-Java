public class lc3759 {
    // bruteforce approach O(n^2)
    public static int countKGreaterElements(int[] arr, int k) {
        int countElement = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int countGreater = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    countGreater = countGreater + 1;
                }
            }
            if (countGreater >= k) {
                countElement++;
            }
        }
        return countElement;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,2,1,1 };
        int k = 2;
        System.out.println("The no. of element: " + countKGreaterElements(arr, k));
    }
}
