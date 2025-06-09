//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int max1=helper(answerKey,k,'T');
        int max2=helper(answerKey,k,'F');
        return Math.max(max1,max2);
    }
    static int helper(String str,int k,char ch){
        int left=0,right=0,maxi=0,count=0;
        int n=str.length();
        while(right<n){
            if(str.charAt(right)==ch) count++;
            while(count > k){
                if(str.charAt(left)==ch) count--;
                left++;
            }
            maxi=Math.max(maxi,right-left+1);
            right++;
        }
        return maxi;
    }
}