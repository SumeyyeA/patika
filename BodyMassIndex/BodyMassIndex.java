import java.util.Scanner;

public class BodyMassIndex {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get the user's height in meters.
        System.out.println("Enter your height in meters: ");
        double height = input.nextDouble();

        // Get the user's weight in kilograms.
        System.out.println("Enter your weight in kilograms: ");
        double weight = input.nextDouble();

        // Calculate the user's body mass index.
        double bmi = weight / (height * height);

        // Print the user's body mass index.
        System.out.println("Your body mass index is " + bmi);
    }
}