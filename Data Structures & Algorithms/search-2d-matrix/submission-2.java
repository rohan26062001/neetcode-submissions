class Solution {
    public boolean searchMatrix(int[][] mat, int t) {
        int i = 0, m = mat.length, j = mat[0].length - 1;

        while(i < m && j >= 0) {
            if(mat[i][j] == t)
                return true;
            else if(mat[i][j] > t)
                j--;
            else
                i++;
        }

        return false;
    }
}
