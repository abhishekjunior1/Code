//https://leetcode.com/problems/binary-subarrays-with-sum/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left=0,right=0,sum=0,ans=0;
        int countzero=0;
        int n= nums.length;
        while(right<nums.length){
            sum+=nums[right];
            while(left<right && (nums[left]==0 ||  sum>goal)){
                if(nums[left]==0){
                    countzero++;
                }else{
                    countzero=0;
                }
                sum-=nums[left];
                left++;

            }
            if(sum==goal) ans+=1+countzero;
            right++;
        }
        return ans;
    }
}