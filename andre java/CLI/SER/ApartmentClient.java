import java.io.*;
import java.net.*;

public class ApartmentClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Solicitar a planta do apartamento
            out.println("getApartmentPlan");

            // Receber e imprimir a resposta do servidor
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println("Resposta do servidor: " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
