/* Урок 2 
Задание 1
Доделать сортировку подсчетом классическим способом через промежуточный массив
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassicSort {

    public static int[] classicSort(int[] arr) {
        // Создаем пустой массив
        List<Integer> result = new ArrayList<>();

        // создаем промежуточный массив для положительных чисел
        List<Integer> temp = new ArrayList<>();

        // добавляем положительные числа в промежуточный массив
        for (int num : arr) {
            if (num >= 0) {
                temp.add(num);
            }
        }
        // сортируем промежуточный массив
        temp.sort(Integer::compareTo);

        // добавляем отрицательные числа в массив
        for (int num : arr) {
            if (num < 0) {
                result.add(num);
            }
        }

        // значения из  промежуточного массива добавляем в массив
        result.addAll(temp);

        int[] sortedArr = new int[result.size()];
        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = result.get(i);
        }
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = {0, -2, 3, 1, 0, 0, 1};
        int[] sortedArr = classicSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
