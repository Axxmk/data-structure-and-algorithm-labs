package primenumbers;

public class Prime {
    int n;
    int[] primeList;

    public Prime(int max) {
        n = max;
        primeList = new int[n];
    }

    public void genPrimeSieveOfErathosthenes() {
        int[] a = new int[n+1];

        for (int i = 2; i < a.length; i++) {    // put 2 to n into array a
            a[i] = i;
        }

        for (int p = 2; p <= Math.sqrt(n); p++) {
            if (a[p] != 0) {
                int j = p*p;
                while(j <= n) {
                    a[j] = 0;   // chang (sieve) to 0
                    j += p;
                }
            }
        }

        int count = 0;
        for (int p = 2; p <= n; p++) {
            if (a[p] != 0) {
                primeList[count] = a[p];
                count++;
            }
        }
    }

    public void genPrimeBruteForce() {
        for (int i = 2, count = 0; i < this.n; i++) {
            if (isPrime(i)) {
                this.primeList[count] = i;
                count++;
            }
        }
    }

    public boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
