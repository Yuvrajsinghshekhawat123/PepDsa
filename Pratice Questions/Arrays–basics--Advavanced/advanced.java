 import java.util.*;

//Max Subarray Sum (Sliding Window – Fixed K)

class MaxSubarraySumFinder {
    public int maxSubarraySum(int[] arr, int k) {
        int sum = 0, max = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k) sum -= arr[i - k];
            if (i >= k - 1) max = Math.max(max, sum);
        }
        return max;
    }
}





// Subarray with Given Sum (Positive Numbers)
class SubarraySumFinder {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int sum = 0, left = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > target) sum -= arr[left++];

            if (sum == target)
                return new ArrayList<>(List.of(left + 1, i + 1));
        }
        return new ArrayList<>(List.of(-1));
    }
}




//Maximum Circular Subarray Sum
class CircularSubarraySumCalculator {
    public int maxSubarraySumCircular(int[] arr) {
        int total = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int currMax = 0, currMin = 0;

        for (int num : arr) {
            currMax = Math.max(num, currMax + num);
            max = Math.max(max, currMax);

            currMin = Math.min(num, currMin + num);
            min = Math.min(min, currMin);

            total += num;
        }

        return max < 0 ? max : Math.max(max, total - min);
    }
}



// Triplet Sum

class TripletSumChecker {
    public boolean hasTripletSum(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == target) return true;
                else if (sum < target) l++;
                else r--;
            }
        }
        return false;
    }
}




