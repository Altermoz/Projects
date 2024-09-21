import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class NumberRandomizer {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Press Enter to generate random number");
            sc.nextLine();

            int randomNumber = random.nextInt(100) + 1;

            System.out.println("Random number: " + randomNumber);
        }
    }
}