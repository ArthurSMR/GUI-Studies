package com.rodrigues.arthur;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaDeMensagem  extends JDialog implements ActionListener {

    private static final long   serialVersionUID = 1L;
    private final JButton           botaoFecha;
    private final JPanel            painelTexto;
    private final JPanel            painelBotoes;
    private final PainelLogoTipo    painelLogoTipo;
    private  final JTextArea        areaTexto;

    TelaDeMensagem(JFrame janelaPrincipal, String titulo, String texto) throws HeadlessException {
        super(janelaPrincipal, titulo);
        setSize(800, 320);
        setResizable(false);
        setLocationRelativeTo(janelaPrincipal);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);

        areaTexto = new JTextArea();
        areaTexto.setText(texto);

        formatAreaTexto();

        painelTexto = new JPanel();
        painelTexto.setBackground(Color.white);

        painelTexto.setBorder(new TitledBorder(new LineBorder(Color.gray),
                                                ConstantesGlobais.nome));

        painelTexto.add(areaTexto);
        add(painelTexto, BorderLayout.CENTER);

        painelLogoTipo = new PainelLogoTipo();
        painelLogoTipo.setPreferredSize(new Dimension(200,200));
        painelLogoTipo.setBorder(new TitledBorder(new LineBorder(Color.gray),
                                                    ConstantesGlobais.escola));
        painelLogoTipo.setBackground(Color.white);
        add(painelLogoTipo, BorderLayout.WEST);

        painelBotoes = new JPanel();
        botaoFecha = new JButton("Fecha");
        botaoFecha.addActionListener(this);
        painelBotoes.add(botaoFecha);
        add(painelBotoes, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
    }

    private void formatAreaTexto() {
        areaTexto.setPreferredSize(new Dimension(580,220));

        areaTexto.setForeground(Color.BLACK);
        areaTexto.setBackground(Color.white);

        areaTexto.setEditable(false);
        areaTexto.setFocusable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        areaTexto.setFont(new Font("Arial", Font.BOLD, 12));
    }
}
