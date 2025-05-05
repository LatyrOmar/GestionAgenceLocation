package features;

import entite.AgenceLocation;
import entite.Client;
import entite.Voiture;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class GestionLocationStepDefinition {
    private Voiture voiture;
    private Client client1;
    private Client client2;
    private AgenceLocation agenceLocation;


    @Before
    public void setUp(){
        agenceLocation = new AgenceLocation();

    }

    @Given("Une voiture {string} {string} immatriculée {string} avec un tarif de {int} F \\ j")
    public void une_voiture_immatriculée_avec_un_tarif_de_f_j(String marque, String modele, String immatriculation, int tarifJournalier){
        voiture = new Voiture(marque,modele,immatriculation,tarifJournalier,true);
        agenceLocation.ajouterVehicule(voiture);
    }
    @And("Un client {string} {string}")
    public void un_client(String nom, String prenom){
        client1 = new Client(1,nom,prenom, prenom+ "" + nom+ "@gmail.com");
        agenceLocation.ajouterClient(client1);
    }
    @When("Le client loue une voiture pour {int} jours")
    public void le_client_loue_une_voiture(int nbJours){
        agenceLocation.louerVehicule(client1,voiture,nbJours);

    }
    @Then("La voiture ne doit plus être disponible")
    public void la_voiture_ne_doit_plus_etre_disponible(){
       assertFalse(voiture.isDisponible());
    }
    @And("Le coût total de la location doit être de {int}")
    public void le_cout_total_de_la_location_doite_etre(int cout){

        assertEquals(cout,agenceLocation.chiffreDaffaire());
    }

    @When("Un autre client {string} {string} tente de la louer pour {int} jour")
    public void un_autre_client_tente_de_louer(String nom,String prenom, int nbJours){
        client2 = new Client(2,nom,prenom,nom +""+prenom+"@gamil.com");
        agenceLocation.louerVehicule(client2,voiture,nbJours);

    }

    @Then("Une exception {string} doit être levée")
    public void une_exception_doit_être_levée(String string){
        assertThrows(IllegalStateException.class,()->{agenceLocation.louerVehicule(client2,voiture,1);});
    }


}
