import java.util.*;

//1Reverse an Array (Using Recursion)
class ReverseArray {
    void reverse(int[] arr, int i) {
        if (i >= arr.length / 2) return;

        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;

        reverse(arr, i + 1);
    }
}





//Check if Array is Sorted
class CheckSorted {
    boolean isSorted(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        if (arr[i] > arr[i + 1]) return false;
        return isSorted(arr, i + 1);
    }
}





//Fibonacci Number
class Fibonacci {
    int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}



//Sum of Array Elements
class SumArray {
    int sum(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + sum(arr, i + 1);
    }
}



//Print Numbers 1 to N
class PrintNumbers {
    void print(int n) {
        if (n == 0) return;
        print(n - 1);
        System.out.print(n + " ");
    }
}



//Find Maximum Element in Array
class MaxElement {
    int max(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        return Math.max(arr[i], max(arr, i + 1));
    }
}



//Check Palindrome String
class Palindrome {
    boolean isPalindrome(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return isPalindrome(s, l + 1, r - 1);
    }
}



// Binary Search Using Recursion

class RecursiveBinarySearch {
    int search(int[] arr, int target, int l, int r) {
        if (l > r) return -1;

        int mid = (l + r) / 2;
        if (arr[mid] == target) return mid;
        if (arr[mid] > target)
            return search(arr, target, l, mid - 1);
        return search(arr, target, mid + 1, r);
    }
}



// Search Insert Position
class SearchInsert {
    int insert(int[] nums, int target, int l, int r) {
        if (l > r) return l;

        int mid = (l + r) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target)
            return insert(nums, target, mid + 1, r);
        return insert(nums, target, l, mid - 1);
    }
}



//Reverse String Using Recursion

class ReverseString {
    void reverse(char[] s, int l, int r) {
        if (l >= r) return;

        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;

        reverse(s, l + 1, r - 1);
    }
}


//Power of Number (xⁿ)
class Power {
    long pow(long x, int n) {
        if (n == 0) return 1;
        return x * pow(x, n - 1);
    }
}


//Count Occurrences in Array
class CountOccurrences {
    int count(int[] arr, int i, int x) {
        if (i == arr.length) return 0;
        return (arr[i] == x ? 1 : 0) + count(arr, i + 1, x);
    }
}

