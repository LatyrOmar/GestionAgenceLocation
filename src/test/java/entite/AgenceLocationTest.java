package entite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AgenceLocationTest {

    private Client client1;
    private Client client2;
    private AgenceLocation agenceLocation;
    private Voiture voiture;
    private Moto moto;

    @BeforeEach
    public void setUp(){
        agenceLocation = new AgenceLocation();
       client1 = new Client(1,"Diop","Modou","modouDiop@gmail.com");
       client2 = new Client(2,"Ndiaye","Issa","issaNdiaye@gmail.com");
       voiture = new Voiture("BMW","x6","AAA-334",40000,true);
       moto = new Moto("yamaha","cross-2025-YZ","AAA-199",25000,true,600);
    }

    @Test
    public void testAjoutVehiculeEtClient(){
        System.out.println("Test de vérification de l'ajout d'un véhicule.");
        agenceLocation.ajouterVehicule(voiture);
        agenceLocation.ajouterVehicule(moto);

        assertEquals(2, agenceLocation.getVehicules().size(), "Le nombre de véhicules ajoutés doit être égal à 2");
        assertTrue(agenceLocation.getVehicules().contains(voiture), "La voiture doit être présente dans l'agence");
        assertTrue(agenceLocation.getVehicules().contains(moto), "La moto doit être présente dans l'agence");

        System.out.println("Test de vérification de l'ajout d'un client.");
        agenceLocation.ajouterClient(client1);
        agenceLocation.ajouterClient(client2);

        assertEquals(2, agenceLocation.getClients().size(), "Le nombre de clients ajoutés doit être égal à 2");
        assertTrue(agenceLocation.getClients().contains(client1), "Le client doit être présent dans l'agence");
        assertTrue(agenceLocation.getClients().contains(client2), "Le second client doit être présent dans l'agence");

    }

//    @Test
//    public void testAjoutClient() {
//
//    }

    @Test
    public void testEmpecherLocationVehiculeDejaLoue() {

        agenceLocation.louerVehicule(client1, moto,5);

        assertThrows(IllegalStateException.class, () ->
            agenceLocation.louerVehicule(client2, moto,9)
        , "Une exception doit être levée car le véhicule est déjà loué");
    }

    @Test
    public void testVerifierChiffreDaffaire(){
        System.out.println("Test de calcul du chiffre d'affaires total des locations en cours.");
        agenceLocation.louerVehicule(client1,moto,8);
        agenceLocation.louerVehicule(client2,voiture,5);

        assertEquals(380000,agenceLocation.chiffreDaffaire(),"le chiffre d'affaire de l'agence doit être égale à 380 000");

    }

}
