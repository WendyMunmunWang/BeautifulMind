import com.sun.xml.internal.ws.wsdl.parser.MemberSubmissionAddressingWSDLParserExtension;

import javax.print.attribute.standard.Chromaticity;
import java.util.*;
import java.util.Map.Entry;

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
            if (tracker == 0) { result = item_result + result; }
            else {
                result = item_result + result;

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
                //reset all the tracking variables
                sameElevator = new HashSet();
                sameElevator.add(B[i]);
                totalPeople = 1;
                totalWeight = A[i];
            }
        }
        counter += sameElevator.size() + 1;
        return counter;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) { return true; }
        else if ((p == null && q != null) || (p != null && q == null)){
            return false;
        }
        //both p and q are not null
        else if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {return null;}
        else {
            List<Integer> result = new ArrayList<>();
            int item = root.val;
            result.add(item);
        }

        return null;
    }

    public List<Integer> findAnagrams(String s, String p) {
        String p_sub = p;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length()-p.length(); i++){
            p_sub = p;
            String item = s.substring(i, p.length()+i);
            if (isAnagram(item,p_sub)) { result.add(i); }
        }
        return result;
    }
    //assume both string a and string b are the same length
    public boolean isAnagram(String a, String b) {
        if (a.length() == 0 && b.length() == 0) { return true; }
        else {
            for (int i = 0; i < a.length(); i++){
                String item = a.substring(i, i+1);
                if (b.indexOf(item) == -1) {
                    break;
                }
                else { b = b.replace(item, ""); }
            }
            if (b.length() == 0) { return true; }
            else return false;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        else if (root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean isHappy(int n) {
        int result = 0;
        int remain = n;
        if (n < 0) return false;
        else {
            while ( remain != 0 ){
                int item = remain % 10;
                result += Math.pow(item, 2);
                remain = (remain - item) / 10;
            }
            if (result == 1) {
                return true;
            }
            else return isHappy(result);
        }
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        else {
            int min = 0;
            int ptr = 1;
            int max = 1;
            int diff = prices[max] - prices[min];
            while (ptr < prices.length){
                if (prices[ptr] < prices[min]) {
                    min = ptr;
                    max = ptr;
                }
                if (prices[ptr] > prices[max]) {
                    max = ptr;
                    if (diff < (prices[max] - prices[min])) {
                        diff = prices[max] - prices[min];
                    }
                }
                ptr++;
            }
            if (diff > 0) return diff;
            else return 0;
        }
    }

    public int singleNumber(int[] nums) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++){
            int item = nums[i];
            if (hashMap.containsKey(item)){
                hashMap.remove(item);
            }
            else {
                hashMap.put(item, 1);
            }
        }
        return (Integer) hashMap.keySet().toArray()[0];
    }

    public List<List<Integer>> generate(int numRows) {
        int rowNumber = 0;
        List<List<Integer>> result = new ArrayList<>();
        if (numRows > 0) {
            List itemResult;
            while (rowNumber < numRows) {
                itemResult = new ArrayList();
                itemResult.add(1);
                if (result.size() > 0) {
                    List lastList = result.get(result.size() - 1);
                    if (lastList.size() > 1) {
                        for (int i = 0; i < lastList.size() - 1; i++) {
                            int item = (Integer) lastList.get(i) + (Integer) lastList.get(i + 1);
                            itemResult.add(item);
                        }
                    }
                    itemResult.add(1);
                }
                result.add(itemResult);
                rowNumber++;
            }
        }
        return result;
    }

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }
        else {
            ListNode curr = head;
            ListNode prev = null;
            ListNode next = null;
            while (curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        else {
            int mid = (int) Math.floor(nums.length/2);
            TreeNode tree = new TreeNode(nums[mid]);
            if (mid-1 >= 0){
                int[] leftArray = Arrays.copyOfRange(nums, 0, mid);
                tree.left = sortedArrayToBST(leftArray);
            }
            else if (nums.length-1 >= mid+1){
                int[] rightArray = Arrays.copyOfRange(nums, mid+1, nums.length);
                tree.right = sortedArrayToBST(rightArray);
            }
            return tree;
        }
    }

    public int[] rotate(int[] nums, int k) {
        if (nums != null && nums.length > 1){
            reverseArray(nums, 0, k);
            reverseArray(nums, k+1, nums.length-1);
            reverseArray(nums, 0, nums.length-1);
        }
        return nums;
    }

    public void reverseArray(int[] nums, int left, int right){
        while (left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public boolean isPalindrome(String s) {
        int leftptr = 0;
        int rightptr = s.length()-1;
        s = s.toLowerCase();
        while (leftptr < rightptr){
            char leftItem = s.charAt(leftptr);
            char rightItem = s.charAt(rightptr);
            if ( leftItem == rightItem
                    && Character.isLetterOrDigit(leftItem)
                    && Character.isLetterOrDigit(rightItem)){
                leftptr++;
                rightptr--;
            }
            else if (!Character.isLetterOrDigit(leftItem)){
                leftptr++;
            }
            else if (!Character.isLetterOrDigit(rightItem)){
                rightptr--;
            }
            else return false;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        else {
            ListNode ptr = head.next;
            ListNode fastPtr = head.next;
            if (fastPtr == null || ptr == null){
                return false;
            }
            while(ptr != fastPtr){
                fastPtr = fastPtr.next.next;
                ptr = ptr.next;
                if (fastPtr == null || ptr == null){
                    return false;
                }
            }
            return true;
        }
    }

    public int[] findErrorNums(int[] nums) {
        if (nums.length == 0) return null;
        else {
            int i = 0;
            int item;
            int max = Integer.MIN_VALUE;
            int sum = 0;
            int repeat = 0;
            int[] result = new int[2];
            Set set = new HashSet();
            while (i < nums.length){
                item = nums[i];
                if (max < item){ max = item;}
                    if (!set.contains(item)) {
                        set.add(item);
                    }
                    else repeat = item;

                sum = sum + item;
                i++;
            }
            int realSum = ((1 + max)*nums.length)/2;
            int missingNum = realSum - (sum-repeat);
            if (set.contains(missingNum)){
                missingNum = max + 1;
            }
            result[0] = repeat;
            result[1] = missingNum;
            return result;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        else {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++){
                if (!set.contains(nums[i])){set.add(nums[i]);}
                else {return true;}
            }
            return false;
        }
   }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++){
            int item = nums[i];
            if (hashMap.containsKey(item)){
                hashMap.put(item, (int)hashMap.get(item)+1);
            }
            else{
                hashMap.put(item, 1);
            }
        }
        Iterator<Entry<Integer, Integer>> entries = hashMap.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) entries.next();
            if (entry.getValue() > Math.floor(nums.length/2)){
                return entry.getKey();
            }
        }
        return 0;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        int sizeA = 0;
        int sizeB = 0;
        while (ptrA != null){
            ptrA = ptrA.next;
            sizeA++;
        }
        while (ptrB != null){
            ptrB = ptrB.next;
            sizeB++;
        }
        if (sizeA == sizeB) return headA;
        else if (sizeA > sizeB) {
            int lengthDiff = sizeA - sizeB;
            ListNode ptr = headA;
            while (lengthDiff > 0){
                ptr = ptr.next;
                lengthDiff--;
            }
            ptrB = headB;
            while (ptr != null && ptrB != null){
                ptr = ptr.next;
                ptrB = ptrB.next;
                if (ptr == ptrB ){ return ptr; }
            }
        }
        else {
            int lengthDiff = sizeB - sizeA;
            ListNode ptr = headB;
            while (lengthDiff > 0){
                ptr = ptr.next;
                lengthDiff--;
            }
            ptrA = headA;
            while (ptrA != null && ptr != null){
                ptrA = ptrA.next;
                ptr = ptr.next;
                if (ptr == ptrA){ return ptr; }
            }
        }
        return null;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n){
        if (flowerbed == null || flowerbed.length < 2*n-1){
            return false;
        }
        boolean isEdge = true;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++){
            int item = flowerbed[i];
            if (isEdge == true && 0 <= i && i <= 2*n-1){
                if (item != 0){
                    isEdge = false;
                    count = 2*n+1;
                }
                else if (item == 0 && isEdge == true){
                    return true;
                }
            }
            else {
                if (item == 1 && count > 0){
                    count=2*n+1;
                }
                else if (count==0) {
                    return true;
                }
                else if (item == 0 && i == flowerbed.length-1 && count==1){
                    return true;
                }
                else count--;
            }
        }
        return false;
    }

    public boolean checkPossibility(int[] nums){
        if (nums == null || nums.length == 0){
            return false;
        }
        else if (nums.length > 2){
            boolean foundTarget = false;
            for (int i = 0; i + 2< nums.length; i++){
                int item = nums[i];
                if (i == 0){
                    if (item > nums[i+1]){
                        foundTarget = true;
                        nums[i] = nums[i+1];
                    }
                }
                else if (i > 0 && i + 2 < nums.length){
                    if (item >= nums[i-1] && item <= nums[i+1]){
                        continue;
                    }
                    else if ((item < nums[i-1] || item > nums[i+1]) && nums[i] <= nums[i+2]){
                        if (foundTarget == false) {
                            foundTarget = true;
                            nums[i] = nums[i-1];
                        }
                        else return false;
                    }
                    else if ((item < nums[i-1] || item > nums[i+1]) &&
                            (nums[i] <= nums[i+2]||nums[i-1] <= nums[i+1])){
                        if (foundTarget == false) {
                            foundTarget = true;
                            nums[i] = nums[i-1];
                        }
                        else return false;
                    }
                    else if ((item < nums[i-1] || item > nums[i+1]) &&
                             (nums[i] > nums[i+2]||nums[i-1] > nums[i+1])){
                        return false;
                    }
                }
            }
            if (nums[0] > nums[nums.length-1]){
                return false;
            }
            else return true;
        }
        else {
            return true;
        }
    }

    public boolean judgeSquareSum(int c) {
        if (c<=0){
            return false;
        }
        else {
            int sum = 0;
            int n = c;
            while (n > 0){
                if (c == n*n){ return true; }
                else if (n*n > c){ n--; }
                else {
                    sum += n*n;
                    n--;
                }
            }
            if (sum == c){ return true; }
            else return false;
        }
    }

    public int maximumProduct(int[] nums) {
        if (nums.length >= 3){
            Arrays.sort(nums);
            return Math.max(nums[0]* nums[1]* nums[nums.length-1],
                    nums[nums.length-1]* nums[nums.length-2]* nums[nums.length-3] );
        }
        else return 0;
    }

    public boolean detectCapitalUse(String word) {
        int cat = -1;
        int innercat = -1;
        if (word == null || word.length() == 0){
            return false;
        }
        else if (word.length() == 1){
            return true;
        }
        else {
            for (int i = 0; i < word.length(); i++){
                String item = word.substring(i, i+1);
                if (i==0) {
                    if (item.equals(item.toUpperCase())) {cat = 1;}
                    else {cat = 2;}
                }
                else if (i==1){
                    if (cat == 1){
                        if (item.equals(item.toUpperCase())) {innercat = 1;}
                        else {innercat = 2;}
                    }
                    else if (cat == 2){
                        if (item.equals(item.toUpperCase())) {return false;}
                    }
                }
                else {
                    if (cat == 1 && innercat == 1){
                        if (!item.equals(item.toUpperCase())){ return false;}
                    }
                    else if (cat == 1 && innercat == 2){
                        if (item.equals(item.toUpperCase())){ return false;}
                    }
                    else if (cat == 2){
                        if (item.equals(item.toUpperCase())){ return false; }
                    }
                }
            }
            return true;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        else {
            ListNode result = new ListNode(0);
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode reptr = result;
            while (p1.next != null && p2.next != null){
                int item = p1.val + p2.val;
                if (item >= 10) {
                    item = item % 10;
                }
                reptr.val = item;
                p1 = p1.next;
                p2 = p2.next;
                reptr = reptr.next;

            }
            if (p1.next == null && p2.next == null){
                return result;
            }
            else {
                if (p1.next == null && p2.next != null){
                    while (p2.next != null){
                        reptr.val = p2.val;
                        p2 = p2.next;
                        reptr = reptr.next;
                    }
                }
                else if (p1.next != null && p2.next == null){
                    while (p1.next != null){
                        reptr.val =  p1.val;
                        p1 = p1.next;
                        reptr = reptr.next;
                    }
                }
                return result;
            }
        }

    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 0 || num >= Integer.MAX_VALUE) {return false;}
        int divisor = 1;
        int otherdiv = num/divisor;
        int sum = 0;
        while (divisor < num && divisor <= otherdiv){
            if (num % divisor != 0){
                divisor++;
                otherdiv = num/divisor;
            }
            else {
                sum += divisor;
                if (otherdiv != num){
                    sum += otherdiv;
                }
                divisor++;
                otherdiv = num/divisor;
            }
        }
        if (sum == num) {return true;}
        else {return false;}
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int i = 0;
        while (i < nums.length){
            sum += nums[i];
            i = i + 2;
        }
        return sum;
    }

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0){
            String[] emptyArray = new String[0];
            return emptyArray;
        }
        String[] firstRow = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
        String[] secondRow = {"a", "s", "d", "f", "g", "h", "j", "k", "l"};
        String[] thirdRow = {"z", "x", "c", "v", "b", "n", "m"};
        Set firstSet = new HashSet();
        Set secondSet = new HashSet();
        Set thirdSet = new HashSet();
        int i = 0;
        while (i < firstRow.length){
            firstSet.add(firstRow[i]);
            i++;
        }
        int j = 0;
        while (j < secondRow.length){
            secondSet.add(secondRow[j]);
            j++;
        }
        int k = 0;
        while (k < thirdRow.length){
            thirdSet.add(thirdRow[k]);
            k++;
        }
        i = 0;
        ArrayList<String> result = new ArrayList();
        while (i < words.length){
            String item = words[i];
            if (item.length() == 0){
                i++;
                continue;
            }
            else if (item.length() == 1){
                result.add(item);
                i++;
                continue;
            }
            int cat = 0;
            for (int itemIndex = 0; itemIndex < item.length(); itemIndex++){
                String letter = item.substring(itemIndex, itemIndex+1);
                letter = letter.toLowerCase();
                if (firstSet.contains(letter) && itemIndex == 0){ cat = 1; }
                else if (secondSet.contains(letter) && itemIndex == 0){ cat = 2; }
                else if (thirdSet.contains(letter) && itemIndex == 0){ cat = 3; }
                else {
                    if ((!firstSet.contains(letter) && cat == 1) ||
                            (!secondSet.contains(letter) && cat == 2) ||
                            (!thirdSet.contains(letter) && cat == 3)) {
                        break;
                    }
                    else if ((firstSet.contains(letter) && cat == 1 && itemIndex == item.length()-1) ||
                            (secondSet.contains(letter) && cat == 2 && itemIndex == item.length()-1) ||
                            (thirdSet.contains(letter) && cat == 3 && itemIndex == item.length()-1)) {
                        result.add(item);
                    }
                }
            }
            i++;
        }
        String[] resultArray = new String[result.size()];
        resultArray = result.toArray(resultArray);
        return resultArray;
    }

    public String reverseString(String s) {
        if (s == null ){
            return null;
        }
        else if (s.length() == 0) {
            return "";
        }
        char[] word = s.toCharArray();
        int left = 0;
        int right = s.length()-1;
        while (left < right){
            char temp = word[left];
            word[left] = word[right];
            word[right] = temp;
            left++;
            right--;
        }
        return new String(word);
    }

    public int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        int i = 0;
        int shiftNum = 0;
        while (i < nums.length){
            int item = nums[i];
            if (item == 0){
                shiftNum++;
                i++;
            }
            else if (item != 0 && shiftNum > 0){
                shiftLeft(nums, i, shiftNum);
                if (i == nums.length-1){
                    break;
                }
                else {
                    i = 0;
                    shiftNum = 0;
                    continue;
                }
            }
            else if (item != 0 && shiftNum == 0){
                i++;
            }
        }
        return nums;
    }

    public void shiftLeft(int[] nums, int fromIndex, int shiftNum){
        int replace = fromIndex - shiftNum;
        if (replace >= 0){
            int i = fromIndex;
            while (replace < fromIndex){
                nums[replace] = nums[i];
                if (i < nums.length - 1){
                    replace++;
                    i++;
                }
                else {
                    replace++;
                    break;
                }

            }
            while (replace < nums.length){
                nums[replace] = 0;
                replace++;
            }
        }
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0;
        while (i + 1 < nums.length) {
            int curr = nums[i];
            int next = nums[i + 1];
            if (curr + 1 == next) {
                i++;
            } else return curr + 1;
        }
        if (nums[0] == 0) {
            return nums[nums.length - 1] + 1;
        }
        return 0;
    }

    public int arrangeCoins(int n) {
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE){
            return -1;
        }
        int i = 1;
        while (n > 0){
            n = n - i;
            if (n == 0){
                return i;
            }
            else if (n < 0){
                return i - 1;
            }
            i++;
        }
        return 0;
    }

    public boolean canConstruct(String ransomNote, String magazine) {

    }



}
