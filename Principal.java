import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson; // Importar Gson

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaDivisa consultaDivisa = new ConsultaDivisa();
        boolean continuar = true;

        while (continuar) {
            System.out.println("===== Menú de Conversión de Divisas =====");
            System.out.println("1. USD a EUR");
            System.out.println("2. USD a MXN");
            System.out.println("3. EUR a USD");
            System.out.println("4. Ingresar divisas manualmente");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    consultaDivisa.consultar("USD", "EUR");
                    break;
                case 2:
                    consultaDivisa.consultar("USD", "MXN");
                    break;
                case 3:
                    consultaDivisa.consultar("EUR", "USD");
                    break;
                case 4:
                    System.out.print("Ingrese la divisa origen (ej. USD): ");
                    String from = scanner.next().toUpperCase();
                    System.out.print("Ingrese la divisa destino (ej. EUR): ");
                    String to = scanner.next().toUpperCase();
                    consultaDivisa.consultar(from, to);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }

        scanner.close();
    }
}