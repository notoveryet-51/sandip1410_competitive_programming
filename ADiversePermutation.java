/*The program is the solution of codeforces problem no. 482A
Regn no.: 2025CA085
Program Date: 09-09-2026
Program Time: 07:36 IST    */

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

public class ADiversePermutation {

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

        int a=in.nextInt();
        int b=in.nextInt();
        int []nums=new int[a];
        int []visited=new int[a+1]; // auto initialised to 0
        int start=1;
        int idx=0;
        nums[idx]=start; // nums[0]=1;
        visited[start]=1;
        boolean forward = true;
        while (b>0) {
            // find for nums[++idx]
            int curr=nums[idx];
            if (forward) { // forward
                visited[nums[idx]+b]=1;    nums[++idx]=curr+b;
            }
            else { //backward
                visited[nums[idx]-b]=1; nums[++idx]=curr-b;
            }
            forward=!forward;
            b--;
        }
        // fill the remaining unvisited numbers
        for (int i=1; i<=a; i++) {
            if (visited[i]==0) nums[++idx]=i;
        }
        // print the output
        for (int i=0; i<a; i++) 
            out.print(nums[i]+" ");

        out.close();
    }
}