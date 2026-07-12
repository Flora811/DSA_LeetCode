class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int sort[] = new int[n];
        for(int i=0; i<n; i++) sort[i] = arr[i];

        Arrays.sort(sort);

        Map<Integer, Integer> map = new HashMap<>();

        int rank = 1;
        for(int num: sort){
            if(!map.containsKey(num))
                map.put(num, rank++);
        }

        for(int i=0; i<n; i++) sort[i] = map.get(arr[i]);

        return sort;
    }
}