package Tasks;

public class HW12 {
    /*
    Сегодня пишем функцию, которая ищет пути. Суть в следующем. На вход этой функции приходит массив из трех массивов.
    Каждый внутренний массив содержит три элемента. Получается поле три на три.
    Каждая клеточка может иметь одно из трех значений - зеленый (З), красный (К) или синий (С)
    Ваша задача - понять, есть ли путь из клетки 1х1 к клетке 3х3 так, чтобы мы не шли по диагонали и чтобы за всю дорогу
    ни разу не сменили цвет. То есть мы можем переступать на соседнюю клеточку только того же цвета, с которого начала на 1х1
     */

    public static void main(String[] args) {

        String [][] arr = new String[][] {  new String[]{"З", "З", "З"},
                                            new String[]{"З", "К", "С"},
                                            new String[]{"З", "К", "С"}};

        boolean isPossibleToExit = getIsPossibleToExit(arr);
        System.out.println(isPossibleToExit);
    }

    private static boolean getIsPossibleToExit(String[][] arr) {

        String firstCellColor = arr[0][0];

        if (goRight(firstCellColor, 0, arr) && goDown(firstCellColor, arr[0].length - 1, arr))
            return true;
        if (goDown(firstCellColor, 0, arr) && goRight(firstCellColor, arr.length - 1, arr))
            return true;
        return false;
    }

    private static boolean goDown(String initial, int column, String[][] arr) {

        boolean result = true;

        for (int i = 0; i < arr.length; i++)
        {
            if (!arr[i][column].equals(initial)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean goRight(String initial, int row, String[][] arr) {

        boolean result = true;
        for (int i = 0; i < arr[row].length; i++)
        {
            if (!arr[row][i].equals(initial)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
