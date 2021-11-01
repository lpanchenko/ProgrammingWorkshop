package Tasks;

import java.util.Scanner;

public class HW3 {

//    Первая должна получать на вход строку и шифровать ее по следующему принципу - каждая буква заменяется на следующую в алфавите, при этом большая буква становится маленькой, а маленькая - большой.
//    То есть ""a"" заменяется на ""B"", а ""Y"" заменяется на ""z"". Последняя буква заменяется на первую, то есть ""Z"" на ""a"", а ""z"" на ""A"". Итоговая строка возвращается.

    public static void main(String[] args) {

        System.out.println("Enter text for encryption: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        sc.close();
        
        String encryptedString = ToEncrypt(text);
        String decryptedString = ToDecrypt(encryptedString);

        System.out.println(text);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }

    public static String ToDecrypt(String text) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++){

            int idx = text.charAt(i);
            int newIdx = idx - 1;

            if (newIdx == 96) {
                newIdx = 122;
            } else if (newIdx == 64) {
                newIdx = 90;
            }

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

            if (newIdx == 91) {
                newIdx = 65;
            } else if (newIdx == 123) {
                newIdx = 97;
            }

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
