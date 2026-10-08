class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowIndices = new HashMap<>();
        Map<Integer, Set<Integer>> colIndices = new HashMap<>();
        Map<String, Set<Integer>> sqIndices = new HashMap<>();

        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                if(board[r][c] == '.')
                    continue;
                else {
                    int element = board[r][c];
                    // 1. Check and Put in rowIndices
                    Set<Integer> newSet;
                    Set<Integer> s = rowIndices.get(r);
                    if(s == null) {
                        newSet = new HashSet<>();
                        newSet.add(element);
                        rowIndices.put(r, newSet);
                    } else {
                        if(s.contains(element))
                            return false;
                        else
                            s.add(element);
                    }
                    // 2. Check and Put in colIndices
                    s = colIndices.get(c);
                    if(s == null) {
                        newSet = new HashSet<>();
                        newSet.add(element);
                        colIndices.put(c, newSet);
                    } else {
                        if(s.contains(element))
                            return false;
                        else
                            s.add(element);
                    }
                    // 3. Check and Put in sqIndices
                    String key = (r / 3) + "_" + (c / 3);
                    s = sqIndices.get(key);
                    if(s == null) {
                        newSet = new HashSet<>();
                        newSet.add(element);
                        sqIndices.put(key, newSet);
                    } else {
                        if(s.contains(element))
                            return false;
                        else
                            s.add(element);
                    }
                }
            }
        }

        return true;
    }
}
