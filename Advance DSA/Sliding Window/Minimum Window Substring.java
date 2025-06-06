class Solution {
    public String minWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s2.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;
        int count = map.size();

        while (right < s1.length()) {
            char rightChar = s1.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0) count--;
            }

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s1.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) count++;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s1.substring(minStart, minStart + minLen);
    }

   
}