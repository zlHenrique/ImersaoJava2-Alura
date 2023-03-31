import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorConteudoNasa implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudo (String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listaAtributos = parser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();

        //Populando a lista de conteudos
        for (Map<String, String> atributos : listaAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }
        return conteudos; 
    }
}
