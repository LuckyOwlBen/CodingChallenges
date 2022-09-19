package pers.coding.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    private static final long MOD = 1000000007;


    public static void main(String[] args) throws IOException {


        FastReader sc = new FastReader(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = sc.next();
//        long start = System.currentTimeMillis();
        long[] factorials = new long[100002];
        long[] reversed = new long[50002];
        factorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) {
            factorials[i] = (factorials[i - 1] * i) % MOD;
            if (i < reversed.length) {
                reversed[i] = reverse(factorials[i]);
            }
        }
        int[][] chars = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                chars[i][j] += chars[i - 1][j];
            }
            chars[i][s.charAt(i - 1) - 'a']++;
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int[] qchars = new int[26];
            int oddCount = 0;
            int palindromeMain = 0;
            long result = 1;
            for (int j = 0; j < 26; j++) {
                qchars[j] = chars[r][j] - chars[l - 1][j];
                if (qchars[j] % 2 == 1) {
                    oddCount++;
                }
                int t = qchars[j] / 2;
                palindromeMain += t;
                if (t > 0) {
//                    result *= reverse(factorials[t]);
                    result *= reversed[t];
                    result %= MOD;
                }
            }
            result *= factorials[palindromeMain];
            result %= MOD;
            if (oddCount > 0) {
                result *= oddCount;
                result %= MOD;
            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }
//        bw.write("Execution time: " + (System.currentTimeMillis() - start) + " ms");
        bw.flush();
        bw.close();
    }

    private static long reverse(long a) {
        return BigInteger.valueOf(a).modPow(BigInteger.valueOf(MOD - 2L), BigInteger.valueOf(MOD)).longValue();
//        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(MOD)).longValue();
    }

    private static class FastReader {

        private final BufferedReader br;

        private StringTokenizer st;

        public FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}