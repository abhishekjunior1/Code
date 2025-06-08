//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
class Solution {
    public int maxVowels(String s, int k) {
        int left =0, right=0,count=0;
        int temp=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') temp++;
            if(right-left+1==k){
                count =Math.max(temp,count);
                char st = s.charAt(left);
                if(st=='a'||st=='e'||st=='i'||st=='o'||st=='u') --temp;
                left++;
            }
            right++;
        }
        return count;
    }
}