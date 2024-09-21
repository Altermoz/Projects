import java.io.*;
import java.util.Scanner;

public class VowelOrConsonantCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);

            ch = Character.toLowerCase(ch);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelCount++;
            }

            else if (ch >= 'a' && ch <= 'z'){
                consonantCount++;
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }
}