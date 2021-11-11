package Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HW10 {
    /*
    Сегодня пишем банкомат для Сбера. Они, хоть и айти-компания теперь, без нас-то не смогут :)
Надо написать функцию, которая получает на вход сумму, которую банкомат должен выдать. Вернуться должен массив, описывающий - в каких банкнотах мы будем выдавать денежку.
Номиналы возможны следующие - 100, 200, 500, 1000, 2000, 5000
Вторым параметром приходит тип выдачи. Существует два типа - "с разменом" и "крупными". С разменом - это когда мы выдаем минимальными валютами. Крупными - когда выдаем минимальным количеством купюр.
Гарантируется, что сумма придет кратной 100.
     */

    public static void main(String[] args) throws Exception {

        int amount = getAmount();
        boolean withChange = withChange();

        System.out.println(getMoney(amount, withChange));
    }

    private static ArrayList<Integer> getMoney(int amount, boolean withChange) {

        int forIssuing = amount;
        int [] banknotes = new int[]{100, 200, 500, 1000, 2000, 5000};

        ArrayList <Integer> result = new ArrayList<>();

        if (withChange)
        {
            int minBanknote = banknotes[0];
            for (int i = 0; i < forIssuing/minBanknote; i++)
            {
                result.add(minBanknote);
            }
        }
       else {
            for (int i = banknotes.length - 1; i >= 0; i--) {

                int temp = forIssuing / banknotes[i];
                for (int j = 0; j < temp; j++) {
                    result.add(banknotes[i]);
                }
                forIssuing %= banknotes[i];
            }
        }
        return result;
    }

    private static boolean withChange() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Is it type with change? Y/N");

        return br.readLine().equals("Y");
    }

    private static int getAmount() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter amount: ");
        Integer amount = Integer.parseInt(br.readLine());

        if (amount > 2000000000)
            throw new Exception("No such amount of money");

        return amount;
    }
}