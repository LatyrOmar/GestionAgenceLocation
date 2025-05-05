package entite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {
    private Client client;
    private Client client2;
    private Voiture voiture;
    private Moto moto;
    private Voiture voiture1;
    private AgenceLocation agenceLocation;

    @BeforeEach
    public void setUp(){
        agenceLocation = new AgenceLocation();
        client = new Client(2,"Ndiaye","Moussa","moussaNdiaye@gmail.com");
        voiture = new Voiture("BMW","x6","AAA-334",40000,true);
        voiture1 = new Voiture("Mercedes","GLE","AAA-330",90000,true);

        moto= new Moto("BMW","x6","348574",25000,true,600);
        client2 = new Client(3,"Thiam","Issa","thiamIssa@gmail.com");

        agenceLocation.ajouterVehicule(voiture);
        agenceLocation.ajouterVehicule(moto);
        agenceLocation.ajouterClient(client);

    }

    @Test
    public void testLouerPlusieursvehicules(){
        System.out.println("Test de vérification de la possibilité pour un client de louer plusieurs véhicules.");
        agenceLocation.louerVehicule(client,voiture,12);
        agenceLocation.louerVehicule(client,moto,12);
        agenceLocation.louerVehicule(client,voiture1,30);
        assertEquals(3,client.getVehiculesLoues().size(),"Le nombre de véhicule louer par le client doit être égale a 3");

    }

    @Test
    public void  testAjoutRetraitDeVehicule(){
        System.out.println("Test de vérification de l'ajout d'un véhicule sur la liste des véhicule loué par le client.");
        agenceLocation.louerVehicule(client,moto,13);
        agenceLocation.louerVehicule(client,voiture1,5);
        assertEquals(2,client.getVehiculesLoues().size(),"le nombre de véhicule loués par le client doit être égale à 1");
        assertTrue(client.getVehiculesLoues().contains(moto), "Le véhicule loué doit être présent dans la liste des véhicules loués du client");
        assertTrue(client.getVehiculesLoues().contains(voiture1), "Le véhicule loué doit être présent dans la liste des véhicules loués du client");

        System.out.println("Test de vérification du retrait de véhicule àprès retour.");
        agenceLocation.retournerVehicule(client,moto);

        assertEquals(1,client.getVehiculesLoues().size(),"Apres le retrait du moto le nombre de vehicule loués par ce client doit être null");

    }
    @Test
    public void testRetraitDeVehiculeLouer(){

    }

    @Test
    public void testLocationVehiculeDejasLouer(){
        System.out.println("Test de vérification de l'impossibilité de louer une véhicule déjas loué");
        agenceLocation.louerVehicule(client,moto,3);
//        moto.setDisponible(true);
        assertThrows(IllegalStateException.class,()-> agenceLocation.louerVehicule(client,moto,4),"Une exception doit être levée car le véhicule est déjà loué");

    }
}
