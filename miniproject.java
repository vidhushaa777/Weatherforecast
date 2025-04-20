    import java.util.Random;
    import java.util.Scanner;
    public class miniproject {

        static Scanner scanner = new Scanner(System.in);
        static Random random = new Random();
        static String[] conditions = {"Sunny ☀️", "Cloudy ☁️", "Rainy 🌧️", "Stormy ⛈️", "Windy 🌬️", "Snowy ❄️"};

        public static void main(String[] args) {
            System.out.println("=== Advanced Weather Forecast System with Precautions ===");

            while (true) {
                System.out.print("\nEnter your city name: ");
                String city = scanner.nextLine();

                System.out.print("Enter number of forecast days (1-7): ");
                int days = getValidDays();

                System.out.println("> City: " + city);
                System.out.println("> Forecast for next " + days + " day(s):\n");

                for (int i = 1; i <= days; i++) {
                    generateDailyForecast(i);
                }

                System.out.print("\nWould you like to check another forecast? (yes/no): ");
                String again = scanner.nextLine().toLowerCase();
                if (!again.equals("yes")) {
                    System.out.println("Thank you for using the Weather Forecast System! :) ");
                    break;
                }
            }

            scanner.close();
        }

        static int getValidDays() {
            int days;
            while (true) {
                try {
                    days = Integer.parseInt(scanner.nextLine());
                    if (days >= 1 && days <= 7) {
                        break;
                    } else {
                        System.out.print("Please enter a number between 1 and 7: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Please enter a number: ");
                }
            }
            return days;
        }

        static void generateDailyForecast(int day) {
            String condition = conditions[random.nextInt(conditions.length)];
            int temperature = random.nextInt(21) + 10; // 10°C to 30°C
            int humidity = random.nextInt(41) + 30;    // 30% to 70%
            int windSpeed = random.nextInt(31);        // 0 to 30 km/h
            boolean heavyRain = random.nextBoolean();  // Random heavy rain flag
            boolean coldWave = temperature <= 12;      // Cold wave if temp <= 12

            System.out.println("Day " + day + ":");
            System.out.println("  >> Weather: " + (heavyRain && condition.contains("Rainy") ? "Heavy Rain !!" : condition));
            System.out.println("  >> Temperature: " + temperature + "°C");
            System.out.println("  >> Humidity: " + humidity + "%");
            System.out.println("  >> Wind Speed: " + windSpeed + " km/h");

            providePrecautions(condition, temperature, heavyRain, coldWave);
            System.out.println("---------------------------------------");
        }

        static void providePrecautions(String condition, int temperature, boolean heavyRain, boolean coldWave) {
            System.out.print("  >>> Safety Tip: ");

            if (coldWave) {
                System.out.println("Extreme cold conditions! Stay indoors if possible.");
                System.out.println(" >>> Surface Alert: Roads may be icy or slippery.");
                System.out.println(" >>>> Precautions: Wear warm clothes, gloves, and a sweater.");
            } else if (temperature <= 18) {
                System.out.println("It's cold outside.");
                System.out.println(" >>>> Precautions: Wear a sweater or jacket to stay warm.");
            } else if (temperature >= 30) {
                System.out.println("Very hot weather! Risk of heatstroke.");
                System.out.println("  >>>> Precautions: Stay indoors during afternoon, drink water, wear a cap.");
            } else if (heavyRain) {
                System.out.println("Heavy rainfall expected.");
                System.out.println("  >>> Surface Alert: Roads might be flooded or slippery.");
                System.out.println("  >>>> Precautions: Carry an umbrella, wear waterproof shoes, avoid driving.");
            } else if (condition.contains("Rainy")) {
                System.out.println("Light rain today.");
                System.out.println("  >>> Precautions: Use an umbrella or raincoat.");
            } else if (condition.contains("Stormy")) {
                System.out.println("Stormy weather! Stay safe.");
                System.out.println("  >>> Precautions: Stay indoors, charge your phone, avoid travel.");
            } else if (condition.contains("Snowy")) {
                System.out.println("Snowy conditions ahead.");
                System.out.println("  >>> Surface Alert: Icy roads and footpaths.");
                System.out.println("  >>>> Precautions: Wear warm boots, gloves, and avoid slippery areas.");
            } else if (condition.contains("Windy")) {
                System.out.println("Strong winds blowing today.");
                System.out.println("  >>>> Precautions: Avoid loose clothing outdoors, be careful if cycling.");
            } else {
                System.out.println("Pleasant weather today.");
                System.out.println("  >>>> Precautions: Enjoy your day! Maybe go for a walk.");
            }
        }
    }


