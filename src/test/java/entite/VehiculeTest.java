package entite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculeTest {

    private Voiture voiture;
    private AgenceLocation agenceLocation;
    private Client client;

    @BeforeEach
    public void setUp(){
        agenceLocation = new AgenceLocation();
        voiture = new Voiture("BMW","x6","AAA-334",40000,true);
        client = new Client(1,"Diop","Modou","modouDiop@gmail.com");
//        moto= new Moto("BMW","x6","348574",25000,true,600);
        agenceLocation.ajouterVehicule(voiture);
        agenceLocation.ajouterClient(client);

    }

    @Test
    public void testDisponibiliteVehiculeApresLocation(){
        System.out.println("Test de vérification de l'indisponibilité du véhicule àprès location");
        agenceLocation.louerVehicule(client,voiture,9);

        assertFalse(voiture.isDisponible(),"La vehicule ne doit pas être disponible après location");
    }

    @Test
    public void testDisponibliteApresRetour(){
        System.out.println("Test de vérification de la disponibilité du véhicule après le retour");
        agenceLocation.louerVehicule(client,voiture,4);
        agenceLocation.retournerVehicule(client,voiture);
        assertTrue(voiture.isDisponible(),"le véhicule doit être disponible après retour");
    }

}
