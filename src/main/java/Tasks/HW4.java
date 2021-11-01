package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW4 {

//    Сегодня поработаем с массивами. Давайте напишем функцию, которая на вход получает массив слов. Например:
//    ["apple banana", "orange", "banana", "kiwi strawberry blueberry"]
//    Видно, что в этом массиве в некоторых слотах затесалось сразу несколько слов. На выходе функция должна вернуть такой массив, где одно слово будет в каждом элементе:
//    ["apple", "banana", "orange", "banana", "kiwi", "strawberry", "blueberry"]
//    Словом считается любой набор символов, обособленный пробелами или началом/концом строки.

    public static void main(String[] args) {

        System.out.println("Enter words: ");
        List<String> worlds = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine())
        {
            String input = sc.nextLine();
            if (input == null || input.isEmpty())
                break;

            String [] updatedInput = split(input);
            worlds.addAll(List.of(updatedInput));
        }
        sc.close();

        System.out.println(worlds);
    }

    static String[] split(String line) {
        return line.trim().split("[\\s\\n]+");
    }
}
