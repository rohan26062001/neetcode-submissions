class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> s = new HashSet<>();

        for(int i = 0; i < arr.length - 2; i++) {
            int a = arr[i];
            
            int l = i+1, r = arr.length - 1;
            while(l < r) {
                int b = arr[l], c = arr[r];

                if(a + b + c == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    s.add(list);
                    l++; r--;
                } else if(a + b + c > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new ArrayList<>(s);
    }
}
