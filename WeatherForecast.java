import java.util.Scanner;
import java.util.Random;

public class WeatherForecast {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Weather options
        String[] weatherConditions = {
            "Sunny ☀️", "Cloudy ☁️", "Rainy 🌧️", "Stormy ⛈️", "Windy 🌬️", "Snowy ❄️"
        };

        // Temperature range
        int minTemp = 20;
        int maxTemp = 40;

        System.out.println("=== Simple Weather Forecast System ===");
        System.out.print("Enter your city name: ");
        String city = scanner.nextLine();

        // Generate random forecast
        String condition = weatherConditions[random.nextInt(weatherConditions.length)];
        int temperature = random.nextInt(maxTemp - minTemp + 1) + minTemp;

        System.out.println("\n📍 City: " + city);
        System.out.println("🌤️ Forecast: " + condition);
        System.out.println("🌡️ Temperature: " + temperature + "°C");

        System.out.println("\nStay safe and have a great day! 😊");
        
        scanner.close();
    }
}