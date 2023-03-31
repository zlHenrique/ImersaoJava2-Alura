import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // Abrindo conexao HTTP e buscando os TOP10.
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // Exibindo e manipulando os dados.;
        ExtratorDeConteudo extrator = new ExtratorConteudoIMDB();
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        for (int i = 0; i < conteudos.size(); i++) {

            Conteudo conteudo = conteudos.get(i);

            var geradora = new GeradorFigurinhas();
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + ".png";
            geradora.cria(inputStream, nomeArquivo, "BORA BILL");

            System.out.println(conteudo.getTitulo());
        }  
    }
}
