/**
 * Created by wendywang on 2017-08-26.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));
        System.out.println(sol.isPalindrome(-2147447412));
        int[] testArray = {1,1,2,3,3};
        System.out.println(sol.removeDuplicates(testArray));
        System.out.println(sol.removeElement(testArray, 3));
    }
}
