/*The program is the solution of codeforces problem no. 1904B
Regn no.: 2025CA085
Program Date: 27-09-2026
Program Time: 18:30 IST    */

/**
 *  ███████╗ █████╗ ███╗   ██╗██████╗ ██╗██████╗  █████╗ ███╗   ██╗
 *  ██╔════╝██╔══██╗████╗  ██║██╔══██╗██║██╔══██╗██╔══██╗████╗  ██║
 *  ███████╗███████║██╔██╗ ██║██║  ██║██║██████╔╝███████║██╔██╗ ██║
 *  ╚════██║██╔══██║██║╚██╗██║██║  ██║██║██╔═══╝ ██╔══██║██║╚██╗██║
 *  ███████║██║  ██║██║ ╚████║██████╔╝██║██║     ██║  ██║██║ ╚████║
 *  ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═════╝ ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝
 *
 *                 S A N D I P A N   R A Y
 */

import java.io.*;
import java.util.*;

public class BCollectingGame {

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                return st.nextToken();
            } catch (IOException e) {
                return null;
            }
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }

        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { return ""; }
        }
    }

    static class FastWriter {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        void print(Object o) throws IOException { bw.write(String.valueOf(o)); }
        void println(Object o) throws IOException { bw.write(String.valueOf(o)); bw.newLine(); }
        void close() throws IOException { bw.flush(); }
    }

    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return (a / gcd(a, b)) * b; }

    static final int MOD = 1000000007;
    static final int MAX = 200005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    static long binPow(long a, long b) {
        long res = 1; a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static void precomputeFactorials() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[MAX - 1] = binPow(fact[MAX - 1], MOD - 2);
        for (int i = MAX - 2; i >= 1; i--)
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    static long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();

        precomputeFactorials();

        int t = in.nextInt();
        while (t-- > 0) {
            // write logic here
            int n=in.nextInt();
            int[] arr=new int[n];
            for (int i=0; i<n; i++) {
                arr[i]=in.nextInt();
            }
            int[] resultArray=new int[n];
            long[][] sorted = new long[n][2];
            for (int i = 0; i < n; i++) {
                sorted[i][0] = arr[i];
                sorted[i][1] = i;
            }
            Arrays.sort(sorted, (a, b) -> Long.compare(a[0], b[0]));

            // Prefix sum of sorted values
            long[] pref = new long[n];
            pref[0] = sorted[0][0];
            for (int i = 1; i < n; i++) {
                pref[i] = pref[i - 1] + sorted[i][0];
            }

            // ans[i] stores the maximum reachable index in sorted array starting at sorted index i
            int[] ans = new int[n];
            ans[n - 1] = n - 1;
            for (int i = n - 2; i >= 0; i--) {
                if (pref[i] >= sorted[i + 1][0]) {
                    ans[i] = ans[i + 1];
                } else {
                    ans[i] = i;
                }
            }

            // Map answers back to original indices
            for (int i = 0; i < n; i++) {
                resultArray[(int) sorted[i][1]] = ans[i];
            }

            for (int i = 0; i < n; i++) {
                out.print(resultArray[i] + (i == n - 1 ? "" : " "));
            }
            out.println("");
        }
        

        out.close();
    }
}