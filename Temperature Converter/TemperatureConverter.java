import java.io.*;
import java.util.Scanner;

public class TemperatureConverter{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---TEMPERATURE CONVERSION---");
        System.out.println("1. Celsius to Kelvin");
        System.out.println("2. Kelvin to Celsius");
        System.out.println("3. Fahrenheit to Celsius");
        System.out.println("4. Celsius to Fahrenheit");
        System.out.println("5. Fahrenheit to Kelvin");
        System.out.println("6. Kelvin to Fahrenheit");
        System.out.print("Select Conversion (1-6):");
        int selected = sc.nextInt();

        if (selected == 1){
            System.out.print("Enter Temperature in Celsius: ");
            double inputCelsius = sc.nextDouble();
            double kelvin = inputCelsius + 273.15;
            System.out.println("Temperatue in Kelvin " + kelvin + "k");

        } else if (selected == 2){
            System.out.print("Enter Temperature in Kelvin: ");
            double inputKelvin = sc.nextDouble();
            double celsius = inputKelvin - 273.15;
            System.out.println("Temperatue in Celsius " + celsius + "c");

        } else if (selected == 3){
            System.out.print("Enter Temperature in Fahrenheit: ");
            double inputFahrenheit = sc.nextDouble();
            double celsius = ((inputFahrenheit - 32)*(5.0/9.0));
            System.out.println("Temperatue in Celsius " + celsius + "c");

        } else if (selected == 4){
            System.out.print("Enter Temperature in Celsius: ");
            double inputCelsius = sc.nextDouble();
            double fahrenheit = inputCelsius*(9.0/5.0) + 32;
            System.out.println("Temperatue in Fahrenheit " + fahrenheit + "f");

        } else if (selected == 5){
            System.out.print("Enter Temperature in Fahrenheit: ");
            double inputFahrenheit = sc.nextDouble();
            double kelvin = ((inputFahrenheit - 32)*(5.0/9.0)+273.15);
            System.out.println("Temperatue in Kelvin " + kelvin + "k");

        } else if (selected == 5){
            System.out.print("Enter Temperature in Kelvin: ");
            double inputKelvin = sc.nextDouble();
            double fahrenheit = ((inputKelvin - 273.15)*(9.0/5.0)+32);
            System.out.println("Temperatue in Fahrenheit " + fahrenheit + "f");

        } else {
            System.out.println("Please try again. Enter number 1-6 ");
        }
    }
}

