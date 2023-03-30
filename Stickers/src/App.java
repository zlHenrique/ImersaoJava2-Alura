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
            double nota = Double.parseDouble(filme.get("imDbRating"));
            double classificacao = (double) Math.round(nota / 2.0);

            System.out.println("Titulo: " + titulo);
            System.out.print("Avaliação: " + filme.get("imDbRating") + " - ");

            for (int i = 0; i < 5; i++) {
                if(i < classificacao) {
                    System.out.print("⭐️");
                } 
            }
            System.out.println("\n");

            String comentario = "";
            if (nota >= 9 || nota <= 10) {
                comentario = "Filme Excelente";
            } else if (nota >= 6 || nota <= 8 ) {
                comentario = "Filme Mediano";
            } else {
                comentario = "Da pro gasto";
            }

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new GeradorFigurinhas();
            geradora.cria(inputStream, nomeArquivo, comentario);
            
        }
    }
}
