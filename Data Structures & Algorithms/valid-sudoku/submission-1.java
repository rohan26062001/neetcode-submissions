class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<String, Set<Integer>> sq = new HashMap<>();

        int n1 = board.length, n2 = board[0].length;

        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(board[i][j] == '.')
                    continue;
                
                int r = i, c = j, elem = board[i][j];
                String sq_key = (i / 3) + "_" + (j / 3);

                if((row.get(r) != null && row.get(r).contains(elem)) ||
                   (col.get(c) != null && col.get(c).contains(elem)) ||
                   (sq.get(sq_key) != null && sq.get(sq_key).contains(elem)))
                   return false;
                
                row.computeIfAbsent(r, (k) -> new HashSet<>()).add(elem);
                col.computeIfAbsent(c, (k) -> new HashSet<>()).add(elem);
                sq.computeIfAbsent(sq_key, (k) -> new HashSet<>()).add(elem);
            }
        }

        return true;
    }
}
