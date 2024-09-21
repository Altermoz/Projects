import java.io.*;
import java.util.Scanner;

public class BmiCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double inputHeight, inputWeight, height, bmi;

        System.out.println("---BMI CALCULATOR---");
        System.out.println("Underweight = < 18.5 \nNormal Weight = 18.5 - 24.9 \nOverweight = 25 - 29.9 \nObesity = BMI of 30 or greater");
        System.out.print("Enter your Height (cm): ");
        inputHeight = sc.nextDouble();
        System.out.print("Enter your Weight (kg): ");
        inputWeight = sc.nextDouble();

        height  = inputHeight/100;

        bmi = inputWeight/(height*height);

        System.out.println("Your BMI is " + bmi);

        if (bmi < 18.5){
            System.out.println("Your BMI indicates that you are underweight.");
        } else if (bmi >= 18.5 && bmi < 25){
            System.out.println("Your BMI indicates that you have a normal weight.");
        } else if (bmi >= 25 && bmi < 30){
            System.out.println("Your BMI indicates that you are overweight.");
        } else {
            System.out.println("Your BMI indicates that you are in the obese category.");
        }
    }
}