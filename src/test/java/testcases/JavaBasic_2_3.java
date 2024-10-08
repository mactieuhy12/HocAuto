package testcases;

import java.util.Scanner;

public class JavaBasic_2_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào a: ");
        int a = scanner.nextInt();
        System.out.print("Nhập vào b: ");
        int b = scanner.nextInt();

        if(a > b){
            System.out.print(" True");
        } else{
            System.out.print("False");
        }

        scanner.close();
    }
}
