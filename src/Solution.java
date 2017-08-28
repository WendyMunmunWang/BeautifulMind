import java.util.HashSet;
import java.util.Hashtable;

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
        if (new_result > Integer.MAX_VALUE || new_result < Integer.MIN_VALUE) {
            return 0;
        } else return (int) new_result;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
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
        } else {
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
        if (nums.length == 0) {
            return 0;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (target <= nums[i]) {
                    return i;
                }
            }
        }
        return nums.length;
    }

    public int maxSubArray(int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int sumAlt = 0;
        while (right <= nums.length && left <= nums.length) {
            if (nums[left] > 0) {
                if (right <= left) {
                    right++;
                    sum += nums[right];
                }
            } else {
                //reset the sum if left is changed
                left++;
                sum += nums[left];
            }
        }
        return sum;
    }

    public int lengthOfLastWord(String s) {
        int sum = 0;
        if (s.length() > 0) {
            for (int i = s.length(); i > 0; i--) {
                String item = s.substring(i - 1, i);
                if (item.equals(" ") && sum != 0) {
                    break;
                } else if (item.equals(" ") && sum == 0) {
                    continue;
                } else {
                    sum++;
                }
            }
        }
        return sum;
    }

    public String addBinary(String a, String b) {
        String result = new String();
        int length = 0;
        if (a.length() < b.length()) {
            length = a.length();
        } else {
            length = b.length();
        }
        int ptr = 0;
        int tracker = 0;
        while (ptr <= length) {
            String item_result = new String();
            String item_a = a.substring(ptr - 1, ptr);
            String item_b = b.substring(ptr - 1, ptr);
            if (Integer.parseInt(item_a) == 1 && Integer.parseInt(item_b) == 1) {
                item_result = "0";
                tracker = 1;
            } else if (Integer.parseInt(item_a) == 1 && Integer.parseInt(item_b) == 0) {
                item_result = "1";
            } else if (Integer.parseInt(item_a) == 0 && Integer.parseInt(item_b) == 1) {
                item_result = "1";
            } else if (Integer.parseInt(item_a) == 0 && Integer.parseInt(item_b) == 0) {
                item_result = "0";
            }
            if (tracker == 0) {
                result += item_result;
            }

        }
        return result;
    }

    public int length(int[] A) {
        int i = 0;
        int counter = 1;
        while (A[i] != -1) {
            i = A[i];
            counter++;
        }
        return counter;
    }

    public String reformatNumber(String S) {
        String three = new String();
        String result = new String();
        for (int i = 0; i < S.length(); i++) {
            String item = S.substring(i, i + 1);
            if (!item.equals(" ") && !item.equals("-")) {
                if (three.length() < 3) {
                    three += item;
                } else {
                    if (result.equals("")) {
                        result = three;
                    } else {
                        result = result + "-" + three;
                    }
                    three = item;
                }
            }
        }
        if (three.length() < 2) {
            String replace = result.substring(result.length() - 1, result.length());
            three = replace + three;
            result = result.substring(0, result.length() - 1);

        }
        if (result.equals("")){ result = three; }
        else { result = result + "-" + three; }
        return result;
    }

    public int elevator(int[] A, int[] B, int M, int X, int Y) {
        int totalWeight = 0;
        int totalPeople = 0;
        HashSet sameElevator = new HashSet<Integer>();
        int counter = 0;
        for (int i = 0; i < A.length; i++){
            //Add people in the elevator and store their targeted floors in the hashtable
            if (totalWeight+A[i] <= Y && totalPeople < X) {
                totalWeight += A[i];
                totalPeople++;
                sameElevator.add(B[i]);
            }
            //count the stop times based on the # of targeted floors in the hashtable
            else {
                counter += sameElevator.size() + 1;
                sameElevator = new HashSet();
                sameElevator.add(B[i]);
                totalPeople = 1;
                totalWeight = A[i];
            }
        }
        counter += sameElevator.size() + 1;
        return counter;
    }
}


