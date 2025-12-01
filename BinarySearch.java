public class BinarySearch {

    public static int binarySearch(int[] array, int keyValue){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        for(int i =1; i < array.length; i++){
            if (array[i - 1] > array[i]){
                throw new IllegalArgumentException("Array must be sorted for binary search.");
            }
        }

        int start = 0;
        int end = array.length - 1;

        while (start <= end){
            int mid =  start + ((end - start) / 2);
            
            if (array[mid] == keyValue) {
                return mid;
            } else if (array[mid] < keyValue){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        int[] sortedArray = {2, 4, 6, 8, 10, 12, 14};
        int key = 12;
        int foundIndex = binarySearch(sortedArray, key);
        if(foundIndex == -1){
            System.out.println("The value was not found in the array.");
        }else {
            System.out.println("The value was found at index " + foundIndex);
        }
    }
}
