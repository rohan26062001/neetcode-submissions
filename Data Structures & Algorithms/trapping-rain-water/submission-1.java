class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int[] maxFromLeft = new int[n], maxFromRight = new int[n];
        maxFromLeft[0] = h[0]; maxFromRight[n-1]=h[n-1];

        // Filling maxFromLeft
        for(int i = 1; i < n; i++) {
            maxFromLeft[i] = Math.max(maxFromLeft[i-1], h[i]);
        }

        // Filling maxFromRight
        for(int i = n - 2; i >= 0; i--) {
            maxFromRight[i] = Math.max(maxFromRight[i+1], h[i]);
        }

        int maxWater = 0;
        for(int i = 0; i < n; i++) {
            maxWater += Math.min(maxFromLeft[i], maxFromRight[i]) - h[i];
        }

        return maxWater;
    }
}
