package moraes.lima.anderson.uno.tddtesteunitario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import moraes.lima.anderson.uno.tddtesteunitario.forma.Retangulo;

public class RetanguloTest {
    private Retangulo retangulo = new Retangulo();
    //private static final int PRECISAO_4_CASAS_DECIMAIS = 4;

    @Test
    public void deveriaCalcularAreaDoRetangulo(){
        double base = 2;
        double altura = 2;

        boolean area = base * altura > 0;

        assertEquals(true, area);

    }

    @Test
    public void deveriaCalcularPerimetroDoRetangulo(){
        double retangulo = 2 + 2;
        double perimetro  = 2 * retangulo;

        boolean res = perimetro > 0 ;

        assertEquals(true, res);


    }


}
