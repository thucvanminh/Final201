
import java.io.*;
import java.util.*;

class ArrayStack<T extends Number> {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();

        ArrayStack<Integer> stack = new ArrayStack<Integer>(n);
        for (int i = 0; i < m; i++) {
            stack.push(reader.nextInt());
        }

        for (int i = 0; i < k; i++) {
            String command = reader.next();
            if (command.equals("push")) {
                stack.push(reader.nextInt());
            } else if (command.equals("pop")) {
                System.out.println(stack.pop());
            } else if (command.equals("peek")) {
                System.out.println(stack.peek());
            } else if (command.equals("average")) {
                System.out.println(stack.average());
            } else if (command.equals("sum")) {
                System.out.println(stack.sum());
            }
        }
    }

    // Your code here
    Object[] data;
    int lastIndex = 0;
    double sum = 0;

    public ArrayStack(int capacity) {
        data = new Object[capacity];
        for (int i = 0; i < lastIndex; i++) {
            sum += ((Number) data[i]).doubleValue();
        }
    }

    public int count() {
        return lastIndex;
    }

    public double sum() {
        // T number;
        // number.doubleValue();
        return sum;
    }

    public double average() {
        double average = sum() / count();
        return average;
    }

    /**
     * @description: add item when stack is not full
     */
    public void push(T item) {
        // Sample: data[lastIndex++] = item;
        if (lastIndex <= data.length) {
            data[lastIndex++] = item;
            sum += ((Number) item).doubleValue();
        }
    }

    /**
     * @return: return and remove top item, or null when stack is empty
     */
    public T pop() {
        if (lastIndex == 0) {
            return null;
        }
        T item = (T) data[lastIndex - 1];
        data[lastIndex - 1] = null;
        lastIndex--;
        sum -= ((Number) item).doubleValue();
        return item;
    }

    /**
     * @return: return top item, or null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        // Sample return (T) data[lastIndex - 1];
        if (lastIndex == 0) {
            return null;
        }
        return (T) data[lastIndex - 1];
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
