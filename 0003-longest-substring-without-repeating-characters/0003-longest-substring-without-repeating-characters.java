class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        // last seen index for ASCII characters; initialize to -1
        int[] last = new int[128];
        Arrays.fill(last, -1);

        int start = 0; // left pointer of window
        for (int end = 0; end < n; end++) {
            char c = s.charAt(end);
            // if this char was seen inside current window, move start
            if (last[c] >= start) {
                start = last[c] + 1;
            }
            last[c] = end; // update last seen index
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
