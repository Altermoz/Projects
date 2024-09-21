import java.io.*;
import java.util.Scanner;

public class BasicCalcu {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("---Basic Calculator---");
    System.out.println("1. Addition");
    System.out.println("2. Subtraction");
    System.out.println("3. Multiplication");
    System.out.println("4. Division");

    System.out.print("Enter First Number");
    double num1 = sc.nextDouble();
    System.out.print("Enter Second Number");
    double num2 = sc.nextDouble();

    System.out.print("Choose Operation (1-4):");
    int operation = sc.nextInt();

    if (operation == 1){
        double result = num1 + num2;
        System.out.print(num1 + "+" + num2 +"=" + result);
    } else if (operation == 2){
        double result = num1 - num2;
        System.out.print(num1 + "-" + num2 +"=" + result);
    } else if (operation == 3){
        double result = num1 * num2;
        System.out.print(num1 + "x" + num2 +"=" + result);
    } else if (operation == 4){
        if (num2 > 0){
            double result = num1 / num2;
            System.out.print(num1 + "/" + num2 +"=" + result);
        } else {
            System.out.print("Can't divide by zero");
        }

    } else {
        System.out.println("Try again. Choose operation 1-4");
    }
}
}
