public class Conteudo {

    private String titulo;
    private String urlImagem;

    public Conteudo (String t, String urlImagem) {
        this.setTitulo(t);
        this.setUrlImagem(urlImagem);
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getUrlImagem() {
        return urlImagem;
    }

    
}


