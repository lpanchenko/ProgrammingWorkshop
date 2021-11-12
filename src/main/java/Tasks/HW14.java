package Tasks;

public class HW14 {
    /*
    Сегодня поработаем с массивами. Надо написать функцию, которая на вход получает положительное число и массив массивов.
Например, на вход пришло число 456. Надо убедиться, что в массиве массивов ровно три массива: первый массив имеет 4 элемента, второй - 5 элементов, а третий - 6 элементов.
Если пришло число 55, надо убедиться, что в массиве массивов два массива по 5 элементов каждый.
Функция возвращает True, если массив подходит под число или False, если нет
Гарантируется, что число больше 0.
Приводить число к строке нельзя. :)
     */

    public static void main(String[] args) {

        int number = 456;
        int[][] arr = new int[][]{new int[]{1, 2, 3, 4},
                new int[]{1, 2, 3, 4, 1},
                new int[]{1, 2, 3, 4, 1, 0}};

        System.out.println(theSameLength(number, arr));
    }

    private static Boolean theSameLength(int number, int[][] arr) {

        return theSameLength(number, arr.length - 1, arr);
    }

    private static Boolean theSameLength(int number, int idx, int[][] arr) {

        if (idx < 0 && number == 0) return true;
        if (idx < 0 || number == 0) return false;

        if (number % 10 != arr[idx].length) return false;

        return theSameLength(number / 10, idx - 1, arr);
    }
}
