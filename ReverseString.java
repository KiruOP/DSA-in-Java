public class ReverseString {
    public static String reverse(String s, int k){
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i += (2*k)){
            int start = i;
            int end = Math.min(i + (k - 1), charArray.length - 1);

            while(start < end){
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }

        return new String(charArray);
    }
    public static void main(String args[]){
        String givenString = "abcdefg";
        int kChar = 2;

        String result = reverse(givenString,kChar);
        System.out.println("Output :"+ result);
    }
}
