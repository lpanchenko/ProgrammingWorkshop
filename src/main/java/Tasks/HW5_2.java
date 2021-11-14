package Tasks;

public class HW5_2 {
    /*
    Ваша задачка чуть сложнее. Вы заранее не знаете, сколько цифр будет в числе. На вход функции может прийти 1, 242, 14435 или 324234234
Функция должна вернуть TRUE в случае, если сумма цифр, стоящих на четных позициях равна сумме цифр, стоящих на нечетных позициях
ИЛИ если все цифры, стоящие на четных позициях равны всем цифрам, стоящих на нечетных. Иначе вернуть FALSE.
Примеры:
3443 - TRUE
222222 - TRUE
321654 - FALSE
     */
    public static void main(String[] args) {

        int input = 11;
        System.out.println(checkValue(input));
    }

    private static boolean checkValue(int input) {

        String strInput = String.valueOf(input);
        if (strInput.length() < 2)
            return false;
        return checkSum(strInput) || numberTheSame(strInput);
    }

    private static boolean checkSum(String strInput) {
        int evens = 0;
        int odds = 0;

        for (var i = 0; i < strInput.length(); i++) {
            if (i%2 == 0)
                evens += Character.getNumericValue(strInput.charAt(i));
            else
                odds += Character.getNumericValue(strInput.charAt(i));
        }

        return evens == odds;
    }

    private static boolean numberTheSame(String strInput) {

        for (var i = 0; i < strInput.length() - 1; i++) {
            if (Character.getNumericValue(strInput.charAt(i)) != Character.getNumericValue(strInput.charAt(i + 1)))
                return false;
        }
        return true;
    }
}
