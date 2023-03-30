import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradorFigurinhas {

    public void cria(InputStream InputStream, String nomeArquivo) throws IOException {

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(InputStream);

        // cria nova imagem em memoria e com tamanho novo
        int altura = imagemOriginal.getHeight();
        int largura = imagemOriginal.getWidth();
        int novaAltura = altura + 200;
        
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // Configurando a fonta
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 75);
        graphics.setColor(Color.ORANGE);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("SUPINPA", (largura/2)/2, novaAltura-100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

    }
}
