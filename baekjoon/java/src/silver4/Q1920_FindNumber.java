package silver4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920_FindNumber {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static void input() {
        N = scan.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scan.nextInt();
        }
        M = scan.nextInt();
        nums = new int[M];
        for (int i = 0; i < M; i++) {
            nums[i] = scan.nextInt();
        }
    }

    static int N, M;
    static int[] a, nums;

    static void sol() {
        // 찾는 것도 sort 한 후 이분탐색이 더 빠를까
        // 찾는 것도 sort 한후 while문이 더 빠를까
        // 단순 이분탐색이 빠를까
        Arrays.sort(a);
        for (int n : nums) {
            System.out.println("n = " + n);
            sb.append(find(n)).append("\n");
        }
    }

    static int find(int n) {
        int start = 0;
        int end = N - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == n) {
                return 1;
            }
            if (a[mid] < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        input();
        sol();
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
