class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length - 1;
        int maxArea = 0;

        while(l < r) {
            int area = (r - l) * Math.min(h[l], h[r]);
            maxArea = Math.max(maxArea, area);
            if(h[l] > h[r])
                r--;
            else
                l++;
        }

        return maxArea;
    }
}
