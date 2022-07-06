package moraes.lima.anderson.uno.tddtesteunitario.forma;

public class Triangulo extends Forma{
    private static final int TAMANHO_MAXIMO_ARRAY_INFO_CALCULO_AREA = 3;

    public Triangulo() {

        super(TAMANHO_MAXIMO_ARRAY_INFO_CALCULO_AREA);
    }

    @Override
    public double area() {
        double perimetro     = getMedida(0) + getMedida(1) + getMedida(2);

        double semiPerimetro = perimetro / 2;

        double area          = semiPerimetro * (semiPerimetro - getMedida(0)) * (semiPerimetro - getMedida(1))
                * (semiPerimetro - getMedida(2));
        return Math.sqrt(area);
    }


}
