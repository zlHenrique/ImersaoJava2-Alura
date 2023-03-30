import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // Abrindo conexao HTTP e buscando os TOP10.
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extraindo dados (titulo, poster, classificacao).
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // Exibindo e manipulando os dados.
        for (Map<String, String> filme : listaDeFilmes) {

            String titulo = filme.get("title");
            String urlImagem = filme.get("image");
            System.out.println("Titulo: " + titulo);

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradorFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            double nota = Double.parseDouble(filme.get("imDbRating"));
            double classificacaoEmEstrelas = (double) Math.round(nota / 2.0);
            System.out.print("Avaliação: " + filme.get("imDbRating") + " - ");

            for (int i = 0; i < 5; i++) {
                if(i < classificacaoEmEstrelas) {
                    System.out.print("⭐️");
                } 
            }
            
            System.out.println();
            System.out.println();
        }
    }
}
