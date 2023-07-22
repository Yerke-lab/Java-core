/* Урок 2 
Задание 1
Доделать сортировку подсчетом с урока
*/
import java.util.Arrays;

public class CountingSort {

    public static int[] countingSort(int[] arr) {
        // Ищем мин. и макс.значения в массиве
        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        // Создаем вспомогательный массив для подсчета элементов
        int[] count = new int[maxVal - minVal + 1];

        // Подсчитываем количество каждого элемента в массиве
        for (int num : arr) {
            count[num - minVal]++;
        }

        // Создаем новый пустой массив для результата
        int[] result = new int[arr.length];
        int index = 0;

        // Заполняем новый массив значениями из всп.массива
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index++] = i + minVal;
                count[i]--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {0, -2, 3, 1, 0, 0, 1};
        int[] sortedArr = countingSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}

