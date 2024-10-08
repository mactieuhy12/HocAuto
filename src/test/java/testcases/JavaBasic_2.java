package testcases;

import java.util.Scanner;

public class JavaBasic_2 {
    public static void main(String[] args){
        // Đọc giá trị từ bàn phím
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = x +15;
        System.out.print("Tuổi: " +y);
        scanner.close();
    }
}

