import java.util.*;



//Reverse an Array (Recursion)
class ArrayReverser {
    void reverse(int[] arr, int ind) {
        if (ind >= arr.length / 2) return;

        int temp = arr[ind];
        arr[ind] = arr[arr.length - ind - 1];
        arr[arr.length - ind - 1] = temp;

        reverse(arr, ind + 1);
    }

    public void reverseArray(int[] arr) {
        reverse(arr, 0);
    }
}






//Reverse Array in Groups of K
class GroupReverser {
    static void reverse(int[] arr, int start, int end) {
        if (end > arr.length) end = arr.length;

        while (start < end - 1) {
            int temp = arr[start];
            arr[start++] = arr[--end];
            arr[end] = temp;
        }
    }

    public void reverseInGroups(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += k) {
            reverse(arr, i, i + k);
        }
    }
}




//Check if Array is Sorted (Recursion)

class ArraySortedChecker {
    boolean solve(int[] arr, int ind) {
        if (ind >= arr.length - 1) return true;
        if (arr[ind] > arr[ind + 1]) return false;
        return solve(arr, ind + 1);
    }

    public boolean isSorted(int[] arr) {
        return arr.length == 1 || solve(arr, 0);
    }
}




//Largest Element in Array
class LargestElementFinder {
    public static int largest(int[] arr) {
        int max = arr[0];
        for (int num : arr) max = Math.max(max, num);
        return max;
    }
}



//Max Consecutive Ones
class MaxConsecutiveOnesCounter {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;

        for (int num : nums) {
            if (num == 1) count++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}




//Frequency of an Element
class ElementFrequencyCounter {
    int findFrequency(int[] arr, int x) {
        int count = 0;
        for (int num : arr)
            if (num == x) count++;
        return count;
    }
}




//Best Time to Buy & Sell Stock
class StockProfitCalculator {
    public int maxProfit(int[] prices) {
        int min = prices[0], profit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}




// Two Sum (HashSet)
class TwoSumChecker {
    boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) return true;
            set.add(num);
        }
        return false;
    }
}



//Remove Duplicates (Sorted Array)
class DuplicateRemover {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[idx - 1])
                nums[idx++] = nums[i];
        }
        return idx;
    }
}




//Merge Two Sorted Arrays
class ArrayMerger {
    public void merge(int[] a, int m, int[] b, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0)
            a[k--] = (a[i] > b[j]) ? a[i--] : b[j--];

        while (j >= 0)
            a[k--] = b[j--];
    }
}





//Sort Colors (Dutch National Flag – Counting)
class ColorSorter {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;

        for (int num : nums) {
            if (num == 0) zero++;
            else if (num == 1) one++;
            else two++;
        }

        int i = 0;
        while (zero-- > 0) nums[i++] = 0;
        while (one-- > 0) nums[i++] = 1;
        while (two-- > 0) nums[i++] = 2;
    }
}






