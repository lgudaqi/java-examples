import java.util.Arrays;
import java.util.Stack;

/**
 * Contains multiple methods as an example
 * to present a procedural approach to java programming.
 * @author Linda Gudaqi
 */
public class static_methods {

    /**
     * Determines whether the given String-object
     * is a palindrome.
     * @param inputWord String-object to test.
     * @return Whether the String-object is a palindrome.
     */
    public static boolean isPalindrome(String inputWord) {
        /*
            First the input word is put into lower case
            since lower- and uppercase-chars are not equal.
            Then one counter variable moves from the beginning
            of the String-object forwards
            and one from the end of the String-object backwards
            while checking whether the value at the index
            of the value of the first
            and the second counter variable are the same.
            If that's not the case at some point,
            the boolean-variable is set to false.
         */
        String word = inputWord.toLowerCase();
        boolean isPalindrome = true;
        int j = word.length() - 1;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(j)) {
                isPalindrome = false;
            }
            j--;
        }
        return isPalindrome;
    }

    /**
     * Calculates the checksum of a given int-value.
     * @param inputNumber Input number.
     * @return Sum of all numerals of the number.
     */
    public static int checksum(int inputNumber) {
        /*
            If the input number is 10 or greater,
            it's devided by 10 and given to the same method
            until it's lesser than 10.
            The recursive structure of the method
            builds the  calculation
            of the checksum by dividing the problem
            into smaller pieces.
         */
        return (inputNumber < 10)
                ? inputNumber
                : (inputNumber % 10) + checksum(inputNumber / 10);
    }

    /**
     * Flips an array of String-objects.
     * @param inputArray Array to flip.
     * @return Array flipped.
     */
    public static String[] flipArray(String[] inputArray) {
        /*
            Declaring and initializing a new stack and pushing
            each component of the input array on top of it.
         */
        Stack<String> stack = new Stack<>();
        for (String s : inputArray) {
            stack.push(s);
        }

        /*
            Declaring a new array for output and initializing it
            with the length of the input array before filling it
            with the values from the top of the stack.
         */
        String[] outputArray = new String[inputArray.length];
        for(int i = 0; i < inputArray.length; i++) {
            outputArray[i] = stack.pop();
        }
        return outputArray;
    }

    /**
     * Tests the specified methods.
     * @param args Not used.
     */
    public static void main(String[] args) {
        /*
            Testing of the isPalindrome-method.
            The first line printed is supposed to be true,
            the second also true and the third false.
         */
        System.out.println(isPalindrome("radar"));
        System.out.println(isPalindrome("Eye"));
        System.out.println(isPalindrome("random"));

        /*
            Testing of the checksum-method.
            The first line printed is supposed to be 30
            and the second 7.
         */
        System.out.println(checksum(6789));
        System.out.println(checksum(7));

        /*
            Testing of the flipArray-method.
            The printed output is supposed to be
            [first, second, third].
         */
        String[] flippedArray = flipArray(new String[]{"third", "second", "first"});
        System.out.println(Arrays.toString(flippedArray));
    }
}
