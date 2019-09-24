package com.rodrigues.arthur;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class OuvinteDeJanela implements WindowListener {

    private JanelaPrincipal referencia;

    OuvinteDeJanela(JanelaPrincipal referencia) {
        this.referencia = referencia;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(this.referencia, "Programa finalizando...",
                ConstantesGlobais.getNomeVersao(),
                JOptionPane.INFORMATION_MESSAGE);

        this.referencia.encerraPrograma();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
