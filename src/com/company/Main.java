package com.company;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        String userName = System.getProperty("user.name");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        int currentHours = Integer.parseInt(LocalTime.now().format(formatter));

        if (currentHours >= 0 && currentHours <= 4)
            System.out.println("Доброй ночи, " + userName);
        else if (currentHours > 4 && currentHours <= 9)
            System.out.println("Доброе утро, " + userName);
        else if (currentHours > 10 && currentHours <= 16)
            System.out.println("Добрый день, " + userName);
        else if (currentHours > 16 && currentHours <= 24)
            System.out.println("Добрый вечер, " + userName);
        else System.out.println("Wrong data format " + currentHours);
    }
}
