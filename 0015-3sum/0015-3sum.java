import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);                // O(n log n)
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // skip duplicate 'i' values
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right]; // use long to be safe
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;   // need a bigger sum
                } else {
                    right--;  // need a smaller sum
                }
            }
        }
        return res;
    }
}
