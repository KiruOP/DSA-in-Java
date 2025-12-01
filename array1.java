import java.util.Scanner;

public class array1 {
    public static int linearSearch(String array[], String key){
        for (int i = 0; i < array.length; i++){
            if (array[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);

        String fruits[] = {"apple","mango","banana","jerry"};
        String key = "rose";

        int index = linearSearch(fruits,key);

        if (index == -1){
            System.out.println("Item not found in array.");
        } else {
            System.out.println("Item fount at index " + index);
        }

        scan.close();
    }
}
