import java.util.*;

//Count Frequency of Elements
class FrequencyCounter {
    Map<Integer, Integer> countFreq(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 1);
        return map;
    }
}




// Find Frequency of One Element
class ElementFrequency {
    int frequency(int[] arr, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        return map.getOrDefault(x, 0);
    }
}




// First Repeating Element
class FirstRepeating {
    int firstRepeating(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (!set.add(x)) return x;
        }
        return -1;
    }
}



//Check if Two Arrays Are Equal
class ArraysEqual {
    boolean areEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : a)
            map.put(x, map.getOrDefault(x, 0) + 1);

        for (int x : b) {
            if (!map.containsKey(x)) return false;
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) map.remove(x);
        }
        return map.isEmpty();
    }
}



//Two Sum (HashSet)

class TwoSum {
    boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(target - x)) return true;
            set.add(x);
        }
        return false;
    }
}



//Count Pairs with Given Sum
class CountPairs {
    int countPairs(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int x : arr) {
            count += map.getOrDefault(sum - x, 0);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return count;
    }
}



//Longest Subarray with Sum = K
class LongestSubarraySumK {
    int longestSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) maxLen = i + 1;

            if (!map.containsKey(sum))
                map.put(sum, i);

            if (map.containsKey(sum - k))
                maxLen = Math.max(maxLen, i - map.get(sum - k));
        }
        return maxLen;
    }
}



// Subarray with Zero Sum
class ZeroSumSubarray {
    boolean hasZeroSum(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int x : arr) {
            sum += x;
            if (sum == 0 || set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
}




//Count Distinct Elements in Window
class DistinctInWindow {
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



//Isomorphic Strings
class IsomorphicStrings {
    boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (mapST.containsKey(a) && mapST.get(a) != b) return false;
            if (mapTS.containsKey(b) && mapTS.get(b) != a) return false;
            mapST.put(a, b);
            mapTS.put(b, a);
        }
        return true;
    }
}



//First Non-Repeating Character
class FirstNonRepeating {
    char firstNonRepeat(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : s.toCharArray())
            if (map.get(c) == 1) return c;

        return '#';
    }
}


//Group Anagrams
class GroupAnagrams {
    List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}



