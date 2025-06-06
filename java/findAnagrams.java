import java.util.*;

public class findAnagrams {

    static boolean allzero(Map<Character, Integer> map) {
        for (int value : map.values()) {
            if (value != 0) return false;
        }
        return true;
    }

    public List<Integer> findAnagram(String txt, String pat) {
        int k = pat.length();
        Map<Character, Integer> map = new HashMap<>();

        // Initialize the map with the frequency of characters in the pattern
        for (int i = 0; i < k; i++) {
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int n = txt.length();
        List<Integer> list = new ArrayList<>();

        while (right < n) {
            char ch = txt.charAt(right);

            // Decrement the frequency of the current character in the map
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            }

            // When the window size is equal to the pattern length
            if ((right - left + 1) == k) {
                // If all frequencies are zero, it's an anagram
                if (allzero(map)) {
                    list.add(left);
                }

                // Move the left pointer and increment the frequency of the character going out of the window
                char leftChar = txt.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }
            right++;
        }

        return list;
    }

    public static void main(String[] args) {
        findAnagrams solution = new findAnagrams();
        
        // Example input
        String txt = "cbaebabacd";
        String pat = "abc";
        
        // Find all anagrams of the pattern in the text
        List<Integer> anagramIndices = solution.findAnagram(txt, pat);
        
        // Output the results
        System.out.println("Anagram indices: " + anagramIndices);
    }
}
