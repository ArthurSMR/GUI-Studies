package com.rodrigues.arthur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;

public class JanelaPrincipal extends JFrame implements ActionListener, Runnable{
    // esta  variavel fica para  outro video...
    private static final long serialVersionUID = 1L;

    // atributos encapsulados
    private JPanel    painelStatus;
    private JLabel    labelStatus;
    private String    titulo;
    private JMenuBar  menuBar;
    private JMenu     menuArquivo;
    private JMenu     menuAjuda;
    private JMenuItem menuItemSaida;
    private JMenuItem menuItemVermelho;
    private JMenuItem menuItemVerde;
    private JMenuItem menuItemAzul;
    private JMenuItem menuItemAjuda;
    private JMenuItem menuItemSobre;
    private PainelFundo painelFundo;
    private JScrollPane painelRolagem;
    private OuvinteDeMouse ouvinteDeMouse;
    private OuvinteDeJanela ouvinteDeJanela;

    private boolean rodando; //usado para thread

    JanelaPrincipal() throws HeadlessException {

        super(ConstantesGlobais.getNomeVersao());

        this.rodando = false;

        configuraJanela();
        criaAdicionaMenu();
        adicionaOuvinteMenus(this);
        inicializaAdicionaComponentes();
    }

    private void configuraJanela() {

        // tamanho da janela  em proporção (0.5 x 0.45)
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.45));

        //janela no centro do monitor

        this.setLocationRelativeTo(null);

        //IMPORTANTE
        // impõe que programa TERMINE quando janela for fechada

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Distribuição dos componentes dentro  da janela

        this.setLayout(new BorderLayout(5, 5));

        this.setIconeJanela();
    }

    private void setIconeJanela() {
        try {
            this.setIconImage(ImageIO.read (this.getClass().getResource(ConstantesGlobais.arqLogoTipo)));
        }
        catch (IOException exceptionLaunched) {
            System.out.println("Erro ao carregar icone" + exceptionLaunched);
        }
    }

    private void inicializaAdicionaComponentes()  {
        // area para 'barras de status'
        this.painelStatus = new JPanel();

        // texto inicial da  barra
        this.labelStatus  = new JLabel(this.titulo);

        //importante: adiciona o componente de texto ao painel!
        this.painelStatus.add(labelStatus);

        //perfumaria em geral
        this.painelStatus.setBackground(Color.gray);
        this.painelStatus.setBorder(BorderFactory.createEtchedBorder());

        // IMPORTANTE: adiciona o painel a janela!
        this.add(painelStatus, BorderLayout.SOUTH);

        this.painelFundo = new PainelFundo();
        this.painelRolagem = new JScrollPane(painelFundo,
                                            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(painelRolagem, BorderLayout.CENTER);

        ouvinteDeJanela = new OuvinteDeJanela(this);
        this.addWindowListener(ouvinteDeJanela);

        ouvinteDeMouse = new OuvinteDeMouse(this.painelFundo);
        painelFundo.addMouseListener(ouvinteDeMouse);


    }

    void setMsgStatus(String texto) {
        this.labelStatus.setText(texto);
    }

    void inicia() {
        this.setMsgStatus(ConstantesGlobais.universidade);
        this.setVisible(true);

        this.rodando = true;
        Thread serverDispatcher = new Thread(this);
        serverDispatcher.start();
    }

    private void criaAdicionaMenu() {
        menuArquivo = new JMenu("Arquivo");
        menuArquivo.setMnemonic('A');

        menuItemVermelho = new JMenuItem("Vermelho");
        menuItemVermelho.setMnemonic('V');
        menuArquivo.add(menuItemVermelho);

        menuItemVerde = new JMenuItem("Verde");
        menuItemVerde.setMnemonic('D');
        menuArquivo.add(menuItemVerde);

        menuItemAzul = new JMenuItem("Azul");
        menuItemAzul.setMnemonic('Z');
        menuArquivo.add(menuItemAzul);

        menuArquivo.addSeparator();

        menuItemSaida = new JMenuItem("Saida");
        menuItemSaida.setMnemonic('S');
        menuArquivo.add(menuItemSaida);

        menuAjuda = new JMenu("Ajuda");
        menuAjuda.setMnemonic('J');
        menuItemAjuda = new JMenuItem("Ajuda");
        menuItemAjuda.setMnemonic('U');
        menuAjuda.add(menuItemAjuda);

        menuItemSobre = new JMenuItem("Sobre");
        menuItemSobre.setMnemonic('O');
        menuAjuda.add(menuItemSobre);

        menuBar = new JMenuBar();
        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);

        this.setJMenuBar(menuBar);
    }

    void adicionaOuvinteMenus(ActionListener ouvinte) {
        for (Component menuPrincipal : this.getJMenuBar().getComponents()) {
            if (menuPrincipal  instanceof JMenu) {
                adicionaOuvinteItemMenu(ouvinte, (JMenu) menuPrincipal);
            }
        }
    }

    private  void adicionaOuvinteItemMenu(ActionListener ouvinte, JMenu menuPrincipal) {
        for (Component alvo : menuPrincipal.getMenuComponents()) {
            if(alvo instanceof JMenuItem) {
                ((JMenuItem)alvo).addActionListener(ouvinte);
            }
        }
    }

    void encerraPrograma() {
        this.rodando = false;
        System.exit(NORMAL);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        if(evento.getSource() == menuItemSaida) {
            encerraPrograma();
        }

        if(evento.getSource() == menuItemAjuda) {
            new TelaDeMensagem(this, "Ajuda - " +
                                ConstantesGlobais.getNomeVersao(),
                                ConstantesGlobais.getTextoAjuda() ).setVisible(true);
        }

        if(evento.getSource() == menuItemSobre) {
            new TelaDeMensagem(this, "Sobre - " +
                    ConstantesGlobais.getNomeVersao(),
                    ConstantesGlobais.getTextoSobre() ).setVisible(true);
        }

        if(evento.getSource() == menuItemVermelho) {
            painelFundo.setCorFundo(Color.RED);
        }

        if(evento.getSource() == menuItemVerde) {
            painelFundo.setCorFundo(new Color(32,107,57));
        }

        if(evento.getSource() == menuItemAzul) {
            painelFundo.setCorFundo(Color.BLUE);
        }
    }

    @Override
    public void run() {
        while(this.rodando) {
            painelFundo.repaint();

            try {
                Thread.sleep(1000); // 1000 milisegundos = 1 segundo
            }
            catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

}
