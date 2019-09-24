package com.rodrigues.arthur;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PainelFundo extends JPanel {

    private static final long serialVersionUID = 1L;
    private Color corFrente = Color.white;
    private Color corFundo  = Color.lightGray;
    private Random rand = new Random();

    private int minLinhas;
    private int maxLinhas;
    private int maxAtratores;
    private Point atratores[];

    PainelFundo() {
        super();
        this.setForeground(corFrente);
        this.setBackground(corFundo);

        this.minLinhas= 12;
        this.maxLinhas = 48;

        this.maxAtratores = 4;
        this.atratores = new Point[maxAtratores];
    }

    @Override
    public void paint(Graphics canvasOriginal) {
        super.paint(canvasOriginal);

        Graphics2D canvas = (Graphics2D) canvasOriginal;

        int maxX = this.getWidth();
        int maxY = this.getHeight();

        canvas.drawString("Tamanho do Canvas: " + maxX + "x" + maxY, 20, 20);

        int limite = this.minLinhas + rand.nextInt(this.maxLinhas - this.minLinhas);

        for(int qtasLinhas = 0; qtasLinhas < limite; qtasLinhas++) {

            for(Point atratorCorrente : atratores) {

                if(atratorCorrente != null) {
                    canvas.drawLine((int) atratorCorrente.getX(),
                            (int) atratorCorrente.getY(),
                            rand.nextInt(maxX),
                            rand.nextInt(maxY));
                }
            }
        }

    }

    void setCorFrente(Color novaCor) {
        this.corFrente = novaCor;
        setForeground(this.corFrente);
    }

    void setCorFundo(Color novaCor) {
        this.corFundo = novaCor;
        setBackground(this.corFundo);
    }

    public void setNewAttractor(Point novoAtrator) {

        for(int indice = 0; indice < (atratores.length - 1); indice++) {
            atratores[indice] = atratores[indice + 1];
        }
        atratores[atratores.length - 1] = novoAtrator;
    }
}
