package testcases;

import java.util.Scanner;

public class JavaBasic_2_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên b: ");
        int b = scanner.nextInt();

        int c = a;
        a = b;
        b = c;

        System.out.println("Giá trị của a: " +a + ", b: " +b);
        scanner.close();

    }
}
