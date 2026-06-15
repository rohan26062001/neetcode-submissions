class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length;

        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else if(nums1[i] > nums2[j]) {
                list.add(nums2[j]);
                j++;
            } else {
                list.add(nums1[i]);
                list.add(nums1[i]);
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

        return findMedian(list);
    }

    public static double findMedian(List<? extends Number> sortedList) {
        if (sortedList == null || sortedList.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty.");
        }

        int size = sortedList.size();
        int middle = size / 2;

        // If the size is odd, return the exact middle element
        if (size % 2 != 0) {
            return sortedList.get(middle).doubleValue();
        } 
        // If the size is even, return the average of the two middle elements
        else {
            double leftMiddle = sortedList.get(middle - 1).doubleValue();
            double rightMiddle = sortedList.get(middle).doubleValue();
            return (leftMiddle + rightMiddle) / 2.0;
        }
    }
}
