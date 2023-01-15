package lab2_empericalanalysis;

public class Lab2_EmpiricalAnalysis {
//    Summation btw 1 and n
//        1+2+3+4+...+n
//    Summation of summation btw 1 and n
//        1 + (1+2) + (1+2+3) + (1+2+3+4) + ... + (1+2+3+4+...+n)  -- normal way

//        1*n + 2*(n-1) + 3*(n-2) + 4*(n-3) + ... + n*(1)
//        i*(n-1+1) + i*(n-2+1) + i*(n-3+1) + ... + n*(n-n+1)
//        i*(n-i+1) + i*(n-i+1) + i*(n-i+1)                        -- multiply way

    public static void main(String[] args) {
        long start, end;
        long n = 1000;

        start = System.currentTimeMillis();
        System.out.println(sumOfSum(n));
        end = System.currentTimeMillis();

        System.out.println("It took " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        System.out.println(sumOfSumByFormula(n));
        end = System.currentTimeMillis();

        System.out.println("Sum of summation from 1 to n using formula took " + (end - start) + " milliseconds");

        start = System.currentTimeMillis();
        System.out.println(sumOfSumByMultiply(n));
        end = System.currentTimeMillis();

        System.out.println("Sum of summation from 1 to n using multiplication took " + (end - start) + " milliseconds");
    }

    public static double sumOfSumByMultiply(long n) {
        double sumOfSum = 0;    // O(n)
        for (int i = 1; i <= n ; i++) {
            sumOfSum += i*(n-i+1);
        }
        return sumOfSum;
    }

    public static double sumOfSumByFormula(long n) {
        double sumOfSum = 0;
        long sum = 0;           // O(n)

        for (long i = 1; i <= n; i++) {
            sum = (i * (i + 1)) / 2;
            sumOfSum += sum;
        }

        return sumOfSum;
    }

    public static double sumOfSum(long n) {
            double sumOfSum = 0;

            for (int i = 1; i <= n; i++) {
                double sum = 0;
                for (int j = 1; j <= i; j++) {
                    sum += j;
                }
                sumOfSum += sum;
            }

            return sumOfSum;
    }
}
