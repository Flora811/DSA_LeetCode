class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        
        int freq[] = new int[26];
        StringBuilder half_res = new StringBuilder();
        int halfLen = n/2;
        
        for(int i=0; i<n; i++){
            if(n%2!=0 && i==n/2) continue;
            int chIdx = s.charAt(i) -'a';
            freq[chIdx] += 1;
        }
        for(int i=0; i<26; i++){
            freq[i] /= 2;
        }

        for(int i=0; i<halfLen; i++){
            boolean placedCharacter = false;
            for(int j=0; j<26; j++){
                if(freq[j]<=0) continue;
                freq[j] -= 1;

                //number of ways
                long ways = 1;
                int letters = 0;
                for(int ch=0; ch<26; ch++) letters += freq[ch];
                for(int ch=0; ch<26; ch++){
                    if(freq[ch]<=0) continue;
                    ways *= nCr(letters, freq[ch], k);
                    letters -= freq[ch];
                    //early break
                    if(ways>=k) break;
                }
                if(k <= ways){
                    half_res.append((char)(j+'a'));
                    placedCharacter = true;
                    break;
                }
                k = (int) (k-ways);
                freq[j] += 1;
            }

            if(!placedCharacter) return "";
        }

        StringBuilder ans = new StringBuilder(half_res);
        if(n%2 != 0) ans.append(s.charAt(n/2));
        ans.append(half_res.reverse());
        return ans.toString();
    }

    public long nCr(int n, int r, int k){
        //nCr == nC(n-r) 5C3 == 5C2
        r = Math.min(r, n-r);
    
        long res = 1;
        for(int i=1; i<=r; i++){
            res = (res*(n-r+i)) / i ;
            //early break
            if(res >= k) return k;
        }
        return res;
    }
}