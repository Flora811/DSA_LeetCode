//How to use the MOD is really important.
// subtraction can create a negative number - so we do: (number - x + MOD)%MOD;
// In multiplication, the int can overflow -> so we multiply number* 1L -> to avoid the overflow.

//TC: O(n);
//SC: O(4*n) ≈ O(n)

class Solution {
    int MOD = 1_000_000_000 + 7;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int m = queries.length;
        int ans[] = new int[m];

        int n = s.length();
        int digitSum[] = new int[n];
        digitSum[0] = s.charAt(0)-'0';

        int numUpTo[] = new int[n];
        numUpTo[0] = s.charAt(0)-'0';

        int digitsUpTo[] = new int[n];
        digitsUpTo[0] = numUpTo[0]>0 ? 1: 0;

        int powerOf10[] = new int[n];
        powerOf10[0] = 1;

        for(int i=1; i<n; i++){
            int num = s.charAt(i)-'0';
            if(num > 0){
                digitSum[i] = (int)((digitSum[i-1]*1L + num)%MOD);
                numUpTo[i] = (int)((1L*numUpTo[i-1]*10 + num)%MOD);
                digitsUpTo[i] = digitsUpTo[i-1]+1;
            }
            else{
                digitSum[i] = digitSum[i-1];
                numUpTo[i] = numUpTo[i-1];
                digitsUpTo[i] = digitsUpTo[i-1];
            }
            powerOf10[i] = (int)((1L*powerOf10[i-1]*10)%MOD);
        }
        int i=0;
        for(int q[] : queries){
            int l = q[0];
            int r = q[1];

            int k = digitsUpTo[r];
            int sum = digitSum[r];
            int x = numUpTo[r];

            if(l>0){
                k -= digitsUpTo[l-1];
                sum = (sum - digitSum[l-1] + MOD) %MOD;
                x = (int)((x - (1L*numUpTo[l-1]*powerOf10[k])%MOD + MOD)%MOD);
            }
            
            ans[i++] = (int)((1L*x*sum)%MOD);
        }

        return ans;
    }
}