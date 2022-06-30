package moraes.lima.anderson.uno.tddtesteunitario;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import moraes.lima.anderson.uno.tddtesteunitario.forma.Triangulo;

public class TrianguloTest {

    private Triangulo triangulo = new Triangulo();

    @Test
    public void deveriaCalcularAreaDoTriangulo(){
        double l1 = 1;
        double l2 = 2;
        double l3 = 3;

        double sl = (l1 + l2 + l3)/ 2;
        double area = sl * (sl - l1) * (sl - l2) * (sl - l3);
        boolean areaTri = Math.sqrt(area) > 0 ;

        assertEquals(true , areaTri);





    }

}
