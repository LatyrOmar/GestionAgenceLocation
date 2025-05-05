package entite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {
    private Moto moto;
    @BeforeEach
    public void setUp(){
        moto = new Moto("yamaha","cross-2025-YZ","AAA-199",20000,true,600);
    }
    @Test
    public void reductionTest(){
        System.out.println("Test de verification de la réduction de 10% sur une moto");
        double resultat = moto.calculerCout(2);
        assertEquals(36000,resultat,"Le coût de location doit être egale a 38000");
    }
}
