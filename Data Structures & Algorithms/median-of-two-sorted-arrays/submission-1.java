class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int m = n1 + n2;
        
        List<Integer> list = new ArrayList<>(m);

        int i = 0, j = 0;
        
        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else if(nums1[i] > nums2[j]) {
                list.add(nums2[j]);
                j++;
            } else {
                list.add(nums1[i]);
                list.add(nums2[j]);
                i++;
                j++;
            }
        }

        while(i < n1) {
            list.add(nums1[i]);
            i++;
        }

        while(j < n2) {
            list.add(nums2[j]);
            j++;
        }

        if(m % 2 == 1) {
            return (double) list.get((m+1)/2-1);
        } else {
            return (double) ((list.get(m/2-1)+list.get(m/2))/2.0);
        }
    }
}
