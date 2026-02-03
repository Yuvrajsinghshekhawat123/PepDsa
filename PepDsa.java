 import java.util.Scanner;
import java.util.*;

class ArrayReverser {
    void reverse(int[] arr, int ind) {
        if(ind >= arr.length / 2) return;
        
        int temp = arr[arr.length - ind - 1];
        arr[arr.length - ind - 1] = arr[ind];
        arr[ind] = temp;
        
        reverse(arr, ind + 1);
    }
    
    public void reverseArray(int arr[]) {
        reverse(arr, 0);
    }
}

class GroupReverser {
    static void reverse(int arr[], int start, int end) {
        if (end > arr.length) {
            end = arr.length;
        }
         
        int rangeSize = end - start;
         
        for (int i = 0; i < rangeSize / 2; i++) {
            int left = start + i;
            int right = end - 1 - i;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
    
    public void reverseInGroups(int[] arr, int k) {
        if (k <= 0) return;
        
        int i = 0;
        while(i < arr.length) {
            reverse(arr, i, (i + k));
            i += k;
        }
    }
}

class ArraySortedChecker {
    boolean solve(int[] arr, int ind) {
        if(ind >= arr.length - 1) return true;
        
        if(arr[ind] > arr[ind + 1]) return false;
        
        return solve(arr, ind + 1);
    }
     
    public boolean isSorted(int[] arr) {
        if(arr.length == 1) return true;
        return solve(arr, 0);
    }
}

class LargestElementFinder {
    public static int largest(int[] arr) {
        int max = 0;
        for(int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }
}

class MaxConsecutiveOnesCounter {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}

class ElementFrequencyCounter {
    int findFrequency(int arr[], int x) {
        int count = 0;
        for(int num : arr) {
            if(num == x) count++;
        }
        return count;
    }
}

class WordPairCounter {
    public int countWords(String list[], int n) {
        Map<String, Integer> freq = new HashMap<>();
        for(String str : list) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }
        int max = 0;
        
        for(int val : freq.values()) {
            if(val == 2) max++;
        }
        
        return max;
    }
}

class StockProfitCalculator {
    public int maxProfit(int[] prices) {
        int stock = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            if(stock > prices[i]) {
                stock = prices[i];
            }

            if(prices[i] > stock) {
                maxProfit = Math.max(maxProfit, prices[i] - stock);
            }
        }

        return maxProfit;
    }
}

class TwoSumChecker {
    boolean twoSum(int arr[], int target) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

class TripletSumChecker {
    public boolean hasTripletSum(int arr[], int tar) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        Arrays.sort(arr);
        int n = arr.length;
      
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] + arr[n - 2] + arr[n - 1] < tar) continue;
             
            int left = i + 1;
            int right = arr.length - 1;
             
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == tar) return true;
                else if(sum < tar) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return false;
    }
}

class DuplicateRemover {
    public int removeDuplicates(int[] nums) {
        int current = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[current - 1] != nums[i]) {
                nums[current++] = nums[i];
            }
        }
        return current;
    }
}

class ArrayMerger {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
         
        while(i >= 0 && j >= 0) {
            if(nums1[i] <= nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        
        while(i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }

        while(j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}

class ColorSorter {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int one = 0;
        int two = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) zeros++;
            else if(nums[i] == 1) one++;
            else {
                two++;
            }
        }

        int i = 0;

        while(zeros > 0) {
            nums[i++] = 0;
            zeros--;
        }
        while(one > 0) {
            nums[i++] = 1;
            one--;
        }
        while(two > 0) {
            nums[i++] = 2;
            two--;
        }
    }
}

class MaxSubarraySumFinder {
    public int maxSubarraySum(int[] arr, int k) {
        int sum = 0;
        int left = 0;
        int count = 0;
        int max = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            count++;
            
            while(count > k) {
                sum -= arr[left];
                left++;
                count--;
            }
            
            max = Math.max(sum, max);
        }
        
        return max;
    }
}

class FrequencyCounter {
    int countFreq(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        int first = -1;
        int last = -1;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(arr[mid] == target) {
                if(first == -1 || mid < first) first = mid;
                if(last == -1 || mid > last) last = mid;
                
                while(first - 1 >= left && arr[first - 1] == target) {
                    first--;
                }
                while(last + 1 <= right && arr[last + 1] == target) {
                    last++;
                }
                break;
            } 
            
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        if(first == -1) return 0;
        
        return last - first + 1;
    }
}

class RotatedArraySearcher {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) return mid;

            else if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}

class MinimumFinder {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[left] <= nums[mid]) {
                ans = Math.min(ans, nums[left]);
                left = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                right = mid - 1;
            }
        }
        return ans;
    }
}

class ShipmentCapacityCalculator {
    int solve(int[] weights, int MaxCap) {
        int load = 0;
        int days = 1;
        for(int i = 0; i < weights.length; i++) {
            if(load + weights[i] <= MaxCap) {
                load += weights[i];
            } else {
                load = weights[i];
                days++;
            }
        }

        return days;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        int ans = 0;
        
        for(int i = 0; i < weights.length; i++) {
            left = Math.max(weights[i], left);
            right += weights[i];
        }

        while(left <= right) {
            int mid = (left + right) / 2;

            int dayReq = solve(weights, mid);
            if(dayReq <= days) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

class NextGreatestLetterFinder {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        char ans = letters[0];

        while(left <= right) {
            int mid = (left + right) / 2;
            if(letters[mid] > target) {
                ans = letters[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}

class SubarraySumFinder {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            while(sum > target) {
                sum -= arr[left];
                left++;
            }
            
            if(sum == target) {
                list.add(left + 1);
                list.add(i + 1);
                return list;
            }
        }
        
        list.clear();
        list.add(-1);
        return list;
    }
}

class CircularSubarraySumCalculator {
    public int maxSubarraySumCircular(int[] arr) {
        int totalSum = 0;

        int currMax = 0, maxSum = Integer.MIN_VALUE;
        int currMin = 0, minSum = Integer.MAX_VALUE;

        for (int num : arr) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);

            totalSum += num;
        }

        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}

class PalindromeChecker {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

class IsomorphicStringChecker {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(mapST.containsKey(s.charAt(i))) {
                if(t.charAt(i) != mapST.get(s.charAt(i))) return false;
            }
            mapST.put(s.charAt(i), t.charAt(i));
        }

        for(int i = 0; i < t.length(); i++) {
            if(mapTS.containsKey(t.charAt(i))) {
                if(s.charAt(i) != mapTS.get(t.charAt(i))) return false;
            }
            mapTS.put(t.charAt(i), s.charAt(i));
        }

        return true;
    }
}

class FirstRepeatingCharFinder {
    String firstRepChar(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            if(freq[s.charAt(i) - 'a'] > 1) return String.valueOf(s.charAt(i));
        }
        
        return "-1";
    }
}

class WordReverser {
    public String reverseWords(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        StringBuilder str = new StringBuilder("");
        int n = arr.length;
        for(int i = n - 1; i >= 0; i--) {
            str.append(arr[i] + " ");
        }
        return str.toString().trim();
    }
}

class FibonacciCalculator {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

class InsertPositionFinder {
    int solve(int[] nums, int tar, int l, int r) {
        if(l > r) return l;
        
        int mid = (l + r) / 2;
        if(nums[mid] == tar) return mid;
        else if(nums[mid] < tar) return solve(nums, tar, mid + 1, r);
        else return solve(nums, tar, l, mid - 1);
    }
    
    public int searchInsert(int[] nums, int target) {
        return solve(nums, target, 0, nums.length - 1);
    }
}