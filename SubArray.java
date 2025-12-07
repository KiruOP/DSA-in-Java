public class SubArray {
    public static void printSubArray(int[] numbers){
        for(int i = 0; i<numbers.length; i++){
            for(int j = i; j < numbers.length; j++){
                for(int k = i; k <= j; k++){
                    System.out.print(numbers[k]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
    public static void countSubArray(int[] numbers){
        int count = 0;
        for(int i = 0; i<numbers.length; i++){
            for(int j = i; j < numbers.length; j++){
                for(int k = i; k <= j; k++){
                    System.out.print(numbers[k]);
                }
                count = count + 1;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total subarrays is " + count);
    }

    public static void sumOfSubArray(int[] numbers){
        for(int i = 0; i<numbers.length; i++){
            for(int j = i; j < numbers.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    System.out.print(numbers[k]);
                    sum = sum + numbers[k];
                }
                System.out.println("  Sum of this sub array is " + sum);
            }
            System.out.println();
        }
    }

    public static void minmaxSubArray(int[] numbers){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<numbers.length; i++){
            for(int j = i; j < numbers.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    System.out.print(numbers[k]);
                    sum = sum + numbers[k];
                }
                System.out.println("  Sum of this sub array is " + sum);
                if(sum > max) max = sum;
                if(sum < min) min = sum;
            }
            System.out.println();
        }

        System.out.println("Minimum sum is " + min);
        System.out.println("Maximum sum is " + max);
    }
    public static void main(String args[]){
        int[] numbers = {1,2,3,4,5};
        minmaxSubArray(numbers);
    }
}
