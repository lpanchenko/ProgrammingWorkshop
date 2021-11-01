package Tasks;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HW2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // Get text data from console input
        String text = getText(sc);
        int maxLength = getMaxLength(sc);
        List<String> badWorlds = getBadWorlds(sc);
        sc.close();

        int length = text.length();
        int lengthWithoutSpaces = (int) text.chars().filter(c -> c != ' ').count();
        String pureText = getPureText(text, (ArrayList<String>) badWorlds);
        String pureShortText = getPureText(getShortText(text, maxLength), (ArrayList<String>) badWorlds);

        JSONObject json = GetJson (text, length, lengthWithoutSpaces, pureText, pureShortText);
        System.out.println(json);
    }

    private static List<String> getBadWorlds(Scanner sc) {
        System.out.println("Enter prohibited words: ");
        List <String> badWorlds = new ArrayList<>();
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (line == null || line.isEmpty())
                break;
            badWorlds.add(line);
        }
        return badWorlds;
    }

    private static int getMaxLength(Scanner sc) {
        System.out.println("Enter max length: ");
        int maxLength = sc.nextInt();
        sc.nextLine();
        return maxLength;
    }

    private static String getText(Scanner sc) {
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        return text;
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

        if (maxLength >= text.length())
            return text;
        return text.substring(0, maxLength + 1) + "...";
    }

    private static String getPureText(String text, ArrayList<String> worlds) {
        String pureText = new String(text);
        for (int i = 0; i < worlds.stream().count(); i++) {
            pureText = pureText.replaceAll("\\b" + worlds.get(i) + "\\b","***");
        }
        return pureText;
    }
}
