package Tasks;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;

public class HW4_2 {
/*
Сегодня задача №2 не связана с первой задачей. Сегодня мы напишем функцию, которая снова на вход получает текст и ищет в нем слова паразиты. 
Словами-паразитами называются слова, которые встречаются в тексте >= N раз, где N - целочисленный параметр, который передается вторым параметром в функцию. 
Несколько правил:
- Словом считается любой набор символов, обособленный слева и справа пробелами ИЛИ началом/концом строки.
- Слова с разным регистром считаются одним и тем же словом. То есть предлог "под", который мы можем встретить в середине предложения и "Под" - в начале предложения - одно и то же слово.
- Знаки препинания не учитываются. То есть "привет." и "привет" - это одно и то же слово.
Гарантируется, что текст будет только на русском или английском языках.
Результат вернуть JSON'ом, где ключи - слова-паразиты, а значение - количество раз, которое оно встречается.
Пример:
Дано:
text: "Ну что ж я, я найти решения правильного не смогу ж? Смогу ж конечно, я ж старательный все ж таки."
max_amount: 3

Ответ:
{
"я":3,
"ж":5
}
 */
    
    public static void main(String[] args) {

        String text = "Ну что ж я, я найти решения правильного не смогу ж? Смогу ж конечно, я ж старательный все ж таки.";
        int n = 3;

        JSONObject json = getParasites(text, n);
        System.out.println(json);
    }

    private static JSONObject getParasites(String text, int n) {

        JSONObject result = new JSONObject();

        // Remove all punctuation and convert all worlds to lower case
        String [] arr = text.toLowerCase(Locale.ROOT).replaceAll("[.,!?\\\\-]", "").split(" ");
        HashMap<String, Integer> worlds = new HashMap<>();

        for (var i = 0; i < arr.length; i++) {

            worlds.put(arr[i], worlds.getOrDefault(arr[i], 0) + 1);
        }

        for ( String w: worlds.keySet()) {
            if (worlds.get(w) >= n) {
                result.put(w, worlds.get(w));
            }
        }
        return result;
    }
}
