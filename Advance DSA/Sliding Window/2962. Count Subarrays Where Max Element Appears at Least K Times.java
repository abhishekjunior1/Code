//https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int left=0,right=0;
        long ans=0;
        int max= Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int count=0;
        while(right<n){
            if(nums[right]==max) count++;
            while(count>=k){
                ans+=n-right;
                if(nums[left]==max) count--;
                left++;
            }
            right++;
        }
        return ans;
    }
}