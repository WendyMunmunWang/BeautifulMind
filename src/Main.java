import java.util.Arrays;
import java.util.List;

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
        int[] singleNums = {2, 3, 5, 3, 2};
        System.out.println(sol.singleNumber(singleNums));
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        System.out.println(sol.generate(5));
        System.out.println(sol.generate(1));
        System.out.println(sol.generate(0));
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(1);
//        listNode1.next = listNode2;
//        listNode2.next = null;
//        System.out.println(sol.reverseLinkedList(listNode1));
//        int[] sortedArray = {3, 5, 8};
//        System.out.println(sol.sortedArrayToBST(sortedArray));
        int[] reverseArray = {1, 2};
        System.out.println(Arrays.toString(sol.rotate(reverseArray, 0)));
        String s1 = "dd";
        String s3 = "0p";
        System.out.println(sol.isPalindrome(s1));
        System.out.println(sol.isPalindrome(s3));
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = head.next;
//        System.out.println("Has cycle: " + sol.hasCycle(head));
        int[] errorNums = {2, 2};
        System.out.println(Arrays.toString(sol.findErrorNums(errorNums)));
        int[] flowerbed = {1, 0, 0, 0, 1, 1};
        System.out.println("flower: " + sol.canPlaceFlowers(flowerbed, 1));
        int[] checkPos = {2,3,3,2,4}; //should return true
        int[] checkPos2 = {4,2,3}; //should return true
        int[] checkPos3 = {1,2,3}; //should return true
        int[] checkPos4 = {3,4,2,3}; //should return false
        int[] checkPos5 = {-1, 4, 2, 3}; //should return true
        int[] checkPos6 = {4,2,1};//should return false
        int[] checkPos7 = {3,1};//should return true
        System.out.println(sol.checkPossibility(checkPos));
        System.out.println(sol.checkPossibility(checkPos2));
        System.out.println(sol.checkPossibility(checkPos3));
        System.out.println(sol.checkPossibility(checkPos4));
        System.out.println(sol.checkPossibility(checkPos5));
        System.out.println(sol.checkPossibility(checkPos6));
        System.out.println(sol.checkPossibility(checkPos7));
        int ssnum = 3;
        System.out.println("sum of square numbers: " + sol.judgeSquareSum(ssnum));
        String word = "FlaG";
        System.out.println("detect: " + sol.detectCapitalUse(word));
        System.out.println("perfect num: " + sol.checkPerfectNumber(1));
        int[] input = {1,4,3,2};
        System.out.println(sol.arrayPairSum(input));
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words2 = {"a", "b"};
        System.out.println(Arrays.toString(sol.findWords(words2)));
        int[] zeroNums = {0, 1, 0, 3, 2};
        System.out.println(Arrays.toString(sol.moveZeroes(zeroNums)));
        //System.out.println(Arrays.toString(sol.shiftLeft(zeroNums, 2, 2)));
        int[] missingNums = {0}; //should return 1
        int[] missingNums2 = {0,1,2};//should return 3
        int[] missingNums3 = {1, 2, 3};//should return 0
        int[] missingNums4 = {1};//should return 0
        System.out.println(sol.missingNumber(missingNums));
        System.out.println(sol.missingNumber(missingNums2));
        System.out.println(sol.missingNumber(missingNums3));
        System.out.println(sol.missingNumber(missingNums4));

    }
}
