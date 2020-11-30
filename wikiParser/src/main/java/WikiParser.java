package main.java;


import org.json.JSONObject; // для работы с json форматом

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;


public class WikiParser {
    private HttpURLConnection connection; // Подключение к серверу
    private String query; // Запрос пользователя
    private String result; // Результат запроса
    final String API = "https://ru.wikipedia.org/w/api.php?"; // API википедии
    /**
     * Составляющие компоненты для GET запроса на api
     */
    final String FIRST_ARGS = "action=query&generator=prefixsearch&gpssearch=";
    final String LAST_ARGS = "&prop=extracts|description&redirects=1&exintro=1&explaintext=1&format=json";

    // Конструктор. Срабатывает при создании класса
    public WikiParser() {
        this.connection = null;
        this.query = null;
    }

    public String makeQuery(String query) throws Exception {

        this.query = query.toLowerCase();

        // Генерируем url для запроса на сервер
        String requestUrl = this.generateRequestUrl(query);

        this.HTTPQuery(requestUrl);
        return this.result;
    }

    private String generateRequestUrl(String query) throws Exception {
        // Кодируем запрос пользователя для корректного запроса к api
        String encode = URLEncoder.encode(query, "UTF-8");

        return (API + FIRST_ARGS + encode + LAST_ARGS);
    }

    private void HTTPQuery(String requestUrl) {
        try {
            // Настройка подключения к серверу
            this.configConnection(requestUrl);

            if (HttpURLConnection.HTTP_OK == this.connection.getResponseCode()) {
                // Если запрос удачный, то получить ответ
                this.result = this.getResult(this.connection.getInputStream());
            } else {
                // Если запрос неудачный, сообщить об ошибке
                this.result = "Ошибка запроса:\n" + "Code: " + this.connection.getResponseCode() + "\nMessage: " + this.connection.getResponseMessage() + "\n";
            }
        } catch (Throwable cause) {
            cause.printStackTrace();
        } finally {
            if (this.connection != null) {
                // В конце запроса, закрываем подключение
                this.connection.disconnect();
            }
        }

    }

    private void configConnection(String requestUrl) throws Exception {
        this.connection = (HttpURLConnection) new URL(requestUrl).openConnection();

        this.connection.setRequestMethod("GET");
        this.connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type", "multipart/form-data, charset=c1251;");

        this.connection.connect();

    }

    private String getResult(InputStream inputStream) throws Exception {
        String result;
        InputStreamReader reader = new InputStreamReader(inputStream, "cp1251");
        BufferedReader in = new BufferedReader(reader);

        String data = in.readLine();
        // Считываем json данные
        JSONObject json = new JSONObject(data);

        // Формирование ответа
        result = "Результаты запроса: \n";
        if (json.has("query")) {
            JSONObject pages = (json.getJSONObject("query").getJSONObject("pages"));
            result += this.generateResponse(pages);
        } else {
            result += "По вашему запросу ничего не найдено.";
        }


        return result;
    }

    // Преобразование json данных в читаемый формат
    private String generateResponse(JSONObject jsonObject) throws Exception {
        String result = "";
        Iterator keys = jsonObject.keys();
        int i = 1;
        while (keys.hasNext()) {
            // Сохраняем результаты поиска в переменную result
            String key = keys.next().toString();
            JSONObject object = jsonObject.getJSONObject(key);
            // Если запрос совпадает с точной статьей в википедии, то на вывод отправляем первый заголовок этой статьи
            if (this.query.equals(object.get("title").toString().toLowerCase())) {
                result = object.get("extract").toString();
                break;
            } else {
                // Создаем нумерованный список статей,подходящих под запрос, с кратким описанием
                result += i + "." + object.get("title") + "\n";
                if (object.has("description")) {
                    result += object.get("description") + "\n";
                }
                result += "\n";
                i++;
            }
        }

        return result;
    }
}
