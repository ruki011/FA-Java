package main.java;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in); // Класс для работы с вводом с консоли
        String query; // Запрос пользователя
        String result; // Результат запроса
        WikiParser parser = new WikiParser(); // Обработчик запросов на api

        System.out.println("Введите запрос: (для выхода из программы введите 0)");
        query = in.nextLine(); // Считываем ввод с консоли
        while (!query.equals("0")) {
            try {
                // Получаем и выводим результат запроса пользователя
                result = parser.makeQuery(query);
                System.out.println(result);
                System.out.println("Введите запрос: (для выхода из программы введите 0)");
                query = in.nextLine();
            } catch (Throwable e) {
                // Ошибки программы
                e.printStackTrace();
            }
        }

    }


}
