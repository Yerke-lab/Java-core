/* Урок 2 
Задание 3
Написать метод, принимающий на вход массив чисел и параметр n.
Метод должен осуществить циклический (последний элемент при 
сдвиге становится первым) сдвиг всех элементов массива на n позиций
*/
import java.util.Arrays;

public class ShiftArray {

    public static void cyclicShiftArray(int[] arr, int n) {
        int length = arr.length;
        int[] tempArray = Arrays.copyOf(arr, length);

        n = (n % length + length) % length;
        for (int i = 0; i < length; i++) {
            int newPosition = (i + n) % length;
            arr[newPosition] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        // входной массив
        int[] arr = {10, 2, 4, 7, 0, 5};
        // задаем колөво сдвигов
        int n = 4;

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        cyclicShiftArray(arr, n);
        System.out.println("Массив после циклического сдвига на " + n + " позиций: " + Arrays.toString(arr));
    }
}
