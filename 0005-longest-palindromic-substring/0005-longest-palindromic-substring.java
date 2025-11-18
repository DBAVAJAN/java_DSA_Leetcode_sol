class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // 1) Transform string: "abba" -> "^#a#b#b#a#$"
        StringBuilder t = new StringBuilder();
        t.append('^');                // starting sentinel
        for (int i = 0; i < s.length(); i++) {
            t.append('#');
            t.append(s.charAt(i));
        }
        t.append("#$");               // ending sentinel

        char[] T = t.toString().toCharArray();
        int n = T.length;
        int[] P = new int[n];         // P[i] = radius of palindrome around i
        int C = 0, R = 0;             // current center and right boundary
        int bestCenter = 0, bestLen = 0;

        // 2) Main Manacher loop
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i;   // mirrored index of i around C

            // Use previously computed palindrome if inside current right boundary
            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Try to expand palindrome centered at i
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) {
                P[i]++;
            }

            // Update center and right boundary
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

            // Track best result
            if (P[i] > bestLen) {
                bestLen = P[i];
                bestCenter = i;
            }
        }

        // 3) Convert back to original string indices
        int start = (bestCenter - bestLen - 1) / 2;
        return s.substring(start, start + bestLen);
    }
}
