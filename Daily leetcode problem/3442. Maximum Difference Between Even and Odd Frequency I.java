//https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/?envType=daily-question&envId=2025-06-10
class Solution {
    public int maxDifference(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies of all characters
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        int maxDiff = Integer.MIN_VALUE;

        // Step 2: Iterate over all character pairs (odd freq - even freq)
        for (char oddChar : freqMap.keySet()) {
            int freq1 = freqMap.get(oddChar);
            if (freq1 % 2 == 1) {
                for (char evenChar : freqMap.keySet()) {
                    int freq2 = freqMap.get(evenChar);
                    if (freq2 % 2 == 0) {
                        maxDiff = Math.max(maxDiff, freq1 - freq2);
                    }
                }
            }
        }

        return maxDiff;
    }
}
