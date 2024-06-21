
import java.io.*;
import java.util.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
class LinkedList<T extends Number> {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {

        reader.nextInt();
        int m = reader.nextInt();

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < m; i++) {

            String command = reader.next();

            if (command.equals("insertAt")) {
                int index = reader.nextInt();
                int value = reader.nextInt();
                linkedList.insertAt(index, value);
            } else if (command.equals("getAt")) {
                int index = reader.nextInt();
                System.out.println(linkedList.getAt(index));
            }
        }
    }

    static class LinkedNode<U extends Number> {

        U number;
        LinkedNode<U> next;

        public LinkedNode(U number) {
            this.number = number;
        }
    }

    LinkedNode<T> head = null;
    int size = 0;

    public void insertAt(int index, T number) {
        // Your code here
        LinkedNode<T> node = new LinkedNode(number);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * @return null if index is out of range
     */
    public T getAt(int index) {
        // Your code here
        LinkedNode<T> temp = head;

        if (index >= size) {
            return null;
        }

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.number;
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
