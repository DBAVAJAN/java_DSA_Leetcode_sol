class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
    HashSet<List<Integer>> set = new HashSet<>();
    if (n < 4) return new ArrayList<>();
       for (int i = 0; i < n-3; i++) {
        for (int j = i+1; j < n-2; j++) {
            for (int k =  j+1; k < n-1; k++) {
                for (int l = k+1; k < n; k++) {
                    int sum = nums[i]+ nums[j]+ nums[k]+ nums[l];
                    if (sum == target) {
                        List<Integer> list1 = new ArrayList<>(Arrays.asList( nums[i], nums[j], nums[k], nums[l]));
                         Collections.sort(list1);
                         set.add(list1);
                    }
                  
                 
                }
            }
        }
       }
      return new ArrayList<>(set);
    }
}