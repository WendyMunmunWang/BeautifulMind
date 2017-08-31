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
        String anagram_a = "abc";
        String anagram_b = "bca";
        System.out.println(sol.isAnagram(anagram_a, anagram_b));
        String a = "ababababab";
        String b = "aab";
        System.out.println(sol.findAnagrams(a, b));
        System.out.println(sol.isHappy(19));
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};
        int[] prices3 = {3, 7, 2, 9};
        System.out.println(sol.maxProfit(prices1));
        System.out.println(sol.maxProfit(prices2));
        System.out.println(sol.maxProfit(prices3));
    }
}
