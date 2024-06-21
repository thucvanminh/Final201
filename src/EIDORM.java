
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class EIDORM {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n, p, q;
        n = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < n; i++) {
            p = scanner.nextInt();
            q = scanner.nextInt();
            if (q - p >= 2) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
