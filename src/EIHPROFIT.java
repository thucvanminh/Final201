
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
class EIHPROFIT {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
//        int n = reader.nextInt();
//        int m = reader.nextInt();
//        StringBuilder sb = new StringBuilder();
//        Product[] products = new Product[n];
//
//        for (int i = 0; i < n; i++) {
//            int id = reader.nextInt();
//            String name = reader.next();
//            int price = reader.nextInt();
//            int cost = reader.nextInt();
//            int quantity = reader.nextInt();
//            int profit = (price - cost) * quantity;
//            products[i] = new Product(id, name, profit);
//        }
//
//        Arrays.sort(products, (p1, p2) -> {
//            int profitCompare = Integer.compare(p2.profit, p1.profit);
//            if (profitCompare == 0) {
//                return Integer.compare(p1.id, p2.id);
//            }
//            return profitCompare;
//        });
//
//        for (int i = 0; i < m; i++) {
//            sb.append(products[i].id).append(" ").append(products[i].name).append(" ").append(products[i].profit).append("\n");
//        }
//
//        for (int i = m; i < n; i++) {
//            if (products[i].profit == products[i - 1].profit) {
//                sb.append(products[i].id).append(" ").append(products[i].name).append(" ").append(products[i].profit).append("\n");
//            } else {
//                break;
//            }
//        }

        int n = reader.nextInt();
        int m = reader.nextInt();
        StringBuilder sb = new StringBuilder();
        Map<Long, Product> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            long id = reader.nextLong();
            String name = reader.next();
            Product product = map.get(id);
            if (product == null) {
                product = new Product(id, name);
                map.put(id, product);
            }

            long price = reader.nextInt();
            long cost = reader.nextInt();
            long quantity = reader.nextInt();

            product.profit = (price - cost) * quantity;
        }

        List<Product> products = new ArrayList<>(map.values());
        products.sort((s1, s2)
                -> {
            long avgCompare = Long.compare(s2.profit, s1.profit);
            if (avgCompare == 0){
                return Long.compare(s1.id, s2.id);
            }
            return Long.compare(s2.profit, s1.profit);
        });

        for (int i = 0; i < m; i++) {
            sb.append(products.get(i).id).append(" ").append(products.get(i).name).append(" ").append(products.get(i).profit).append("\n");
        }

        for (int i = m; i < n; i++) {
            if (products.get(i).profit == products.get(i - 1).profit) {
                sb.append(products.get(i).id).append(" ").append(products.get(i).name).append(" ").append(products.get(i).profit).append("\n");
            } else {
                break;
            }
        }
        System.out.println(sb);

    }

    static class Product {

        long id;
        String name;
        long profit;

        public Product(long id, String name) {
            this.id = id;
            this.name = name;
            this.profit = profit;
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
