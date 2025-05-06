import entite.AgenceLocation;
import entite.Client;
import entite.Voiture;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class GestionLocationStepDefinition {
    private Voiture voiture;
    private Client client1;
    private Client client2;
    private Client client3;
    private AgenceLocation agenceLocation;
    private int nbJours;
    private Exception exception;


    @Given("Une voiture {string} {string} immatriculée {string} avec un tarif de {int} F \\/ j")
    public void une_voiture_immatriculée_avec_un_tarif_de_f_j(String marque, String modele, String immatriculation, int tarifJournalier) {
        voiture = new Voiture(marque,modele,immatriculation,tarifJournalier,true);
        agenceLocation = new AgenceLocation();
        agenceLocation.ajouterVehicule(voiture);

    }
    @Given("Un client {string} {string}")
    public void un_client(String prenom, String nom) {
        client1 = new Client(1,nom,prenom,nom+""+prenom+"@gmail.com");
        agenceLocation.ajouterClient(client1);

    }
    @When("Le client loue la voiture pour {int} jours")
    public void le_client_loue_la_voiture_pour_jours(int nbJours) {
        this.nbJours = nbJours;
        agenceLocation.louerVehicule(client1,voiture,nbJours);

    }
    @Then("La voiture ne doit plus être disponible")
    public void la_voiture_ne_doit_plus_être_disponible() {
        assertFalse(voiture.isDisponible());
    }
    @Then("Le coût total de la location doit être de {int} F")
    public void le_coût_total_de_la_location_doit_être_de_f(int coutAttendu) {
        assertEquals(coutAttendu,voiture.calculerCout(nbJours));

    }

    //Scenario 2

    @When("Un autre client {string} {string} tente de la louer pour {int} jour")
    public void un_autre_client_tente_de_louer_pour_jour(String prenom, String nom,int nbJours){
        client2 = new Client(2,nom,prenom,nom+""+prenom+"@gmail.com");
        try {
            agenceLocation.louerVehicule(client2,voiture,nbJours);
        } catch (Exception e) {
            exception = e;
        }

    }
    @Then("Une exception {string} doit être levée")
    public void une_exception_vehicule_deja_loue_doit_etre_levee(String message){

        assertEquals(message,exception.getMessage() );
    }
//Scénario 3 : Retour de véhicule
    @Given("Une voiture {string} {string} immatriculée {string} louée par {string} {string}")
    public void une_voiture_imatriculee_louee_par(String marque, String modele, String immatriculation, String prenom ,String nom ){
        voiture= new Voiture(marque,modele,immatriculation,3,true);
        client1 =new Client(1,nom,prenom,nom+""+prenom+"@gmail.com");
        agenceLocation = new AgenceLocation();
        agenceLocation.louerVehicule(client1,voiture,nbJours);
        agenceLocation.retournerVehicule(client1,voiture);
    }

    @When("Le client retourne la voiture")
    public void le_client_retourne_la_voiture(){

        agenceLocation.retournerVehicule(client1,voiture);
    }
    @Then("La voiture doit être disponible à nouveau")
    public void la_voiture_doit_etre_disponible_a_nouveau(){
        assertTrue(voiture.isDisponible());
    }


}
