import java.util.*;

// Reverse a String
class ReverseString {
    String reverse(String s) {
        char[] ch = s.toCharArray();
        int l = 0, r = ch.length - 1;

        while (l < r) {
            char temp = ch[l];
            ch[l++] = ch[r];
            ch[r--] = temp;
        }
        return new String(ch);
    }
}




//Check Palindrome
class PalindromeCheck {
    boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }
}




//Count Vowels and Consonants

class VowelCount {
    int countVowels(String s) {
        int count = 0;
        s = s.toLowerCase();

        for (char c : s.toCharArray())
            if ("aeiou".indexOf(c) != -1) count++;
        return count;
    }
}




//First Repeating Character
class FirstRepeatingChar {
    char firstRepeat(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (++freq[c - 'a'] > 1) return c;
        }
        return '#';
    }
}


//Reverse Words in a String

class ReverseWords {
    String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--)
            sb.append(arr[i]).append(" ");

        return sb.toString().trim();
    }
}


// Check Anagram
class AnagramCheck {
    boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        for (char c : t.toCharArray()) freq[c - 'a']--;

        for (int x : freq)
            if (x != 0) return false;
        return true;
    }
}




//Isomorphic Strings
class IsomorphicString {
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




// Longest Common Prefix
class LongestPrefix {
    String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);
        }
        return prefix;
    }
}




//Longest Substring Without Repeating Characters
class LongestUniqueSubstring {
    int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0, max = 0;

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r)))
                set.remove(s.charAt(l++));
            set.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}



//Longest Palindromic Substring

class LongestPalindrome {
    int maxLen=-1;
    int start=0;
    String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int start = 0, maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);     // odd
            expand(s, i, i + 1); // even
        }
        return s.substring(start, start + maxLen);
    }

    void expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > maxLen) {
                start = l;
                maxLen = r - l + 1;
            }
            l--; r++;
        }
    }
}



//Minimum Window Substring
class MinWindow {
    String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int l = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                if (map.get(s.charAt(r)) > 0) count--;
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
            }

            while (count == 0) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }
                if (map.containsKey(s.charAt(l))) {
                    map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    if (map.get(s.charAt(l)) > 0) count++;
                }
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}




// /Group Anagrams

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



