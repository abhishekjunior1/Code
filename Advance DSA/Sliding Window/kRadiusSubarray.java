//https://leetcode.com/problems/k-radius-subarray-averages/
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) return nums;

        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        //min element to be present  for k element if n=9 then at least 7 elemnt to be present
        if (n < 2 * k + 1) return arr;

        long windowSum = 0;
        int left = 0, right = 2 * k;
        int i = k;

        // Initialize the first window sum
        for (int j = left; j <= right; j++) {
            windowSum += nums[j];
        }

        arr[i] = (int)(windowSum / (2 * k + 1));
        i++;
        left++;
        right++;

        // Slide the window
        while (right < n) {
            windowSum = windowSum - nums[left - 1] + nums[right];
            arr[i] = (int)(windowSum / (2 * k + 1));
            i++;
            left++;
            right++;
        }

        return arr;
    }
}
