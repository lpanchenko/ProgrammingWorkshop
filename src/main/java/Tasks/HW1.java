package Tasks;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HW1 {

    public static void main(String[] args) throws IOException {

        String userName = System.getProperty("user.name");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        int currentHours = Integer.parseInt(LocalTime.now().format(formatter));

        if (currentHours >= 0 && currentHours <= 4)
            System.out.println("Доброй ночи, " + userName);
        else if (currentHours <= 9)
            System.out.println("Доброе утро, " + userName);
        else if ( currentHours <= 16)
            System.out.println("Добрый день, " + userName);
        else if (currentHours <= 23)
            System.out.println("Добрый вечер, " + userName);
        else System.out.println("Wrong data format " + currentHours);
    }

    private static String GetDataTime() throws IOException {
        JSONObject json = readJsonFromUrl("http://worldtimeapi.org/api/ip");
        return (String) json.get("datetime");
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line).append("\n");
            }
            is.close();
            return new JSONObject(sb.toString());
        }
    }
}
