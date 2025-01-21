import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class conversormonedas {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/285b6eb1f07f2797daad0a1b/latest/USD"))
                .header("Accept", "application/json")
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(conversormonedas::filterCurrencies)
                .thenApply(conversormonedas::showMenu)
                .join();
    }

    // Filtra las monedas y extrae las tasas
    private static JsonObject filterCurrencies(String responseBody) {
        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        // Monedas de interés
        String[] currenciesOfInterest = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

        for (String currency : currenciesOfInterest) {
            if (rates.has(currency)) {
                double rate = rates.get(currency).getAsDouble();
                System.out.println(currency + ": " + rate);
            }
        }

        return jsonObject;
    }

    // Muestra el menú interactivo y permite la conversión
    private static JsonObject showMenu(JsonObject jsonObject) {
        Scanner scanner = new Scanner(System.in);
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        while (true) {
            System.out.println("\nMenú de Conversión de Monedas");
            System.out.println("1. Convertir USD a Moneda");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción (1 o 2): ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Ingrese la cantidad en USD: ");
                double amount = scanner.nextDouble();
                System.out.print("Ingrese el código de la moneda de destino (ejemplo: ARS, BOB, BRL, CLP, COP): ");
                String targetCurrency = scanner.next().toUpperCase();

                if (rates.has(targetCurrency)) {
                    double rate = rates.get(targetCurrency).getAsDouble();
                    double convertedAmount = amount * rate;
                    System.out.printf("Resultado de la conversión: %.2f USD = %.2f %s\n", amount, convertedAmount, targetCurrency);
                } else {
                    System.out.println("Moneda no encontrada.");
                }
            } else if (option == 2) {
                System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta pronto!");
                break;
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        return jsonObject;
    }
}
