
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
public class EISTOCK {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int n = reader.nextInt();
        Map<Integer, Product> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String c = reader.next();
            int id = reader.nextInt();
            long quantity = reader.nextLong();
            long price = reader.nextLong();
            Product product = map.get(id);
            if (product == null && c.equals("+")) {
                product = new Product(id);
                map.put(id, product);
            }

            if (c.equals("+") && map.get(id) != null) {
                product.totalProducts += quantity;
                product.importPrice += quantity * price;
            } else if (c.equals("-") && map.get(id) != null) {
                if (quantity <= product.totalProducts) {
                    product.exportPrice += price * quantity;
                    product.totalProducts -= quantity;
                }
            }
        }

        List<Product> products = new ArrayList<>(map.values());
        products.sort((p1, p2) -> {
            return Integer.compare(p1.id, p2.id);
        });

        for (int i = 0; i < products.size(); i++) {
            sb.append(products.get(i).id).append(" ").append(products.get(i).importPrice).append(" ").append(products.get(i).exportPrice).append("\n");
        }

        System.out.println(sb);

    }

    static class Product {

        int id;
        long totalProducts;
        long importPrice;
        long exportPrice;

        public Product(int id) {
            this.id = id;
        }
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
