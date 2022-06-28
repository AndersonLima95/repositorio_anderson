package moraes.lima.anderson.uno.tddtesteunitario.forma;

public abstract class Forma {
    private int TAMANHO_MAXIMO = 3;
    private double[] numeroDeMedidas;

    public Forma(int numMedidas) {
        numeroDeMedidas = new double[numMedidas];

    }

    public double getMedida(int posicao ){
        if(posicao >= 0 && posicao <= TAMANHO_MAXIMO){
            return numeroDeMedidas[posicao];
        }else
            throw new RuntimeException("Número inválido p/ calculo da área.");



    }

    public void setMedidas(int posicao , double medida){
        numeroDeMedidas[posicao] = medida;

    }


    public abstract double area();
}
