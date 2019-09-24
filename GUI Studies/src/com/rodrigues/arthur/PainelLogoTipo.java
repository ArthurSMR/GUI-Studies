package com.rodrigues.arthur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class PainelLogoTipo extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public void paint (Graphics g) {
        super.paint(g);
        final Graphics2D auxGraphics = (Graphics2D)g;

        try {
            final URL auxURL = this.getClass().getResource(ConstantesGlobais.arqLogoTipo);
            final Image auxImage = ImageIO.read(auxURL);

            auxGraphics.drawImage(auxImage, 20, 50, 180, 190, 0, 0,
                    auxImage.getHeight(null),
                    auxImage.getWidth(null),
                    null);

        }
        catch (final IOException e) {
            System.out.println(("Arquivo não encontrado" + e.getMessage()));
        }
        catch (Exception e) {
            System.out.println(("Erro ao  carregar arquivo" + e.getMessage()));
        }
    }
}
