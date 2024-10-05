import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;


public class ConsultaApi {
    public Moneda getMoneda(String moneda){
        try {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5ec7d4d36bb37f95ea8eecbd/latest/"+moneda);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

            HttpResponse<String> response = null;
                response = client 
                    .send(request, HttpResponse.BodyHandlers.ofString());
        
            String json = response.body();
            return new Gson().fromJson(json,Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }   
    
    }
}
