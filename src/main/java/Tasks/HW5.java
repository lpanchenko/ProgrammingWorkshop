package Tasks;

import java.util.Scanner;

public class HW5 {
//    Привет. Сегодня пятница и задачка будет попроще. Давайте поработаем с числами? Надо написать функцию, которая на вход получает число, состоящее из двух цифр. Например 10, 44 или 38.
//    Функция должна вернуть TRUE в случае, если первая цифра в числе равняется второй цифре в числе ИЛИ если сумма первой и второй цифр равна 10. Во всех остальных случаях должен вернуться FALSE.
//    Примеры:
//    33 - TRUE
//    46 - TRUE
//    38 - FALSE

    public static void main(String[] args) {

        System.out.println("Enter any value between 9 and 100: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        boolean output = isInputValid(input);
        System.out.println(output);
    }

    private static boolean isInputValid(int input) {

        if (input < 10 || input > 99){
            System.out.println("Wrong input. The value should be more that 9 and less that 100");
            return false;
        }

        String temp = String.valueOf(input);
        int theFirstDigit = Character.getNumericValue(temp.charAt(0));
        int theSecondDigit = Character.getNumericValue(temp.charAt(1));

        if (theFirstDigit == theSecondDigit)
            return true;

        if (theFirstDigit + theSecondDigit == 10)
            return true;

        return false;
    }
}
