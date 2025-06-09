//https://leetcode.com/problems/sliding-window-maximum/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k > n) return nums;

        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        int left = 0, right = 0, index = 0;

        while (right < n) {
            // Remove elements smaller than current from the back
            while (!dq.isEmpty() &&  nums[right] > nums[dq.peekLast()] ) {
                dq.removeLast();
            }

            dq.addLast(right);

            // Check window size
            if (right - left + 1 == k) {
                ans[index++] = nums[dq.peekFirst()];

                // Remove element going out of window
                if (dq.peekFirst() == left) {
                    dq.removeFirst();
                }

                left++; 
            }

            right++;
        }

        return ans;
    }
}
