class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<9; i++) q.add(i);

        while(!q.isEmpty()){
            int n = q.poll();
            if(n > high) break;
            if(n >= low) ans.add(n);

            int last_digit = n%10;
            if(last_digit + 1 <= 9){
                q.add(n*10 + (last_digit+1));
            }
        }

        return ans;
    }
}