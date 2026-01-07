public class BasicSorting {
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j -1] < arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            int largest = i;
            for(int j = i; j < arr.length; j++){
                if(arr[largest] < arr[j]){
                    largest = j;
                }
            }
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int prev = i - 1;
            while(prev >= 0 && arr[prev] < curr){
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev+1]=curr;
        }
    }

    public static void countingSort(int[] arr){
        //find largest element
        int largest = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > largest){
                largest = arr[i];
            }
        }

        //frequency array
        int[] freq = new int[largest + 1];

        //count freq of elements
        for(int i = 0; i < arr.length; i++){
            freq[arr[i]]++;
        }

        //insert element in descending order
        int j = 0;
        for(int i = freq.length-1; i >= 0; i--){
            while(freq[i]>0){
                arr[j] = i;
                j++;
                freq[i]--;
            }
        }
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String arg[]){
        int[] array = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
        countingSort(array);
        printArray(array);
    }
}
