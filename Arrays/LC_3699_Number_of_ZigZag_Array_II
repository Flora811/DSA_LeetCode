class Solution { //TC: O(m^3log(n)) SC: O(m^2)
    int Mod = 1_000_000_000 + 7;

    public int zigZagArrays(int n, int l, int r) {
        int m = r-l+1;
        int s = 2*m;
    
        //up idx = v-1;
        //down idx = m+v-1;

        long t[][] = new long[s][s];

        for(int v=1; v<=m; v++){

            //up transitions - prev val should be smaller -from 1 till v
            for(int u=1; u<v; u++){
                //t[up(v)][down(u)]
                t[v-1][m+u-1] = 1;
            }
            //down transitions - prev val should be greater - from v+1 till m
            for(int u=v+1; u<=m; u++){
                //t[down(v)][up(u)]
                t[m+v-1][u-1] = 1;
            }
        }

        long dp[] = new long[s];
        for(int v=1; v<=m; v++){
            //dp[Up(v)] = v-1 possibilities
            dp[v-1] = v-1;
            //dp[Down(v)] = m-v possibilities
            dp[m+v-1] = m-v;
        }

        //transition matrix^n-2
        long pow[][] = power(t, n-2);

        long nthState[] = new long[s];

        for(int i=0; i<s; i++){
            for(int j=0; j<s; j++){
                nthState[i] = (nthState[i] + pow[i][j]*dp[j]) %Mod;
            }
        }
        long ans = 0;

        for(long x: nthState){
            ans = (ans + x) % Mod;
        }
        return (int)ans;
    }

    public long[][] power(long[][] base, long expo){
        int n = base.length;
        long res[][] = new long[n][n];

        for(int i=0; i<n; i++){
            res[i][i] = 1;
        }

        while(expo > 0){
            if((expo&1) == 1){
                res = multiply(res, base);
            }
            base = multiply(base, base);
            expo >>= 1;
        }
        return res;
    }

    public long[][] multiply(long[][] a, long[][] b){
        int n = a.length;

        long c[][] = new long[n][n];

        for(int i=0; i<n; i++){
            for(int k=0; k<n; k++){
                if(a[i][k]==0) continue;

                for(int j=0; j<n; j++){
                    if(b[k][j]==0) continue;
                    c[i][j] = (c[i][j]%Mod + (a[i][k]%Mod * b[k][j]%Mod) %Mod )%Mod;
                }
            }
        }

        return c;
    }
}