package moraes.lima.anderson.uno.prova01andersonlimaemaiaraborges;

public class RespostasEPerguntas {
    public static final int P2 = 2;
    public static final int P3 = 3;
    public static final int P4 = 4;
    public static final int P5 = 5;
    public static final int P6 = 6;
    public static final String PERGUNTA01 = "";
    public static final String PERGUNTA02 = "Cite pelo menos 3 situações onde a referência THIS pode ser usada. E onde não pode ser usada?";
    public static final String PERGUNTA03 = "Quais detalhes importantes podem ser observados na declaração de uma classe java?";
    public static final String PERGUNTA04 = "Explique o conceito de escopo presente na linguagem java.";
    public static final String PERGUNTA05 = "Como Funciona a sobrecarga (Overload) de métodos no java ?";
    public static final String PERGUNTA06 = "Explique o conceito de Cast. Quais os tipos existentes";
    public static final int R2 = 2;
    public static final int R3 = 3;
    public static final int R4 = 4;
    public static final int R5 = 5;
    public static final int R6 = 6;

    public static final String RESPOSTA01 = "";
    public static final String RESPOSTA02 = "Uma das situções em que ele pode ser usado é quando os objetos tem o mesmo nome, também pode ser usado para referenciar uma variável de forma não ambígua, outra maneira que pode ser utilizado para acessar uma instância dentro de uma classe interna. Não pode ser ultilzado dentro do Main por que ele é Static\n";
    public static final String RESPOSTA03 = "Utiliza-se a palavra reservada \"class\" seguida do nome da classe com letra maiúscula, depois entre as chaves serão definidos os elementos construtores e métodos relacionados a classe. Deve-se respeitar a sintaxe na declaração da classe.\n";
    public static final String RESPOSTA04 = "Escopo é a acessibilidade de objetos, variáveis e funções em diferentes partes do código. É ele quem determina quais dados podem ser acessados em determinadas partes do código.\n";
    public static final String RESPOSTA05 = "Consiste em criar variações de um mesmo método, sendo assim pode-se criar dois ou mais métodos com o mesmo nome na mesma classe desde que tenham tipos e argumentos diferentes.\n";
    public static final String RESPOSTA06 = "Cast é uma coversão que é usada para converter um valor de um tipo para outro tipo. Existem apenas dois tipos de conversão cast, sendo elas Downcast e Upcasting.\n";




    public RespostasEPerguntas() { }

    public String getPerguntas(int numeroDaPergunta){
        String p = "";

        if(numeroDaPergunta == P2){
            p = PERGUNTA02;
        } else if(numeroDaPergunta == P3){
            p = PERGUNTA03;
        }else if(numeroDaPergunta == P4) {
            p = PERGUNTA04;
        }else if(numeroDaPergunta == P5){
            p = PERGUNTA05;
        }else if(numeroDaPergunta == P6){
            p = PERGUNTA06;
        }
        return p;
    }

    public String getRespostas( int numeroDaResposta){
        String r = "";
        if(numeroDaResposta == R2){
            r = RESPOSTA02;

        }else if(numeroDaResposta == R3) {
            r = RESPOSTA03;
        }else if(numeroDaResposta == R4){
            r = RESPOSTA04;
        }else if(numeroDaResposta == R5){
            r = RESPOSTA05;
        }else if (numeroDaResposta == R6){
            r = RESPOSTA06;        }
        return r;
    }









}
