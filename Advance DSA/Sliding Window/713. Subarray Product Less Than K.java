//https://leetcode.com/problems/subarray-product-less-than-k/
//tC: O(n)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; 
        int left = 0, ans = 0;
        long p = 1;
        
        for (int right = 0; right < nums.length; right++) {
            p *= nums[right];
            while (p >= k) {
                p /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        
        return ans;
    }
}
