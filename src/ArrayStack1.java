
import java.io.*;
import java.util.*;

class ArrayStack1<T extends Number> {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int n = reader.nextInt();
        int m = reader.nextInt();
        int k = reader.nextInt();
 
        ArrayStack1<Integer> stack = new ArrayStack1<Integer>(n);
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < m; i++) {
            stack.push(reader.nextInt());
        }
        for (int i = 0; i < k; i++) {
            String command = reader.next();
            if (command.equals("sum")) {
                sb.append(stack.sum()).append("\n");
            } else if (command.equals("average")) {
                sb.append(stack.average()).append("\n");
            } else if (command.equals("count")) {
                sb.append(stack.count()).append("\n");
            } else if (command.equals("pop")) {
                sb.append(stack.pop()).append("\n");
            } else if (command.equals("peek")) {
                sb.append(stack.peek()).append("\n");
            } else if (command.equals("push")) {
                stack.push(reader.nextInt());
            }
        }
        System.out.println(sb);}
 
    // Your code here
    Object[] data;
    int lastIndex = 0;
    double sum = 0;
    int count = 0;
 
    public ArrayStack1(int capacity) {
        data = new Object[capacity];
    }
 
    public int count() {
        // Your code here
        return count;
 
    }
 
    public double sum() {
        // Your code here
        // T number;
        // number.doubleValue();
        return sum;
    }
 
    public double average() {
        // Your code here
        if (count() == 0) {
            return 0;
        }
        return sum / count;
    }
 
    /**
     * @description: add item when stack is not full
     */
    @SuppressWarnings("unchecked")
    public void push(T item) {
        if (count == data.length) {
            sum -= ((T) data[lastIndex]).doubleValue();
        } else {
            count++;
        }
 
        data[lastIndex] = item;
        sum += item.doubleValue();
        lastIndex = (lastIndex + 1) % data.length;
    }
 
    /**
     * @return: return and remove top item, or null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (count == 0) {
            return null;
        }
 
        lastIndex = (lastIndex - 1 + data.length) % data.length;
        T item = (T) data[lastIndex];
        data[lastIndex] = null;
        sum -= item.doubleValue();
        count--;
        return item;
    }
 
    /**
     * @return: return top item, or null when stack is empty
     */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (count == 0) {
            return null;
        }
        int lastItemIndex = (lastIndex - 1 + data.length) % data.length;
        return (T) data[lastItemIndex];
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
