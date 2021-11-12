package Tasks;

import java.util.HashMap;

public class HW13 {
    /*
    Сегодня учимся парсить параметры консольной утилиты. Допустим, у нас есть утилита run, которая запускается из консоли с различными параметрами. Например:

run --online-mode
run --ip=132.223.324.454
run --stable-mode --ip=129.22.341.11

Наша задача - написать функцию, которая на вход получает параметры строкой. Например, вот такую строку: "--stable-mode --ip=129.22.341.11"
Функция должна разобрать эту строку и вернуть ассоциативный массив (словарь, хешмап), где ключом будет название параметра без двух символов тире в начале,
а значением будет либо то, что указано через знак равно (как для параметра ip), либо True, если ключ используется без значения.

Например, нам на вход пришла вот такая строка: "--stable-mode --ip=129.22.341.11 --online-mode --port=4455"
Ожидаемый результат:

[
''ip" => "129.22.341.11",
 "port" => "4455",
"stable-mode" => "True",
"online-mode" => "True"
]

Гарантируется, что все параметры начинаются с двух символов -- и что после параметра идет либо символ равно и значение (не менее одного символа), либо следующий параметр.
     */

    public static void main(String[] args) {

        String input = "--stable-mode --ip=129.22.341.11 --online-mode --port=4455";
        HashMap<String, String> parameters = parseParameters(input);
        System.out.println(parameters);
    }

    private static HashMap<String, String> parseParameters(String input) {

        HashMap<String, String> result = new HashMap<>();
        String [] parameters = input.split("--");

        for (var i = 0; i < parameters.length; i++)
        {
            if (!parameters[i].isEmpty()) {
                String temp = parameters[i].trim();
                String[] tempArr = temp.split("=");

                if (tempArr.length == 1)
                    result.put(tempArr[0], "True");
                else
                    result.put(tempArr[0], tempArr[1]);
            }
        }
        return result;
    }
}
