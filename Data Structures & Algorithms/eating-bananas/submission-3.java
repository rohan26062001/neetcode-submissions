class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        Integer minK = null;

        while(l <= r) {
            int mid = (l+r)/2;
            int hours = calculateHours(piles, mid);
            if(hours <= h) {
                if(minK == null)
                    minK = mid;
                else
                    minK = Math.min(minK, mid);
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return minK;
    }

    private int calculateHours(int[] piles, int k) {
        int hours = 0;
        int n = piles.length;
        for(int i = 0; i < n; i++) {
            if(piles[i] % k == 0) {
                hours += piles[i]/k;
            } else {
                hours += (piles[i]/k + 1);
            }
        }
        return hours;
    }
}
