
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class EIUMEDARRAY4 {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int T = reader.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = reader.nextInt();
            long A = reader.nextLong();
            long P = reader.nextLong();
            int K = reader.nextInt();
            long[] arr = new long[N];

            arr[0] = (A * A) % P;
            for (int j = 1; j < N; j++) {
                arr[j] = (arr[j - 1] * A) % P;
            }

            sb.append(quickSort(arr, 0, N - 1, K)).append("\n");
        }

        System.out.println(sb);
    }

    public static long quickSort(long[] arr, int low, int high, int k) {
        int pivot = partition(arr, low, high);
        if (pivot == k - 1) {
            return arr[pivot];
        } else if (pivot > k - 1) {
            return quickSort(arr, low, pivot - 1, k);
        } else {
            return quickSort(arr, pivot + 1, high, k);
        }
    }

    public static int partition(long[] arr, int low, int high) {
        long pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        long temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
