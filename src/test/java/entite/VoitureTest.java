package entite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest {
    private Voiture voiture;
    @BeforeEach
    public void setUp(){
       voiture = new Voiture("mercedes","GLE","AA-230-AA-TH",30000,true);
    }

    @Test
    public void testCalculerCout(){
        System.out.println("Test de vérification du coût de la location d'une voiture");
        double resultat = voiture.calculerCout(2);
        assertEquals(60000,resultat,"au cas ou le test ne passe pas, Le coût de location doit être egale a 60000.");
    }

}
