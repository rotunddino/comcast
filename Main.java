import java.util.Arrays;
import static org.junit.Assert.*;

public class Main {
    public static void main(String[] args) {
        positiveNumbersWithAnswersInTheMiddle();
        positiveNumbersWithAnswersAtTheEnds();
        negativeNumbersWithAnswersInMiddleAndEnd();
    }
    public static void positiveNumbersWithAnswersInTheMiddle() {
        int[] numbers = new int[]{3,5,12,16};
        int target = 17;
        int[] expected = new int[]{2,3};

        int[] answer = twoSum(numbers, target);
        assertArrayEquals(expected, answer);
    }

    public static void positiveNumbersWithAnswersAtTheEnds() {
        int[] numbers = new int[]{1,5,24};
        int target = 25;
        int[] expected = new int[]{1,3};

        int[] answer = twoSum(numbers, target);
        assertArrayEquals(expected, answer);
    }

    public static void negativeNumbersWithAnswersInMiddleAndEnd() {
        int[] numbers = new int[]{-1000,0,1,5,24};
        int target = 25;
        int[] expected = new int[]{3,5};

        int[] answer = twoSum(numbers, target);
        assertArrayEquals(expected, answer);
    }

    /** Two sum sorted **/
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        // go from left and right towards middle
        while(left <= right) {
            int sum = numbers[left] + numbers[right];

            if (sum > target) {
                // overshot target, move right pointer towards middle to get a smaller number
                right--;
            } else if (sum < target) {
                // under target, move left pointer towards middle to get a bigger number
                left++;
            } else {
                // found the two numbers that add up to target
                break;
            }
        }

        return new int[]{left + 1, right + 1}; // +1 to accommodate for 1 indexed array
    }
}
