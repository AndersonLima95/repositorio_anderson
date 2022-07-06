package moraes.lima.anderson.uno.tddtesteunitario.forma;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class RetanguloTest {
    private Retangulo retangulo = new Retangulo();
    //private static final int PRECISAO_4_CASAS_DECIMAIS = 4;

    @Test
    public void deveriaCalcularAreaDoRetangulo(){
        double area_BasexAltura = 10;
        double DIFERENCA_ACEITAVEL = 0.001;

        retangulo.setMedida(0,5);
        retangulo.setMedida(1,2);

        double area = retangulo.getMedida(0) * retangulo.getMedida(1);

        assertEquals("A area de uma de um retangulo: " + area_BasexAltura, area_BasexAltura,
                area, DIFERENCA_ACEITAVEL);

        Double calculoPapel = new Double(area_BasexAltura);
        boolean x = calculoPapel.equals(new Double(area));
        assertTrue(x);
    }

    @Test
    public void deveriaCalcularPerimetroDoRetangulo(){
        double perimetro_Base5Altura2  = 20;
        int PRECISAO_4_CASAS_DECIMAIS = 4;

        retangulo.setMedida(0, 5);
        retangulo.setMedida(1, 2);

        double perimetro = retangulo.area() * 2;

        assertEquals("O perimetro de um retangulo de base 5 e altura 2 é: 20", perimetro_Base5Altura2,
                perimetro, PRECISAO_4_CASAS_DECIMAIS);
    }


}
