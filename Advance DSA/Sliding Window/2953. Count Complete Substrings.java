//https://leetcode.com/problems/count-complete-substrings/

class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int count = 0;
        int start = 0;

        while (start < n) {
            int end = start + 1;

            // Step 1: Find a valid segment (adjacent char diff ≤ 2)
            while (end < n && Math.abs(word.charAt(end) - word.charAt(end - 1)) <= 2) {
                end++;
            }

            // Step 2: Process this segment
            count += countValidSubstrings(word.substring(start, end), k);

            // Move to next segment
            start = end;
        }

        return count;
    }

    // Sliding window inside the segment
    private int countValidSubstrings(String segment, int k) {
        int n = segment.length();
        int res = 0;

        for (int numUnique = 1; numUnique <= 26; numUnique++) {
            int len = numUnique * k;
            if (len > n) break;

            int[] freq = new int[26];
            int uniqueCount = 0;
            int countK = 0;

            for (int i = 0; i < n; i++) {
                int idx = segment.charAt(i) - 'a';
                freq[idx]++;
                if (freq[idx] == 1) uniqueCount++;
                if (freq[idx] == k) countK++;
                if (i >= len) {
                    int oldIdx = segment.charAt(i - len) - 'a';
                    if (freq[oldIdx] == k) countK--;
                    freq[oldIdx]--;
                    if (freq[oldIdx] == 0) uniqueCount--;
                }

                if (i >= len - 1 && uniqueCount == numUnique && countK == uniqueCount) {
                    res++;
                }
            }
        }

        return res;
    }
}
