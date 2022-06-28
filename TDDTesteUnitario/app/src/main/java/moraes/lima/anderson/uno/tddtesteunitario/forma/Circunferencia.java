package moraes.lima.anderson.uno.tddtesteunitario.forma;

public class Circunferencia extends Forma {
    public static final int TAMANHO_ARRAY_INFO_CALCULO_AREA = 1;


    public Circunferencia(int numMedidas) {
        super(numMedidas);
    }

    @Override
    public double area() {
        return 0;
    }

    public int getTamanhoArrayInfoCalculoArea(){

        return TAMANHO_ARRAY_INFO_CALCULO_AREA;
    }
}
