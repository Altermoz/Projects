import java.io.*;
import java.util.Scanner;

public class BinaryToDecimalAndOctal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary number: ");
        String binString = sc.nextLine();

        int decimal = Integer.parseInt(binString, 2);
        System.out.println("Decimal number: " + decimal);

        String octalString = Integer.toOctalString(decimal);

        System.out.println("Octal number: " + octalString);

        sc.close();
    }
}