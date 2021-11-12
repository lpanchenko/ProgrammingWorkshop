package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW3 {

    /*
Первая должна получать на вход строку и шифровать ее по следующему принципу - каждая буква заменяется на следующую в алфавите, при этом большая буква становится маленькой, а маленькая - большой.
То есть ""a"" заменяется на ""B"", а ""Y"" заменяется на ""z"". Последняя буква заменяется на первую, то есть ""Z"" на ""a"", а ""z"" на ""A"". Итоговая строка возвращается.
---
Решение неплохое, все ок. Можно попробовать немного оптимизировать, сделав меньше ветвлений, и добавив комментариев там, где мы используем коды символов (чтобы при прочтении кода понимать что такое 94 или 120 символ
     */

    public static void main(String[] args) throws IOException {

        String text = getText();

        String encryptedString = ToEncrypt(text);
        String decryptedString = ToDecrypt(encryptedString);

        System.out.println(text);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }

    private static String getText() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter text for encryption: ");
        return br.readLine();
    }

    public static String ToDecrypt(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++){

            int idx = text.charAt(i);
            int newIdx = idx - 1;

            // for char code 97 'a' replace it with 122 'z'
            if (newIdx == 96) newIdx = 122;
            // for char code 65 'A' replace it to 90 'Z'
            if (newIdx == 64) newIdx = 90;

            char convertedChar = ChangeCase((char)(newIdx));
            sb.append(convertedChar);
        }
        return sb.toString();
    }

    public static String ToEncrypt(String text) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++){

            int idx = text.charAt(i);
            int newIdx = idx + 1;

            // for char code is 90 'Z' replace it with 122 'z'
            if (newIdx == 91) newIdx = 65;
            // for char code is 122 'z' replace it with 97 'a'
            if (newIdx == 123) newIdx = 97;

            char convertedChar = ChangeCase((char)(newIdx));
            sb.append(convertedChar);
        }
        return sb.toString();
    }

    private static char ChangeCase(char c) {

        if (Character.isLowerCase(c))
            return  Character.toUpperCase(c);
        return Character.toLowerCase(c);
    }
}
