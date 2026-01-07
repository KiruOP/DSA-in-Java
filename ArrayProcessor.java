/**
 * Processes an ArrayList of integers according to specific criteria and transforms values.
 * 
 * For each element in the array:
 * - If the number's last digit is 6 or -6 AND the number is greater than 48, set to -1
 * - If the number's last digit is 6 or -6 (but not greater than 48), set to -5
 * - If the number is greater than 48 (but last digit is not 6 or -6), set to -3
 * 
 * @param array an ArrayList of integers to process
 * @return the size of the processed array
 */
import java.util.*;

public class ArrayProcessor {
    public static int processArray(ArrayList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);

            boolean isAcceptable = (num % 10 == 6 || num % 10 == -6);
            boolean isUnacceptable = (num > 48);

            if (isAcceptable && isUnacceptable) {
                array.set(i, -1);
            } else if (isAcceptable) {
                array.set(i, -5);
            } else if (isUnacceptable) {
                array.set(i, -3);
            }
        }
        return array.size();
    }

    public static void main (String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine().trim();
            Scanner lineScanner = new Scanner(line);
            if (lineScanner.hasNextInt()) {
                int num = lineScanner.nextInt();
                if (lineScanner.hasNext()) {
                    // If line is not exactly one integer, ignore it
                    continue;
                }
                if (num == -1) 
                    break;
                arrayList.add(Integer.valueOf(num));
            }
            lineScanner.close();
        }
        int new_length = processArray(arrayList);
        for(int i=0; i<new_length; i++)
            System.out.println(arrayList.get(i));
        in.close();
    }
}
