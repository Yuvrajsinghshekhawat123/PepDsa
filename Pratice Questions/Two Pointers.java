import java.util.*;

//Reverse an Array
class ReverseArray {
    void reverse(int[] arr, int ind) {
        if (ind >= arr.length / 2) return;

        int temp = arr[ind];
        arr[ind] = arr[arr.length - ind - 1];
        arr[arr.length - ind - 1] = temp;

        reverse(arr, ind + 1);
    }
}



// Reverse Array in Groups
class ReverseArrayInGroups {
    static void reverse(int arr[], int start, int end) {
        if (end > arr.length) end = arr.length;

        int rangeSize = end - start;
        for (int i = 0; i < rangeSize / 2; i++) {
            int left = start + i;
            int right = end - 1 - i;

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
}



// Remove Duplicates from Sorted Array

class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[current - 1] != nums[i]) {
                nums[current++] = nums[i];
            }
        }
        return current;
    }
}


// Merge Two Sorted Arrays
class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}





//Triplet Sum (Two Pointer)
class TripletSum {
    public boolean hasTripletSum(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) return true;
                else if (sum < target) left++;
                else right--;
            }
        }
        return false;
    }
}



 