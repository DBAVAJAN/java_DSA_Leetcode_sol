class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

      int n = nums1.length + nums2.length;
     int[] a = new int[n];
       for (int i = 0; i < nums1.length ; i++) {
        a[i] = nums1[i];
       }
       for (int i =0; i < nums2.length; i++) {
        a[nums1.length + i] = nums2[i];
       }
       Arrays.sort(a);
     if ( n % 2 == 0) {
          double c = (a[n/2-1] + a[n/2]) / 2.0;
          return c;
     } else {
       double c = a[n/2];
        return c;
     }
     }
}