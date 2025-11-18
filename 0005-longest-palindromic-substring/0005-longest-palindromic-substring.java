class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";     // handle empty
        String longestpalindrome = s.substring(0, 1);
        int longest = 1;                                  // match the initial string length
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {                 // allow j == i .. n-1
                String str = s.substring(i, j + 1);       // include j
                if (istrue(str) && str.length() > longest) {
                    longestpalindrome = str;
                    longest = str.length();
                }
            }
        }
        return longestpalindrome;
    }

    boolean istrue(String str) {
        StringBuffer sb = new StringBuffer(str);
        String str1 = sb.reverse().toString();
        return str1.equals(str);                          // already fixed
    }
}
