//Approach 1 : recursion + Memo --> TLE 
class Solution {
    int MOD = 1_000_000_000 + 7 ;

    int t[][][];
    //nums = {200, 200, 200}; gcd at max would be 200

    public int gcd (int a, int b){ 
        return (b==0) ? a : gcd(b, a%b);
    }

    public int subsequencePairCount(int[] nums) {
        //initalize the memo 3d array with -1
        this.t = new int[201][201][201];
        for(int rows[][]: t){
            for(int cols[]: rows){
                Arrays.fill(cols, -1);
            }
        }

        // solve -> nums, idx 0, 1st GCD 0, 2nd GCD 0
        return solve (nums, 0, 0, 0);
    }

    public int solve (int[] nums, int i, int first, int second){
        if(i == nums.length){
            boolean bothNonEmpty = (first !=0 && second !=0);
            boolean bothMatch = (first == second);

            return (bothNonEmpty && bothMatch) ? 1 : 0;
        }

        if(t[i][first][second] != -1) 
            return t[i][first][second];

        int skip = solve(nums, i+1, first, second);
        int take1 = solve (nums, i+1, gcd(first, nums[i]), second);
        int take2 = solve (nums, i+1, first, gcd(second, nums[i]));

        return t[i][first][second] = (int)((0L + skip + take1 + take2) % MOD) ;
    }
}


// Approach 2: Bottom UP --> super easy 

class Solution { //TC: n* M * M;
    int MOD = 1_000_000_000 + 7 ;

    int t[][][];
    //nums = {200, 200, 200}; gcd at max would be 200

    public int gcd (int a, int b){ 
        return (b==0) ? a : gcd(b, a%b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for(int num: nums) maxVal = Math.max(maxVal, num);

        this.t = new int[n+1][maxVal+1][maxVal+1];

        //Base case
        for(int first = 0; first<=maxVal; first++){
            for(int second = 0; second <=maxVal; second++){
                boolean bothNonEmpty = (first !=0 && second !=0);
                boolean bothMatch = (first == second);
                t[n][first][second] = (bothNonEmpty && bothMatch) ? 1 : 0;
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int first = maxVal; first >= 0; first --){
                for(int second = maxVal; second >= 0; second--){
                    int skip = t[i+1][first][second];
                    int take1 = t[i+1][gcd(first,nums[i])][second];
                    int take2 = t[i+1][first][gcd(second, nums[i])];

                    t[i][first][second] = (int)((0L+skip+take1+take2)%MOD);
                }
            }
        }

        return t[0][0][0];
    }
}


// Approach 3 : Optimization in our Memo array --> improved space complexity

class Solution { //TC: n* M * M;
                //SC: M*M;
    int MOD = 1_000_000_000 + 7 ;

    int prev[][];

    public int gcd (int a, int b){ 
        return (b==0) ? a : gcd(b, a%b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        for(int num: nums) maxVal = Math.max(maxVal, num);

        this.prev = new int[maxVal+1][maxVal+1];

        //Base case
        for(int first = 0; first<=maxVal; first++){
            for(int second = 0; second <=maxVal; second++){
                boolean bothNonEmpty = (first !=0 && second !=0);
                boolean bothMatch = (first == second);
                prev[first][second] = (bothNonEmpty && bothMatch) ? 1 : 0;
            }
        }

        for(int i=n-1; i>=0; i--){
            int curr[][] = new int[maxVal+1][maxVal+1];
            for(int first = maxVal; first >= 0; first --){
                for(int second = maxVal; second >= 0; second--){
                    int skip = prev[first][second];
                    int take1 = prev[gcd(first,nums[i])][second];
                    int take2 = prev[first][gcd(second, nums[i])];

                    curr[first][second] = (int)((0L+skip+take1+take2)%MOD);
                }
            }
            prev = curr;
        }

        return prev[0][0];
    }
}