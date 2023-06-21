/*dizideki elemanların kaç kez tekrar edildiğini yani frekanslarını bulan program
Dizi : [10, 20, 20, 10, 10, 20, 5, 20]
Tekrar Sayıları
10 sayısı 3 kere tekrar edildi.
20 sayısı 4 kere tekrar edildi.
5 sayısı 1 kere tekrar edildi.
 */
import java.util.HashMap;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 20, 5, 20};

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : array) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        // Print the frequencies
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            System.out.println(num + " sayısı " + frequency + " kere tekrar edildi.");
        }
    }
}
