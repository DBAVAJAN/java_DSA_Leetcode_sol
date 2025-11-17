class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closetsum = nums[0] + nums[1] + nums [2];

        for (int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;
            while (left < right) {
                int cursum = nums[i] + nums[left] + nums[right];
                if (Math.abs(cursum-target) < Math.abs(closetsum - target)) {
                    closetsum = cursum;
                }
                if (cursum < target) {
                    left++;
                } else if (cursum > target) {
                    right--;
                } else {
                    return cursum;
                }
            }


        }
       return closetsum;
    }
}