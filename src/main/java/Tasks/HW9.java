package Tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.MessageFormat;

public class HW9 {
    /*
    Сегодня мы будем работать с цифрами. А именно - писать число прописью :)
Задача очень простая, пишем на вход функцию, куда можно передать число от нуля до одного миллиарда. Функция должна написать прописью это число.
Например - передали 1,344,321
Ответ - Один миллион, триста сорок четыре тысячи, триста двадцать один
     */

    public static void main(String[] args) throws Exception {

        int number = getNumber();
        String numberAsString = numberToString(number);
        System.out.println(numberAsString);
    }

    private static String numberToString(int number) {

        // Part with millions
        int firstPart = number / 1000000;

        // Part with thousands
        int secondPart = (number / 1000) % 1000;

        int thirdPart = number % 1000;

        if (number == 0)
            return firstSymbolToUpperCase("ноль");

        if (number < 1000) {
            return firstSymbolToUpperCase(getThirdPart(thirdPart));
        }
        if (number < 1000000) {
            return firstSymbolToUpperCase(MessageFormat.format("{0}, {1}", getSecondPart(secondPart), getThirdPart(thirdPart)));
        }

        return firstSymbolToUpperCase(MessageFormat.format("{0}, {1}, {2}", getFirstPart(firstPart), getSecondPart(secondPart), getThirdPart(thirdPart)));
    }

    private static String firstSymbolToUpperCase(String input) {
        char temp []= input.trim().toCharArray();
        temp [0] = Character.toUpperCase(temp[0]);
        return new String(temp);
    }

    private static String getFirstPart(int number) {
        String [] arr = new String[]{"миллионов", "один миллион", "два миллиона", "три миллиона", "четыре миллиона", "пять миллионов",
                "шесть миллионов", "семь миллионов", "восемь миллионов", "девять миллионов", "десять миллионов",
                "одиннадцать миллионов", "двенадцать миллионов", "тринадцать миллионов", "четырнадцать миллионов", "пятнадцать миллионов",
                "шестнадцать миллионов", "семнадцать миллионов", "восемнадцать миллионов", "девятнадцать миллионов"};

        return getString(number, arr);
    }

    private static String getString(int number, String[] arr) {
        String [] tens = new String[]{"", "", "двадцать", "тридцать", "сорок", "пятдесят", "шестдесят", "семдесят",
                "восемдесят", "девяносто"};

        String [] hundreds = new String[]{
                "", "сто", "двести", "триста", "четыреста", "пятсот", "шестсот", "семсот", "восемсот", "девятсот"
        };

        StringBuilder sb = new StringBuilder();
        sb.append(hundreds[number/100]).append(" ");

        if (number < 20) {
            sb.append(" ").append(arr[number]);
            return sb.toString();
        }

        sb.append(tens[(number/10)%10]).append(" ").append(arr[number%10]);
        return sb.toString();
    }

    private static String getSecondPart(int number) {
        String [] arr = new String[]{"тысяч", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи", "пять тысяч",
                "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч", "десять тысяч",
                "одиннадцать тысяч", "двенадцать тысяч", "тринадцать тысяч", "четырнадцать тысяч", "пятнадцать тысяч",
                "шестнадцать тысяч", "семнадцать тысяч", "восемнадцать тысяч", "девятнадцать тысяч"};

        return getString(number, arr);
    }

    private static String getThirdPart(int number) {
        String [] arr = new String[]{"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять",
                "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать",
                "восемнадцать", "девятнадцать"};

        return getString(number, arr);
    }

    private static int getNumber() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter amount less that 1 milliard: ");
        Integer amount = Integer.parseInt(br.readLine());
        if (amount > 1000000000)
            throw new Exception("Number has to be less that 1 milliard");
        return amount;
    }
}
