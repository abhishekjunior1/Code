//https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/?envType=daily-question&envId=2025-06-18
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans[][]= new int[nums.length/3][3];
        int n=nums.length;
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]>k){
                return new int[0][0];
            }
            ans[i/3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}