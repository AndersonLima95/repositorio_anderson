package moraes.lima.anderson.uno.tddtesteunitario.forma;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class TrianguloTest {
    private static final int POSICAO_ZERO_TRIANGULO_LADO_1 = 0;
    private static final int POSICAO_UM_TRIANGULO_LADO_2 = 1;
    private static final int POSICAO_DOIS_TRIANGULO_LADO_3 = 2;
    public static final int  DIVIDIDO_POR_DOIS = 2;
    double DIFERENCA_ACEITAVEL = 0.0001;
    private Triangulo triangulo;


    @Before
    public void instanciarObjeto() {
        triangulo = new Triangulo();
    }


    @Test
    public void calcularAreaDoTriangulo(){
        double areaPapel = 9.9216;

        triangulo.setMedida(0, 4);
        triangulo.setMedida(1, 5);
        triangulo.setMedida(2, 6);

        double perimetro = triangulo.getMedida(0) + triangulo.getMedida(1) +
                triangulo.getMedida(2);

        double semiPerimetro = perimetro / 2;


        double area1 = semiPerimetro * (semiPerimetro - triangulo.getMedida(0)) *
                (semiPerimetro - triangulo.getMedida(1)) *
                (semiPerimetro - triangulo.getMedida(2));

        double areaFinal = Math.sqrt(area1);

        Assert.assertEquals("A area do triangulo é: ", areaPapel, areaFinal, DIFERENCA_ACEITAVEL);

    }


}


