package Tasks;

import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) {

        System.out.println("Enter text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println("Enter max length: ");
        int maxLength = sc.nextInt();

        int length = text.length();
        System.out.println("Text contains " + length + " symbols");

        int lengthWithoutSpaces = (int) text.chars().filter(c -> c != ' ').count();
        System.out.println("Text contains " + lengthWithoutSpaces+ " symbols without spaces");

        if (length%2 == 0)
            System.out.println("Text contains even amount of symbols");
        else
            System.out.println("Text contains odd  amount of symbols");

        if (length > maxLength)
            System.out.println("Длина текста превышает длину " + maxLength + " символов");
    }
}
