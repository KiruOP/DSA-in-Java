public class lc3759 {
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            arr[start + x] = temp[x];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static int sortRemDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        mergeSort(nums, start, end);

        return removeDuplicates(nums);
    }

    // optimal approach O(nlogn) by sorting and removing duplicates
    // failed for some test cases.
    public static int countGreaterElements(int[] nums, int k) {
        int uniqueElements = sortRemDuplicate(nums);
        return (uniqueElements - k) < 0 ? 0 : (uniqueElements - k);
    }

    // bruteforce approach O(n^2)
    // failed for some test cases on leetcode with time limit exceeded
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
