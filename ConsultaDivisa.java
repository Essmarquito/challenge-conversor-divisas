import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {

    HttpClient client = HttpClient.newHttpClient();
    String apiKey = "5c258265002b029cd1ff9a41"; // Coloca tu API key aquí
    Gson gson = new Gson(); // Inicializar Gson

    public void consultar(String from, String to) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + from + "/" + to;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Usar Gson para convertir el JSON en un objeto Java
            ExchangeRateResponse exchangeRate = gson.fromJson(response.body(), ExchangeRateResponse.class);

            // Mostrar la información en consola
            System.out.println("1 " + from + " = " + exchangeRate.conversion_rate + " " + to);

        } catch (Exception e) {
            System.out.println("Error al consultar el tipo de cambio: " + e.getMessage());
        }
    }
}