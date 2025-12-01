public class ReverseArray {
    public static void reverseArray(int[] array){
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        for(int start = 0, end = array.length - 1; start < end; start++, end--){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
        }
    }
    public static void main(String args[]){
        int[] givenArray = {1,2,3,4,5,6,7};
        System.out.println("Before reversing array :");
        for (int i = 0; i < givenArray.length; i++){
            System.out.print(givenArray[i]);
        }
        System.out.println();

        reverseArray(givenArray);

        System.out.println("Reversed array :");
        for (int i = 0; i < givenArray.length; i++){
            System.out.print(givenArray[i]);
        }
        System.out.println();
    }
}
