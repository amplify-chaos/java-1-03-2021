package Unit7vol2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParseMethods {
    private static final String API_KEY = "XYHQlFgxfVgXHA2ydmRCbLLAQacY1QbQ";
    private static final String URL_CITY_LIST = "https://dataservice.accuweather.com/locations/v1/topcities/100?apikey=" + API_KEY + "&language=ru-ru";
    private static final String URL_REQUEST_BEGIN = "https://dataservice.accuweather.com/forecasts/v1/daily/5day/";
    private static final String URL_REQUEST_END = "?apikey=" + API_KEY + "&language=ru&metric=true";
    private static String jsonCityList;

    public ParseMethods() {
    }

    public static void initStringJsonCityList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readTree(new URL(URL_CITY_LIST));
        jsonCityList = jsonNode.toString();
    }

    //Создаём список городов
    public static List<City> cityKeysList() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<City> cities = objectMapper.readValue(jsonCityList, new TypeReference<List<City>>() {
        });
        return cities;
    }


    //Находим ключ города по названию
    public static String searchKey(String cityName) throws IOException {
        String key = null;
        ObjectMapper objectMapper = new ObjectMapper();
        List<City> cities = objectMapper.readValue(jsonCityList, new TypeReference<List<City>>() {
        });
        Iterator<City> iterator = cities.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getName().toLowerCase().equals(cityName.toLowerCase())) {
                key = cities.get(counter).getKey();
                break;
            }
            counter++;
        }
        return key;
    }

    public static List<WeatherResponse> listWeatherResponse(String cityName) throws IOException {
        if (ParseMethods.searchKey(cityName) == null) {
            System.out.println("нет города " + cityName + " в базе\nзавершаю работу...");
            System.exit(0);
        }
        String tempCityKey = ParseMethods.searchKey(cityName);
        ObjectMapper objectMapper = new ObjectMapper();
        URL urlForecast = new URL(URL_REQUEST_BEGIN + tempCityKey + URL_REQUEST_END);
        JsonNode jsonNode = objectMapper.readTree(urlForecast).at("/DailyForecasts");
        List<WeatherResponse> forecasts = new ArrayList<>();
        Iterator<WeatherResponse> iterator = forecasts.iterator();
        for (int i = 0; i < 5; i++) {
            forecasts.add(new WeatherResponse());
            forecasts.get(i).setCityName(cityName.substring(0, 1).toUpperCase() + cityName.substring(1));
            forecasts.get(i).setCityKey(tempCityKey);
            forecasts.get(i).setDate(jsonNode.get(i).get("Date").asText());
            forecasts.get(i).setText(jsonNode.get(i).get("Day").get("IconPhrase").asText());
            forecasts.get(i).setTemperature(jsonNode.get(i).get("Temperature").get("Maximum").get("Value").toString());
        }
        return forecasts;
    }

    public static void voidInfo(List<WeatherResponse> forecast) {
        System.out.println(" * * * * * * * * *");
        for (int i = 0; i < 5; i++) {
            System.out.println("В городе " + forecast.get(i).getCityName() + " на дату " + forecast.get(i).getDate().substring(0, 10) + " ожидается " +
                    forecast.get(i).getText().toLowerCase() + ".Температура — " +
                    forecast.get(i).getTemperature() + " градусов." +
                    "\n * * * * * * * * *");
        }
    }

    public static void voidInfo(List<WeatherResponse> forecast, int index) {
        if (index < 5) {
            System.out.println("В городе " +  forecast.get(index).getCityName().substring(0, 1).toUpperCase() + "на дату " + forecast.get(index).getDate().substring(0, 10)
                    + " ожидается " + forecast.get(index).getText().toLowerCase() + ".Температура — " +
                    forecast.get(index).getTemperature() + " градусов." +
                    "\n * * * * * * * * *");
        } else System.out.println("Индекс может быть от 0 до 4");

    }

}
