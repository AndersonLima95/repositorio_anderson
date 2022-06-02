package formacao.desenvolvedores.tecnologia.uno.porjetodesoftwareorientadoaobjetos.conceitosintent.utils.app;

import android.content.Context;

public class UtilsApp {
    //Escopo da Classe

    private int soma = 5;

    //SOBRECARGA DE CONSTRUTORES.
    public UtilsApp(){}

    public UtilsApp(int soma) {
        this.soma = soma;
    }

    //SOBRECARGAS DE MÉTODOS (POLIMORFISMO)
    // Converter para tipos primitivos do Java
     public int convertToInt(double valorDouble){

         return (int) valorDouble;
    }

    public int convertToInt(long valorLong){

         return (int) valorLong;
    }

    public int convertToInt(short valorShort){

        return (int) valorShort;
    }

    public int convertToInt(char valorChar){

         return (int) valorChar;
    }

    public int convertToInt(byte valorByte){

         return (int) valorByte;
    }


}
