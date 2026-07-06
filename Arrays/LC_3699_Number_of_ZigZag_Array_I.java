class Solution { // TC: O(N*M) -> due to cumulative sum :))
    int m, n;
    int MOD = 1000_000_000 + 7;
    long t[][][];
    public int zigZagArrays(int n, int l, int r) {
        this.m = r-l+1;
        this.n = n;

        //[2001][2001][2]
        this.t = new long[n+1][m+1][2];
        for(int prevVal = 1; prevVal <= m; prevVal++){
            t[n][prevVal][0] = 1;
            t[n][prevVal][1] = 1;
        }

        for(int i=n-1; i>=0; i--){

            long cumSumI[] = new long[m+1];
            long cumSumD[] = new long[m+1];
            for(int val=1; val <= m; val++){
                cumSumD[val] = (cumSumD[val-1] + t[i+1][val][0]) % MOD;
                cumSumI[val] = (cumSumI[val-1] + t[i+1][val][1]) % MOD;
            }
            
            for(int prevVal=1; prevVal <= m; prevVal++){

                //increasing
                t[i][prevVal][1] = (cumSumD[m] - cumSumD[prevVal] + MOD) % MOD;
                
                //decreasing
                t[i][prevVal][0] = cumSumI[prevVal-1];
            }
        }

        long res = 0;

        for(int startVal=1; startVal<=m; startVal++){
            res = (res + t[1][startVal][1])%MOD;

            res = (res + t[1][startVal][0]) %MOD;
        }

        return (int)res;
    }
}