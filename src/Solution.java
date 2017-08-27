/**
 * Created by wendywang on 2017-08-26.
 */
public class Solution {
    public int reverse(int x) {
        int item;
        long new_result = 0;
        int result = x;
        while (result != 0) {
            item = result % 10;
            result = (result - item) / 10;
            new_result = new_result * 10 + item;
        }
        if (new_result > Integer.MAX_VALUE || new_result < Integer.MIN_VALUE) {return 0;}
        else return (int)new_result;
    }

    public boolean isPalindrome(int x){
        if (x < 0)
        {
            return false;
        }
        else {
            int item;
            int remain_x = x;
            long new_x = 0;
            while (remain_x != 0) {
                item = remain_x % 10;
                remain_x = (remain_x - item) / 10;
                new_x = new_x * 10 + item;
            }
            return x == (int) new_x;
        }
    }

    public int removeDuplicates(int[] nums) {
        int scanner = 0;
        int looper = 0;
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        else {
            while (scanner < nums.length) {
                if (nums[scanner] != nums[looper]) {
                    looper++;
                    nums[looper] = nums[scanner];

                }
                scanner++;
            }
        }
        return ++looper;
    }

    public int removeElement(int[] nums, int val) {
        int scanner = 0;
        int looper = 0;
        if (nums.length > 0) {
            while (scanner < nums.length) {
                if (nums[scanner] != val) {
                    nums[looper] = nums[scanner];
                    looper++;
                }
                scanner++;
            }
        }
        return looper;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) { return 0; }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (target <= nums[i]) { return i; }
            }
        }
        return nums.length;
    }

    public String countAndSay(int n) {
        return null;
    }
}
