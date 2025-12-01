public class ReverseWordString {
    public static void reverseWord(char[] ar, int s, int e) {
        while (s < e) {
            char temp = ar[s];
            ar[s] = ar[e];
            ar[e] = temp;
            s++;
            e--;
        }
    }

    public static String reverse(String s) {
        char[] arr = s.toCharArray();
        int start = 0;

        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length || arr[i] == ' ') {
                reverseWord(arr, start, i - 1);
                start = i + 1;
            }
        }
        String result = new String(arr);
        return result;
    }

    public static void main(String args[]) {
        String str = "Let's take LeetCode contest";

        System.out.println("Output : " + reverse(str));
    }
}
