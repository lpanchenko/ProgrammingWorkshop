package Tasks;

import java.util.Arrays;

public class HW11 {
    /*
    Сегодня задачка на массивы. Пишем функцию, которая на вход получает несортированный массив чисел. Функция должна вернуть TRUE в случае, если в массиве есть два числа - 13 и 41
Иначе вернуть FALSE
     */

    public static void main(String[] args) {

        int [] input = new int[]{1, 2, 3, 0, 78, 41};

        // Check if array contains both numbers 13 and 41
        boolean result = isArrayContainsNumbers(input);
        System.out.println(result);
    }

    private static boolean isArrayContainsNumbers(int[] input) {

        return Arrays.stream(input).anyMatch(x -> x == 13) && Arrays.stream(input).anyMatch(y -> y == 41);
    }
}