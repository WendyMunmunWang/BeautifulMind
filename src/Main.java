/**
 * Created by wendywang on 2017-08-26.
 */
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));
        System.out.println(sol.isPalindrome(-2147447412));
        int[] testArray = {1,1,3,3};
        System.out.println(sol.removeDuplicates(testArray));
        System.out.println(sol.removeElement(testArray, 3));
        System.out.println(sol.searchInsert(testArray, 2));
        String testString = "My ";
        System.out.println(sol.lengthOfLastWord(testString));
        int[] testArraylength = {1,4,-1,3,2};
        System.out.println(sol.length(testArraylength));
        String phoneNumber = "0 ----- 1";
        System.out.println(sol.reformatNumber(phoneNumber));
        int[] elevatorA = {60, 80, 40};
        int[] elevatorB = {2, 3, 5};
        System.out.println(sol.elevator(elevatorA, elevatorB, 5, 2, 200));
    }
}
