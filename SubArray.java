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

    //bruteforce approach O(n^3)
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

    //prefix array approach O(n^2) better than bruteforce approach
    public static void prefixArray(int[] numbers){
        int[] prefix = new int[numbers.length];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        prefix[0] = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i; j < numbers.length; j++){
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if(max < sum) max = sum;
                if(min > sum) min = sum;
            }
        }
        System.out.println("Minimum : " + min);
        System.out.println("Maximum : " + max);
    }
    
    //Optimal approach O(n) Kadane's Algorithm
    public static void kadanes(int[] numbers){
        int maxSum = Integer.MIN_VALUE;
        int maxCurrent = 0;
        int minSum = Integer.MAX_VALUE;
        int minCurrent = 0;

        for(int i = 0; i < numbers.length; i++){
            maxCurrent += numbers[i];
            if(maxSum < maxCurrent) maxSum = maxCurrent;
            if(maxCurrent < 0) maxCurrent = 0;
            
            minCurrent += numbers[i];
            if(minSum > minCurrent) minSum = minCurrent;
            if(minCurrent > 0) minCurrent = 0;
        }
        
        System.out.println("Minimum : " + minSum);
        System.out.println("Maximum : " + maxSum);
    }

    public static void main(String args[]){
        int[] numbers = {-2,-4, -5, -3};
        kadanes(numbers);
    }
}
