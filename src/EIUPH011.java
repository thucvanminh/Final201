
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
public class EIUPH011 {

    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = createArray();

        arr = outputFirstOcc(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static int[] createArray() {
        int n = keyboard.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = keyboard.nextInt();
        }

        return arr;
    }

    public static int[] outputFirstOcc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr = deleteElement(arr, j);
                    j--;
                }
            }
        }

        return arr;
    }

    public static int[] deleteElement(int[] arr, int pos) {
        int[] deleteArr = new int[arr.length - 1];

        for (int i = 0; i < pos; i++) {
            deleteArr[i] = arr[i];
        }
        for (int i = pos; i < deleteArr.length; i++) {
            deleteArr[i] = arr[i + 1];
        }

        return deleteArr;
    }
}
