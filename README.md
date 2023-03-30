# Imersão Java 

A imersão Java feita pela Alura, consiste em uma semana de aulas e projetos para mergulhar profundamente na lingugem em questão.
Aqui estão os meus projetos e estudos realizados durante essa edição.

## Aula 01 🤔

Começo do projeto
* Na primeira parte deste projeto, consumimos uma API de filmes com JAVA. Usamos a API pública do site IMDB com o endpoint top250movies.

        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

* Extraimos os dados da `URL` e filtramos para usar apenas a parte que nos interessa (dados e ranking dos filmes).

        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

* Manipulamento dos dados extraidos da URL.

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("Nome do Filme: " + filme.get("title"));
            System.out.println(filme.get("image"));
            double nota = Double.parseDouble(filme.get("imDbRating"));

            double classificacaoEmEstrelas = (double) Math.round(nota / 2.0);

            System.out.print("Avaliação: " + filme.get("imDbRating") + " - ");

            for (int i = 0; i < 5; i++) {
                if (i < classificacaoEmEstrelas) {
                    System.out.print("⭐️");
                }
            }

            System.out.println();
            System.out.println();
        }

## Resultados

<div>
    <img src="https://user-images.githubusercontent.com/125168775/228710143-1ba634d2-f812-4fe7-a4b5-8a215ae66db4.png" alt="Resultado da Aula 01">
</div>
    
## Aula 02 🤔
