import java.util.*;

// Maximum Sum Subarray of Size K
class MaxSumSubarrayK {
    int maxSum(int[] arr, int k) {
        int sum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k) sum -= arr[i - k];
            if (i >= k - 1) max = Math.max(max, sum);
        }
        return max;
    }
}



// Count Distinct Elements in Every Window
class DistinctWindow {
    void countDistinct(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        System.out.print(map.size() + " ");

        for (int i = k; i < arr.length; i++) {
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if (map.get(arr[i - k]) == 0)
                map.remove(arr[i - k]);

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.print(map.size() + " ");
        }
    }
}




// First Negative Number in Every Window

class FirstNegative {
    void printFirstNegative(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int i = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < 0) q.add(j);

            if (j - i + 1 == k) {
                if (q.isEmpty()) System.out.print("0 ");
                else System.out.print(arr[q.peek()] + " ");

                if (!q.isEmpty() && q.peek() == i) q.poll();
                i++;
            }
        }
    }
}




// Longest Subarray with Sum = K (Positive Numbers)
class LongestSubarraySumK {
    int longest(int[] arr, int k) {
        int sum = 0, left = 0, maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > k) sum -= arr[left++];

            if (sum == k)
                maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}



//Subarray with Given Sum
class SubarraySum {
    ArrayList<Integer> subarraySum(int[] arr, int k) {
        int sum = 0, left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > k) sum -= arr[left++];

            if (sum == k)
                return new ArrayList<>(List.of(left + 1, right + 1));
        }
        return new ArrayList<>(List.of(-1));
    }
}



//Smallest Subarray with Sum ≥ K

class MinSubarraySum {
    int minLen(int[] arr, int k) {
        int sum = 0, left = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= k) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}




//Longest Substring Without Repeating Characters
class LongestUniqueSubstring {
    int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right)))
                set.remove(s.charAt(left++));

            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}



//Longest Substring with K Unique Characters
class LongestKUnique {
    int longest(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, max = -1;

        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0)
                    map.remove(s.charAt(left));
                left++;
            }
            if (map.size() == k)
                max = Math.max(max, right - left + 1);
        }
        return max;
    }
}




//Maximum of All Subarrays of Size K
class MaxInWindow {
    int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.addLast(i);

            if (i >= k - 1)
                res[idx++] = nums[dq.peekFirst()];
        }
        return res;
    }
}




//Minimum Window Substring
class MinWindowSubstring {
    String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                if (map.get(s.charAt(right)) > 0) count--;
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
            }

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}



