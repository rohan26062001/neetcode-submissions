class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = maxArray(piles), minVal = Integer.MAX_VALUE;

        while(l <= r) {
            int mid = (l+r)/2;
            int time = timeNeeded(piles, mid);
            if(time <= h) {
                minVal = Math.min(mid, minVal);
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return minVal;
    }

    private int timeNeeded(int[] a, int mid) {
        int time = 0;
        for(int num : a) {
            if(num%mid==0)
                time+=(num/mid);
            else
                time+=(num/mid+1);
        }
        return time;
    }

    private int maxArray(int[] a) {
        int maxE = -1;
        for(int num : a) {
            maxE = Math.max(maxE, num);
        }
        return maxE;
    }
}
