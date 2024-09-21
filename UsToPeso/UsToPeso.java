import java.io.*;
import java.util.Scanner;

public class UsToPeso {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amount in US Dollar: $");
        double usd = sc.nextDouble();
        double php = 56.03;
        double result = usd*php;
        System.out.println("Amount in Philippine Peso: " + result);
    }
}