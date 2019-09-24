package com.rodrigues.arthur;

public class ConstantesGlobais {
    public static final String autor = "Arthur Rodrigues";
    public static final String escola = "FT - Faculdade de Tecnologia";
    public static final String universidade = "Unicamp";
    public static final String nome = "Demonstração da Interface Gráfica de Usuário";
    public static final String versao = "Ver. 1.0.5";
    public static final String arqLogoTipo = "logotimao.png";

    public static final String arqIcone = "icone.png";

    static String getTextoSobre() {

        final StringBuffer text = new StringBuffer();

        text.append("\n"); text.append(universidade);
        text.append("\n\n"); text.append(escola);
        text.append("\n\n"); text.append(autor);
        text.append("\n\n"); text.append(nome);
        text.append("\n\n"); text.append(versao);
        text.append("\n");

        return (text.toString());
    }

    static String getTextoAjuda() {
        StringBuilder text = new StringBuilder();

        text.append("\n");
        text.append("Este é um programa simples para exemplo de aplicação Java com interface gráfica. \n");
        text.append("\n");
        text.append("Aviso: este programa foip rojetado e  implementado apenas com fins educacionais. \n");
        text.append("\n");
        text.append("Não há garantia de tipo nenhum, implicíta ou explícita. \n");
        text.append("\n");
        text.append("NÃO use este programa em situações  onde ele p ossa causar ou contribuir para\n");
        text.append(" risco de morte, ferimentos ou danos de  qualquer natureza. \n");
        text.append("\n");

        return  (text.toString());
    }

    static String getNomeVersao() {
        return (nome + "-" + versao);
    }
}
