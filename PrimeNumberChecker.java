//Enter Number  : 22 
//22 is not prime ! 


  import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = scanner.nextInt();

        scanner.close();

        boolean isPrime = checkPrime(number);

        if (isPrime) {
            System.out.println(number + " is a PRIME number!");
        } else {
            System.out.println(number + " is not a prime number!");
        }
    }

    public static boolean checkPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return checkPrimeRecursive(number, 2);
    }

    public static boolean checkPrimeRecursive(int number, int divisor) {
        if (divisor == number) {
            return true;
        } else if (number % divisor == 0) {
            return false;
        } else {
            return checkPrimeRecursive(number, divisor + 1);
        }
    }
}
