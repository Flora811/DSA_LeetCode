// When the exponent is a big number, we use fast Exponentiation or Binary exponentiation
// TC: O(log(b)), where b is an exponent.


//a^b
public int power(int a, int b){
    if(b==0) return 1;

    int half = power(a, b/2);

    int res = half * half;

    if(b%2==1) res *= a;

    return res;
}
