import java.util.*;

//Binary Search (Classic)
class BinarySearch {
    int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}



// Binary Search (Recursive)
class BinarySearchRec {
    int search(int[] arr, int target, int l, int r) {
        if (l > r) return -1;

        int mid = (l + r) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] > target)
            return search(arr, target, l, mid - 1);
        return search(arr, target, mid + 1, r);
    }
}



//First Occurrence of Element
class FirstOccurrence {
    int first(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                ans = mid;
                r = mid - 1;
            } else if (arr[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return ans;
    }
}



// Last Occurrence of Element
class LastOccurrence {
    int last(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                ans = mid;
                l = mid + 1;
            } else if (arr[mid] < x) l = mid + 1;
            else r = mid - 1;
        }
        return ans;
    }
}



//Count Frequency of Element
class CountFrequency {
    int count(int[] arr, int x) {
        int first = first(arr, x);
        if (first == -1) return 0;
        int last = last(arr, x);
        return last - first + 1;
    }

    int first(int[] arr, int x) { /* same as above */ return 0; }
    int last(int[] arr, int x) { /* same as above */ return 0; }
}




//Search Insert Position
class SearchInsert {
    int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}



//Floor of a Number
class Floor {
    int floor(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= x) {
                ans = arr[mid];
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }
}


//Ceil of a Number
class Ceil {
    int ceil(int[] arr, int x) {
        int l = 0, r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid];
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }
}



//Search in Rotated Sorted Array

class RotatedSearch {
    int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;

            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid])
                    r = mid - 1;
                else l = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}



//Find Minimum in Rotated Sorted Array
class FindMin {
    int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, ans = Integer.MAX_VALUE;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] <= nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                r = mid - 1;
            }
        }
        return ans;
    }
}



//Capacity to Ship Packages

class ShipCapacity {
    int daysReq(int[] w, int cap) {
        int load = 0, days = 1;
        for (int x : w) {
            if (load + x <= cap) load += x;
            else {
                days++;
                load = x;
            }
        }
        return days;
    }

    int shipWithinDays(int[] w, int days) {
        int l = 0, r = 0, ans = 0;
        for (int x : w) {
            l = Math.max(l, x);
            r += x;
        }

        while (l <= r) {
            int mid = (l + r) / 2;
            if (daysReq(w, mid) <= days) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }
}




//Allocate Minimum Pages
class AllocatePages {
    boolean possible(int[] arr, int students, int mid) {
        int pages = 0, count = 1;
        for (int x : arr) {
            if (pages + x <= mid) pages += x;
            else {
                count++;
                pages = x;
            }
        }
        return count <= students;
    }
}


