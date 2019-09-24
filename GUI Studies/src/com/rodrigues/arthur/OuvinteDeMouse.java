package com.rodrigues.arthur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OuvinteDeMouse implements MouseListener {

    private PainelFundo referencia;

    OuvinteDeMouse(PainelFundo referencia) {
        super();
        this.referencia = referencia;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        referencia.setNewAttractor(e.getPoint());
        referencia.repaint();
    }
}
