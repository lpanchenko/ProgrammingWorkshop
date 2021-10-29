package Tasks;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) {

        System.out.println("Enter text: ");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        System.out.println("Enter max length: ");
        int maxLength = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter prohibited words: ");
        List <String> badWorlds = new ArrayList<>();
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (line == null || line.isEmpty())
                break;
            badWorlds.add(line);
        }
        sc.close();

        int length = text.length();
        int lengthWithoutSpaces = (int) text.chars().filter(c -> c != ' ').count();
        String pureText = getPureText(text, (ArrayList<String>) badWorlds);
        String pureShortText = getPureText(getShortText(text, maxLength), (ArrayList<String>) badWorlds);

        JSONObject json = GetJson (text, length, lengthWithoutSpaces, pureText, pureShortText);
        System.out.println(json);
    }

    private static JSONObject GetJson(String text, int length, int lengthWithoutSpaces, String pureText, String pureShortText) {
        JSONObject json = new JSONObject();
        json.put("length", length);
        json.put("pure_length", lengthWithoutSpaces);
        json.put("origin_text", text);
        json.put("pure_text", pureText);
        json.put("pure_short_text", pureShortText);
        return json;
    }

    private static String getShortText(String text, int maxLength) {

        String shortText = text.substring(0, maxLength + 1);
        if (text.length() > maxLength)
            return shortText + "...";
        return shortText;
    }

    private static String getPureText(String text, ArrayList<String> worlds) {

        String pureText = new String(text);
        for (int i = 0; i < worlds.stream().count(); i++) {
            pureText = pureText.replace(worlds.get(i), "***");
        }
        return pureText;
    }
}
