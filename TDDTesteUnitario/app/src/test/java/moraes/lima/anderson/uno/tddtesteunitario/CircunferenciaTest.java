package moraes.lima.anderson.uno.tddtesteunitario;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import moraes.lima.anderson.uno.tddtesteunitario.forma.Circunferencia;

public class CircunferenciaTest {
    private Circunferencia  circunferencia = new Circunferencia(1);;



    @Test
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas(){



        //Posição ZERO por se tratar de uma circunferência que precisa apenas de uma informação calcular a area.

        circunferencia.setMedidas(0,3);

        double raio = circunferencia.getMedida(0);
        boolean x = raio > 0;

        assertTrue(x);
        //assertEquals(true , raio >0);

    }

    @Test
    public void deveruaTerUmLimiteDeTamanhoVetorDeInformacoesDosCaluclosDaArea(){
        //boolean tamanhoValido = circunferencia.setMedidas(0,3) > circunferencia.;



    }





}
