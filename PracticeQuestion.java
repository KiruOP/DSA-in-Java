import java.util.Arrays;

public class PracticeQuestion {
    // Q Check whether a given array is sorted in non-decreasing order.
    public static boolean isSortedinAsec(int[] arr) {
        // array size is 1
        if (arr.length == 0 || arr.length == 1)
            return true;

        // check the array is sorted is non descending order
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    // Helper method to count even
    public static int countEven(int[] arr) {
        int even = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                even++;
        }
        return even;
    }

    // Helper method to count odd
    public static int countOdd(int[] arr) {
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                odd++;
        }
        return odd;
    }

    // Q Count the number of even and odd elements in an array.
    public static void countEvenOdd(int[] arr) {
        System.out.print("even " + countEven(arr));
        System.out.print(" odd " + countOdd(arr));
        System.out.println();
    }

    // Q Find the first repeating element in an array (the element whose first
    // occurrence index is smallest).
    public static int firstRepeatEle(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    return arr[i];
            }
        }
        return -1;
    }

    // Q Move all zeroes to the end of the array while maintaining the relative
    // order of non-zero elements.
    public static void moveZerosEnd(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // insert non zero values to start
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // put remaining values to zeros
        for (int i = index; i < arr.length; i++) {
            arr[i] = 0;
        }

        printArray(arr);
    }

    // Q Find the maximum sum of a subarray (contiguous elements).
    public static int maxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        if (arr.length <= 0)
            return 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }

    // Q Sort an array using Bubble Sort and count the number of swaps performed.
    public static int countSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.print("Sorted Array: ");
        printArray(arr);
        return swaps;
    }

    // Q Given an array, determine whether it can be sorted using only one swap.
    // First Approach
    public static boolean oneSwap(int[] arr) {
        int swaps = 0;

        // sort using bubble sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    // count number of swaps
                    swaps++;

                    // more than one swap return immediate false
                    if (swaps > 1)
                        return false;
                }
            }
        }

        return true;
    }

    // Second Approach
    public static boolean oneSwap2(int[] arr) {
        int n = arr.length;

        // Create a copy of the array
        int[] sortedArr = arr.clone();

        // Sort the copied array
        Arrays.sort(sortedArr);

        int count = 0;

        // Count mismatched positions
        for (int i = 0; i < n; i++) {
            if (arr[i] != sortedArr[i]) {
                count++;
            }
        }

        // If mismatches are 0 or 2, one swap is enough
        return count == 0 || count == 2;
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] array1 = { 1, 3, 4, 5, 6, 2, 7 };
        int[] array2 = { 3, 1, 2 };
        int[] array3 = { 1, 2, 3, 4 };
        int[] array4 = {};

        System.out.println(oneSwap(array1));
        System.out.println(oneSwap(array2));
        System.out.println(oneSwap(array3));
        System.out.println(oneSwap(array4));

        // moveZerosEnd(array1);
        // moveZerosEnd(array2);
        // moveZerosEnd(array3);
        // moveZerosEnd(array4);
    }
}
