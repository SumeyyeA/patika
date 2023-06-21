/*dizideki elemanları küçükten büyüğe sıralayan program

Size of the array (n): 5
Enter the elements of the array:
1. Element: 99
2. Element: -2
3. Element: -2121
4. Element: 1
5. Element: 0
Sorted array: -2121 -2 0 1 99

 */ 
import java.util.Arrays;
import java.util.Scanner;

public class ArraySorting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Size of the array (n): ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Element: ");
            arr[i] = scanner.nextInt();
        }

        // Sort the array
        Arrays.sort(arr);

        System.out.print("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
