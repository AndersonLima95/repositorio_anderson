package moraes.lima.anderson.uno.tddtesteunitario.forma;

//org - nome do pacote (organização)

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CircunferenciaTest {
    private static final int POSICAO_ZERO = 0;
    private static final double EXPOENTE_2 = 2;
    private static Circunferencia circunferencia = new Circunferencia();

    CircunferenciaTest(){
        circunferencia.setMedida(0,2);
    }

    @Test
    //sempre vai ser void - não tem outro retorno
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas() {
        circunferencia.setMedida(0, 3);

        //posição ZERO por se tratar de uma circunferência que precisa de apenas uma informação para calcular a área
        double raio = circunferencia.getMedida(0);

        boolean validacao = raio > 0;

        assertTrue(validacao);

    }


    @Test
    public void deveriaCalcularAreaDaCircunferencia() {
        //o cálculo da área de uma circunferência é dado pela fórmula A = PI * Raio ao quadrado.
        int PRECISAO_4_CASAS_DECIMAIS = 4;

        double area_raio3 = 28.2743;
        double area_raio4 = 50.2655;

        //Raio armazenado na estrutura de dados da classe Pai Forma
        circunferencia.setMedida(POSICAO_ZERO, 4);


        double area = Math.PI * Math.pow(circunferencia.getMedida(POSICAO_ZERO), EXPOENTE_2);


        assertEquals("A área de uma circunferência de raio 3 é 28,2743", area_raio3, area, PRECISAO_4_CASAS_DECIMAIS);
        assertEquals("A área de uma circunferência de raio 4 é 50,2655", area_raio4, area, PRECISAO_4_CASAS_DECIMAIS);

    }
}

