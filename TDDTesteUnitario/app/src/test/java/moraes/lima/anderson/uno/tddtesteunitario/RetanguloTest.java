package moraes.lima.anderson.uno.tddtesteunitario;

import org.junit.Test;

import moraes.lima.anderson.uno.tddtesteunitario.forma.Retangulo;

public class RetanguloTest {
    private Retangulo retangulo = new Retangulo();
    private static final int PRECISAO_4_CASAS_DECIMAIS = 4;

    @Test
    public void deveriaCalcularAreaDoRetangulo(){
        double base = 2;
        double altura = 2;

        double area = base * altura;




    }

    @Test
    public void deveriaCalcularPerimetroDoRetangulo(){
        double perimetro  = 2 * retangulo.area();

    }


}
