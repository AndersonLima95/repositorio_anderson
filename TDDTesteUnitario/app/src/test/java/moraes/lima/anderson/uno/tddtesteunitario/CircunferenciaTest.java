package moraes.lima.anderson.uno.tddtesteunitario;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import moraes.lima.anderson.uno.tddtesteunitario.forma.Circunferencia;

public class CircunferenciaTest {
    private Circunferencia  circunferencia = new Circunferencia();
    private static final int POSICAO_ZERO = 0;
    private static final int EXPOENTE_2 = 2;
    private static final int PRECISAO_4_CASAS_DECIMAIS = 4;

    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){

        //Posição ZERO por se tratar de uma circunferência que precisa apenas de uma informação calcular a area.

        circunferencia.setMedidas(0,3);

        double raio = circunferencia.getMedida(0);
        boolean x = raio > 0;

        assertTrue(x);
        //assertEquals(true , raio >0);

    }

    /*@Test
    public void deveriaTerUmLimiteDeTamanhoVetorDeInformacoesDosCaluclosDaArea(){
        boolean tamanhoValido = circunferencia.setMedidas(0,3) > circunferencia.getMedida(1);
        assertTrue(tamanhoValido);
 }*/

    @Test
    public void deveriaCalcularAreaDaCircunferencia(){

        /*Raio armazenado na estrutura de dados da Classe pai (Forma) */
        circunferencia.setMedidas(POSICAO_ZERO , 7);

        /* O calulo da área de uma circunferência é dada pela fórumula = A = PI * raio ao quadrado */
        double area  = Math.PI * Math.pow(circunferencia.getMedida(POSICAO_ZERO), EXPOENTE_2);

        /*Valores calculados no papel e canete*/
        double area_raio3 = 28.2743;
        double area_raio5 = 78.53975;
        double area_raio7 = 153.93791;



       /* assertEquals("A área de uma circunferência de raio 3 é 28,2743" , area_raio3 , area , PRECISAO_4_CASAS_DECIMAIS);
        assertEquals("A área de uma circunferência de raio 5 é 78.53975" , area_raio5 , area , PRECISAO_4_CASAS_DECIMAIS);*/
        assertEquals("A área de uma circunferência de raio 7 é 153.93791" , area_raio7 , area , PRECISAO_4_CASAS_DECIMAIS);



    }





}
