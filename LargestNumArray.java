public class LargestNumArray {
    public static int findLargestNumber(int[] array){

        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        int largestNumber = Integer.MIN_VALUE;
        
        for (int num : array){
            if (largestNumber < num){
                largestNumber = num;
            }
        }
        return largestNumber;
    }
    public static void main(String args[]){
        int[] array = {1000, 42, 68, 10, 50};
        int maxValue = findLargestNumber(array);
        System.out.println("Largest number in the array is " + maxValue);
    }
}
